package ru.cj264.geekbrains.java_core_for_android.hw5;

public class Main {
    public static void main(String[] args) {
        Cat barsik = new Cat("Барсик");
        barsik.run(500);
        barsik.swim(10);

        Dog bobik = new Dog("Бобик");
        bobik.run(200);
        bobik.swim(50);
    }
}
