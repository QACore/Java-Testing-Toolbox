package com.github.qacore.testingtoolbox.junit.runners;

import org.junit.experimental.runners.Enclosed;
import org.junit.runners.model.RunnerBuilder;

/**
 * An extension of the JUnit {@link Enclosed} runner, which executes all {@code @Test} methods in parallel. Example:
 * 
 * <pre>
 * &#64;(EnclosedParallel.class)
 * public class ListTests {
 *    ...useful shared stuff...
 *    public static class OneKindOfListTest {...}
 *    public static class AnotherKind {...}
 *    abstract public static class Ignored {...}
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
 * @see Enclosed
 * @see ParallelScheduler
 *
 */
public class EnclosedParallel extends Enclosed {

    public EnclosedParallel(Class<?> klass, RunnerBuilder builder) throws Throwable {
        super(klass, builder);

        this.setScheduler(new ParallelScheduler());
    }

}
