package ru.cj264.geekbrains.java_core_for_android.hw12;

import java.lang.reflect.Array;
import java.util.ArrayList;
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

        float[] result1;
        float[] result2;

        System.out.println("No threads:");
        result1 = calculateSingle();

        for (int i = 1; i <= 8; i++) {
            System.out.println("\n=================\n\nWith " + i + " threads!");
            result2 = calculateMultiThread(i);
            System.out.println("Results equal: " + Arrays.equals(result1, result2));
        }
    }

    public static float[] calculateSingle() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + (float) i / 5) *
                    Math.cos(0.2f + (float) i / 5) * Math.cos(0.4f + (float) i / 2));
        }

        System.out.println("calculateSingle time: \t\t" + (System.currentTimeMillis() - startTime));
        return arr;
    }

    public static float[] calculateMultiThread(int threadsNumber) {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);

        long startTime = System.currentTimeMillis();

        int partLength = SIZE / threadsNumber;

        ArrayList<float[]> arrays = new ArrayList<>();
        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 1; i <= threadsNumber; i++) {
            int currentLength = (i < threadsNumber) ? partLength : partLength + SIZE % threadsNumber;
            float[] part = new float[currentLength];
            System.arraycopy(arr, 0, part, 0, currentLength);
            arrays.add(part);
        }

        System.out.println("Array splitting time: " + (System.currentTimeMillis() - startTime));

        long calculateStartTime = System.currentTimeMillis();

        for (int j = 0; j < threadsNumber; j++) {
            int tj = j;
            Thread thread = new Thread(() -> {
                float[] part = arrays.get(tj);
                for (int i = 0; i < part.length; i++) {
                    int relativeI = i + tj * partLength;
                    part[i] = (float) (part[i] * Math.sin(0.2f + (float) relativeI / 5) *
                            Math.cos(0.2f + (float) relativeI / 5) * Math.cos(0.4f + (float) relativeI / 2));
                }

            });
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Calculation time: " + (System.currentTimeMillis() - calculateStartTime));

        long concatStartTime = System.currentTimeMillis();

        for (int i = 0; i < threadsNumber; i++) {
            float[] part = arrays.get(i);

            System.arraycopy(part, 0, arr, i * partLength, part.length);
        }

        System.out.println("Concatenation time: " + (System.currentTimeMillis() - concatStartTime));

        System.out.println("calculateMultiThread total time: \t" + (System.currentTimeMillis() - startTime));
        return arr;
    }
}
