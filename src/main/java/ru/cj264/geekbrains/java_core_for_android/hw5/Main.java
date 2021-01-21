package ru.cj264.geekbrains.java_core_for_android.hw5;

public class Main {
    public static void main(String[] args) {
        Cat barsik = new Cat("Барсик");
        barsik.run(50);
        barsik.swim(1);

        Dog bobik = new Dog("Бобик");
        bobik.run(700);
        bobik.swim(5);

        Animal.showCount();
        Cat.showCount();
        Dog.showCount();
    }
}
