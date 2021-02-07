package ru.cj264.geekbrains.java_core_for_android.hw9;

import java.time.LocalDate;

public class Cat {
    String name;
    LocalDate birthday;
    String color;
    String breed;

    public Cat(String name, LocalDate birthday, String color, String breed) {
        this.name = name;
        this.birthday = birthday;
        this.color = color;
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", color='" + color + '\'' +
                ", breed='" + breed + '\'' +
                '}';
    }
}
