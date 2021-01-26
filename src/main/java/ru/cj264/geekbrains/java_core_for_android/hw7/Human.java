package ru.cj264.geekbrains.java_core_for_android.hw7;

public class Human implements Running {
    String name;

    public Human(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " runs.");
    }

    @Override
    public void jump() {
        System.out.println(name + " jumps.");
    }
}
