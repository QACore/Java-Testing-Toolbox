package com.github.qacore.testingtoolbox.junit.categories;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.github.qacore.testingtoolbox.annotations.Tag;

public class IntegrationTest {

    @Test
    public void hasTag() {
        assertTrue("The 'tag' annotation is not present", Integration.class.isAnnotationPresent(Tag.class));
        assertArrayEquals("The 'tag' annotation doesn't have the expected value", new String[] { "Integration" }, Integration.class.getDeclaredAnnotation(Tag.class).value());
    }

}
