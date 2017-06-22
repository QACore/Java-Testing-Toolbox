package com.github.qacore.testingtoolbox.junit.runners.schedulers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import org.junit.runners.model.RunnerScheduler;

import com.github.qacore.testingtoolbox.JavaTestingToolbox;

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

    private static ExecutorService EXECUTOR_SERVICE;

    public static synchronized final ExecutorService getExecutorService() {
        if (EXECUTOR_SERVICE == null) {
            EXECUTOR_SERVICE = Executors.newFixedThreadPool(JavaTestingToolbox.getConfiguration().junit().getTotalTestThreads(), new ThreadFactory() {

                @Override
                public Thread newThread(Runnable r) {
                    Thread thread = Executors.defaultThreadFactory().newThread(r);
                    thread.setName("JUnit-" + thread.getName());
                    thread.setDaemon(true);

                    return thread;
                }

            });
        }

        return EXECUTOR_SERVICE;
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
            ParallelScheduler.getExecutorService().invokeAll(this.getChildStatements());
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
