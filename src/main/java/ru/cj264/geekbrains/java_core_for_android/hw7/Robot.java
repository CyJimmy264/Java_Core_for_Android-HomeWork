package ru.cj264.geekbrains.java_core_for_android.hw7;

public class Robot implements Running {
    String id;

    public Robot(String id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Robot " + id + " runs.");
    }

    @Override
    public void jump() {
        System.out.println("Robot " + id + " jumps.");
    }
}
