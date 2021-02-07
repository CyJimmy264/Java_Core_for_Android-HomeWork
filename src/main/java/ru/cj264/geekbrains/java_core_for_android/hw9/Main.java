package ru.cj264.geekbrains.java_core_for_android.hw9;

import java.time.LocalDate;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // 1. Создать класс кота
        // 2. Создать в бд таблицу с котами
        // 3. Написать метод извлечения котов
        // 4. Метод добавления котов
        // 5. Метод удаления котов
        // 6. Метод изменения котов

        Cat cat = new Cat("Barsik", LocalDate.of(2007, 11, 13),
                "white and black", "siamese");
        System.out.println(cat);
    }
}
