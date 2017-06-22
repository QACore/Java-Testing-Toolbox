package com.github.qacore.testingtoolbox.junit.runners.parallel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;

import com.github.qacore.testingtoolbox.junit.runners.parallel.ParallelParameterized;
import com.github.qacore.testingtoolbox.junit.runners.schedulers.ParallelScheduler;

import org.junit.runners.ParentRunner;

import support.Fibonacci;

public class ParallelParameterizedTest {

    @Test
    public void parallelSchedulerTest() throws Throwable {
        ParallelParameterized parallelParameterized = new ParallelParameterized(FibonacciTest.class);

        Class<?> clazz = parallelParameterized.getClass();

        while (clazz != ParentRunner.class) {
            clazz = clazz.getSuperclass();
        }

        Field schedulerField = clazz.getDeclaredField("scheduler");
        schedulerField.setAccessible(true);

        assertTrue(schedulerField.get(parallelParameterized) instanceof ParallelScheduler);
    }

    @RunWith(ParallelParameterized.class)
    public static class FibonacciTest {

        @Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][] { { 0, 0 }, { 1, 1 }, { 2, 1 }, { 3, 2 }, { 4, 3 }, { 5, 5 }, { 6, 8 } });
        }

        private int fInput;
        private int fExpected;

        public FibonacciTest(int input, int expected) {
            fInput = input;
            fExpected = expected;
        }

        @Test
        public void test() {
            assertEquals(fExpected, Fibonacci.compute(fInput));
        }

    }

}
