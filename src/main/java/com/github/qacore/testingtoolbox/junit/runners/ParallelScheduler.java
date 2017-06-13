package com.github.qacore.testingtoolbox.junit.runners;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import org.junit.runners.model.RunnerScheduler;

/**
 * Support scheduler for parallel tests.
 * 
 * @author Leonardo Carmona da Silva
 *         <ul>
 *         <li><a href="https://br.linkedin.com/in/l3ocarmona">https://br.linkedin.com/in/l3ocarmona</a></li>
 *         <li><a href="https://github.com/leocarmona">https://github.com/leocarmona</a></li>
 *         <li><a href="mailto:lcdesenv@gmail.com">lcdesenv@gmail.com</a></li>
 *         </ul>
 *
 * @since 1.0.0
 *
 */
public class ParallelScheduler implements RunnerScheduler {

    public static final ExecutorService EXECUTOR_SERVICE;
    public static final int             TEST_THREADS_COUNT;

    static {
        BigDecimal availableProcessors = new BigDecimal(String.valueOf(Runtime.getRuntime().availableProcessors()));
        BigDecimal parallelTestThreadsPerCore = new BigDecimal(System.getProperty("toolbox.parallelTestThreadsPerCore", "1"));
        BigDecimal availableThreads = availableProcessors.multiply(parallelTestThreadsPerCore).setScale(0, BigDecimal.ROUND_HALF_EVEN);
        int threads = availableThreads.intValue();

        if (threads < 1)
            threads = 1;

        TEST_THREADS_COUNT = threads;
        EXECUTOR_SERVICE = Executors.newFixedThreadPool(TEST_THREADS_COUNT, new ThreadFactory() {

            @Override
            public Thread newThread(Runnable r) {
                Thread thread = Executors.defaultThreadFactory().newThread(r);
                thread.setName("JUnit-" + thread.getName());
                thread.setDaemon(true);

                return thread;
            }

        });
    }

    private List<Callable<Void>> childStatements = new ArrayList<>();

    @Override
    public void schedule(Runnable childStatement) {
        this.getChildStatements().add(new Callable<Void>() {

            @Override
            public Void call() throws Exception {
                childStatement.run();

                return null;
            }

        });
    }

    @Override
    public void finished() {
        try {
            EXECUTOR_SERVICE.invokeAll(this.getChildStatements());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<Callable<Void>> getChildStatements() {
        return childStatements;
    }

    public void setChildStatements(List<Callable<Void>> childStatements) {
        this.childStatements = childStatements;
    }

}
