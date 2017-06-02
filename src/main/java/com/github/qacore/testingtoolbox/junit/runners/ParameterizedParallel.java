package com.github.qacore.testingtoolbox.junit.runners;

import org.junit.runners.Parameterized;

/**
 * An extension of the JUnit {@link Parameterized} runner, which executes all {@code @Test} methods in parallel. Example:
 * 
 * <pre>
 * &#64;RunWith(ParameterizedParallel.class)
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
 * @see Parameterized
 * @see ParallelScheduler
 *
 */
public class ParameterizedParallel extends Parameterized {

    public ParameterizedParallel(Class<?> klass) throws Throwable {
        super(klass);

        this.setScheduler(new ParallelScheduler());
    }

}
