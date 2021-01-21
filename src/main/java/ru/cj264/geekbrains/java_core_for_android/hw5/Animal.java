package ru.cj264.geekbrains.java_core_for_android.hw5;

public class Animal {
    String name;

    public Animal() {
    }

    public Animal(String name) {
        this.name = name;
    }

    public void run(int distance) {
        System.out.printf("%s пробежал %d м.\n", name, distance);
    }

    public void swim(int distance) {
        System.out.printf("%s проплыл %d м.\n", name, distance);
    }
}
