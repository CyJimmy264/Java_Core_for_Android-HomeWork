package ru.cj264.geekbrains.java_core_for_android.hw11;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {
    ArrayList<T> fruits = new ArrayList<>();

    @SafeVarargs
    public Box(T ...fruits) {
        this.fruits.addAll(Arrays.asList(fruits));
    }

    public double getWeight() {
        double weight = 0;

        if (fruits.size() > 0) {
            if (fruits.get(0) instanceof Apple) {
                weight = fruits.size() * 1f;
            } else if (fruits.get(0) instanceof Orange) {
                weight = fruits.size() * 1.5f;
            }
        }

        return weight;
    }

    public boolean compare(Box<? extends Fruit> box) {
        return getWeight() == box.getWeight();
    }

    public void move(Box<T> box) {
        box.fruits.addAll(fruits);
        fruits.clear();
    }

    @SafeVarargs
    public final void add(T... fruits) {
        this.fruits.addAll(Arrays.asList(fruits));
    }
}
