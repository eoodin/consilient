package org.consilient.core;

public class LifecycleFactory {

    public static Lifecycle createLifecycle() {
        Lifecycle lifecycle = new Lifecycle();
        lifecycle.setScanner(new Scanner());
        return lifecycle;
    }
}
