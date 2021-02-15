package ru.cj264.geekbrains.java_core_for_android.hw11;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    ArrayList<T> fruits = new ArrayList<>();

    public Box(T ...fruits) {
        for (T fruit : fruits) {
            this.fruits.add(fruit);
        }
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
}
