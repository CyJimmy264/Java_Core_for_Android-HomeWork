package ru.cj264.geekbrains.java_core_for_android.hw12;

import java.util.Arrays;

public class Main {
    static final int SIZE = 10_000_000;


    public static void main(String[] args) {
        // Необходимо написать два метода, которые делают следующее:
        // 1) Создают одномерный длинный массив.
        // 2) Заполняют этот массив единицами.
        // 3) Засекают время выполнения: long a = System.currentTimeMillis().
        // 4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле.
        // 5) Проверяется время окончания метода System.currentTimeMillis().
        // 6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a).
    }

    public static void calculateSingle() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + (float) i / 5) *
                    Math.cos(0.2f + (float) i / 5) * Math.cos(0.4f + (float) i / 2));
        }

        System.out.println("calculateSingle time: " + (System.currentTimeMillis() - startTime));
    }

    public static void calculateMultiThread(int threadsNumber) {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + (float) i / 5) *
                    Math.cos(0.2f + (float) i / 5) * Math.cos(0.4f + (float) i / 2));
        }

        System.out.println("calculateMultiThread time: " + (System.currentTimeMillis() - startTime));
    }
}
