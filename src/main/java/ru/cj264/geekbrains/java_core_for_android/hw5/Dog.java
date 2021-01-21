package ru.cj264.geekbrains.java_core_for_android.hw5;

public class Dog extends Animal {
    static int dogCount = 0;

    public Dog(String name) {
        super(name);
        runLimit = 500;
        swimLimit = 10;
        dogCount++;
    }

    public static void showCount() {
        System.out.printf("Зарегистрированно %d собак.\n", dogCount);
    }
}
