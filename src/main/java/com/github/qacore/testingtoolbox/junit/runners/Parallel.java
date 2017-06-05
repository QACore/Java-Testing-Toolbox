package com.github.qacore.testingtoolbox.junit.runners;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

/**
 * An extension of the JUnit {@link BlockJUnit4ClassRunner} runner, which executes all {@code @Test} methods in parallel. Example:
 * 
 * <pre>
 * &#64;RunWith(Parallel.class)
 * public class FooTest {
 *    ...
 * }
 * </pre>
 * 
 * @author Leonardo Carmona da Silva
 *         <ul>
 *         <li><a href="https://br.linkedin.com/in/l3ocarmona">https://br.linkedin.com/in/l3ocarmona</a></li>
 *         <li><a href="https://github.com/leocarmona">https://github.com/leocarmona</a></li>
 *         <li><a href="mailto:lcdesenv@gmail.com">lcdesenv@gmail.com</a></li>
 *         </ul>
 * 
 * @see BlockJUnit4ClassRunner
 * @see ParallelScheduler
 * 
 * @since 1.0.0
 *
 */
public class Parallel extends BlockJUnit4ClassRunner {

    public Parallel(Class<?> klass) throws InitializationError {
        super(klass);

        this.setScheduler(new ParallelScheduler());
    }

}
