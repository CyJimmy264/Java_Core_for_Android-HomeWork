package ru.cj264.geekbrains.java_core_for_android.hw12;

import java.util.Arrays;

public class Main {
    static final int SIZE = 10_000_000;


    public static void main(String[] args) {
        // Необходимо написать два метода, которые делают следующее:
        // 1) Создают одномерный длинный массив.
        // 2) Заполняют этот массив единицами.
    }

    public static void calculateSingle() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);

    }

    public static void calculateMultiThread() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);

    }
}
