package ru.cj264.geekbrains.java_core_for_android.hw7;

public class Cat implements Running {
    String name;

    public Cat(String name) { this.name = name; }

    @Override
    public String getName() { return name; }
}
