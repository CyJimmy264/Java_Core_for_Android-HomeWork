package ru.cj264.geekbrains.java_core_for_android.hw10;

import java.util.HashSet;

public class Phones {
    HashSet<String> phones = new HashSet<>();

    public void add(String phone) {
        phones.add(phone);
    }

    @Override
    public String toString() {
        return String.join(", ", phones);
    }
}
