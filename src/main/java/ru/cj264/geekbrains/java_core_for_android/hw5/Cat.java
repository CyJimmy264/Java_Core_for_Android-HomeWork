package ru.cj264.geekbrains.java_core_for_android.hw5;

public class Cat extends Animal {
    static int catCount = 0;

    public Cat(String name) {
        super(name);
        runLimit = 200;
        swimLimit = 0;
        catCount++;
    }

    public static void showCount() {
        System.out.printf("Зарегистрированно %d котов.\n", catCount);
    }
}
