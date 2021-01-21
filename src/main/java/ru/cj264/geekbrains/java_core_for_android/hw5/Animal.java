package ru.cj264.geekbrains.java_core_for_android.hw5;

public class Animal {
    String name;
    int runLimit = 1_000_000;
    int swimLimit = 1_000_000;
    static int animalCount = 0;

    public Animal() {
        animalCount++;
    }

    public Animal(String name) {
        this();
        this.name = name;
    }

    public void run(int distance) {
        if (distance <= runLimit)
            System.out.printf("%s пробежал %d м.\n", name, distance);
        else
            System.out.printf("%s не может пробежать %d м.\n", name, distance);
    }

    public void swim(int distance) {
        if (distance <= swimLimit)
            System.out.printf("%s проплыл %d м.\n", name, distance);
        else
            System.out.printf("%s не может проплыть %d м.\n", name, distance);
    }

    public static void showCount() {
        System.out.printf("Зарегистрированно %d животных.\n", animalCount);
    }
}
