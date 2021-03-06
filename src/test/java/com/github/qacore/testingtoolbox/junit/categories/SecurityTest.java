package com.github.qacore.testingtoolbox.junit.categories;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.github.qacore.testingtoolbox.annotations.Tag;

public class SecurityTest {

    @Test
    public void hasTag() {
        assertTrue("The 'tag' annotation is not present", Security.class.isAnnotationPresent(Tag.class));
        assertArrayEquals("The 'tag' annotation doesn't have the expected value", new String[] { "Security" }, Security.class.getDeclaredAnnotation(Tag.class).value());
    }

}
