package ru.cj264.geekbrains.java_core_for_android.hw7;

public interface Running {
    String getName();

    default void run() {
        System.out.println(getName() + " runs.");
    }

    default void jump() {
        System.out.println(getName() + " jumps.");
    }
}
