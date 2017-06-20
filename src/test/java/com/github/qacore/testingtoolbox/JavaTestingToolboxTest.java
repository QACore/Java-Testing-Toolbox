package com.github.qacore.testingtoolbox;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.github.qacore.testingtoolbox.junit.runners.Parallel;

@RunWith(Parallel.class)
public class JavaTestingToolboxTest {

    @Test
    public void privateConstructorTest() throws Exception {
        Constructor<?> emptyPrivateConstructor = JavaTestingToolbox.class.getDeclaredConstructor();

        assertEquals(1, JavaTestingToolbox.class.getDeclaredConstructors().length);
        assertTrue(Modifier.isPrivate(emptyPrivateConstructor.getModifiers()));

        emptyPrivateConstructor.setAccessible(true);
        emptyPrivateConstructor.newInstance();
    }

    @Test
    public void getConfigurationTest() {
        assertNotNull(JavaTestingToolbox.getConfiguration());
        assertNotNull(JavaTestingToolbox.getConfiguration().junit());
    }

}
