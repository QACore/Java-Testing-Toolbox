package com.github.qacore.testingtoolbox.junit.runners;

import org.junit.experimental.categories.Categories;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;

/**
 * An extension of the JUnit {@link Categories} runner, which executes all {@code @Test} methods in parallel. Example:
 * 
 * <pre>
 * &#64;RunWith(ParallelCategories.class)
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
 * @see Categories
 * @see ParallelScheduler
 *
 * @since 1.0.0
 *
 */
public class ParallelCategories extends Categories {

    public ParallelCategories(Class<?> klass, RunnerBuilder builder) throws InitializationError {
        super(klass, builder);

        this.setScheduler(new ParallelScheduler());
    }

}
