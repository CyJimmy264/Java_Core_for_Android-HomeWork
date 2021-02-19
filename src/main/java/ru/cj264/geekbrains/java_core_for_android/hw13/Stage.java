package ru.cj264.geekbrains.java_core_for_android.hw13;

public abstract class Stage {
    protected int length;
    protected String description;
    public String getDescription() {
        return description;
    }
    public abstract void go(Car c);
}
