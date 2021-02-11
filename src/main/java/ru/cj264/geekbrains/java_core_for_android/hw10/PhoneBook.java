package ru.cj264.geekbrains.java_core_for_android.hw10;

import java.util.HashMap;

public class PhoneBook {
    HashMap<String, Phones> book = new HashMap<>();

    public void add(String name, String phone) {
        book.putIfAbsent(name, new Phones());
        book.get(name).add(phone);
    }

    public String get(String name) {
        return book.get(name).toString();
    }
}
