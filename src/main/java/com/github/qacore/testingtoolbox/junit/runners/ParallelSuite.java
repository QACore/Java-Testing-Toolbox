package com.github.qacore.testingtoolbox.junit.runners;

import java.util.List;

import org.junit.runner.Runner;
import org.junit.runners.Suite;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;

/**
 * An extension of the JUnit {@link Suite} runner, which executes all {@code @Test} methods in parallel. Example:
 * 
 * <pre>
 * &#64;RunWith(ParallelSuite.class)
 * &#64;SuiteClasses({TestClass1.class, ...})
 * public class FooTest {
 *    ...
 * }
 * </pre>
 * 
 * @author Leonardo Carmona da Silva
 *         <ul>
 *         <li><a href="https://br.linkedin.com/in/l3ocarmona">https://br.linkedin.com/in/l3ocarmona</a></li>
 *         <li><a href="mailto:lcdesenv@gmail.com">lcdesenv@gmail.com</a></li>
 *         </ul>
 * 
 * @see Suite
 * @see ParallelScheduler
 * 
 */
public class ParallelSuite extends Suite {

    public ParallelSuite(Class<?> klass, Class<?>[] suiteClasses) throws InitializationError {
        super(klass, suiteClasses);

        this.setScheduler(new ParallelScheduler());
    }

    public ParallelSuite(Class<?> klass, List<Runner> runners) throws InitializationError {
        super(klass, runners);

        this.setScheduler(new ParallelScheduler());
    }

    public ParallelSuite(Class<?> klass, RunnerBuilder builder) throws InitializationError {
        super(klass, builder);

        this.setScheduler(new ParallelScheduler());
    }

    public ParallelSuite(RunnerBuilder builder, Class<?> klass, Class<?>[] suiteClasses) throws InitializationError {
        super(builder, klass, suiteClasses);

        this.setScheduler(new ParallelScheduler());
    }

    public ParallelSuite(RunnerBuilder builder, Class<?>[] classes) throws InitializationError {
        super(builder, classes);

        this.setScheduler(new ParallelScheduler());
    }

}
