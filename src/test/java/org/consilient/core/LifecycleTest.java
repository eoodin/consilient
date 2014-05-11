package org.consilient.core;


import org.junit.Test;
import static org.junit.Assert.*;

public class LifecycleTest {

    @Test
    public void createLifeCycle() {
        Lifecycle lifecycle = LifecycleFactory.createLifecycle();
        assertNotNull(lifecycle);
    }

    @Test
    public void lifecycleShouldHasScanner() {
        Lifecycle lifecycle = LifecycleFactory.createLifecycle();
        assertNotNull(lifecycle.getScanner());
    }
}
