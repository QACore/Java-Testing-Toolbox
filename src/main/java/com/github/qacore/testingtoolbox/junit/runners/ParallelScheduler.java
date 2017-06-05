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
class ParallelScheduler implements RunnerScheduler {

    protected static final ExecutorService EXECUTOR_SERVICE;

    static {
        BigDecimal availableProcessors = new BigDecimal(String.valueOf(Runtime.getRuntime().availableProcessors()));
        BigDecimal parallelTestThreadsPerCore = new BigDecimal(System.getProperty("parallelTestThreadsPerCore", "1"));
        BigDecimal availableThreads = availableProcessors.multiply(parallelTestThreadsPerCore).setScale(0, BigDecimal.ROUND_HALF_EVEN);
        int threads = availableThreads.intValue();

        if (threads < 1)
            threads = 1;

        EXECUTOR_SERVICE = Executors.newFixedThreadPool(threads, new ThreadFactory() {

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
        childStatements.add(new Callable<Void>() {

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
            EXECUTOR_SERVICE.invokeAll(childStatements);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected List<Callable<Void>> getChildStatements() {
        return childStatements;
    }

    protected void setChildStatements(List<Callable<Void>> childStatements) {
        this.childStatements = childStatements;
    }

}
