package ru.cj264.geekbrains.java_core_for_android.hw11;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        step1();

        step2();
    }

    private static void step2() {
        // 2. Написать метод, который преобразует массив в ArrayList;
        int[] ints = {1, 2, 3, 4, 5};
        String[] strings = {"A", "B", "C", "D", "E"};

        ArrayList alInts = arrayToArrayList(ArrayUtils.toObject(ints));
        ArrayList alStrings = arrayToArrayList(strings);

        System.out.println(alInts);
        System.out.println(alStrings);
    }

    public static <E> ArrayList<E> arrayToArrayList(E[] arr) {
        ArrayList<E> result = new ArrayList<>();
        for (E e : arr) {
            result.add(e);
        }
        return result;
    }

    private static void step1() {
        // 1. Написать метод, который меняет два элемента массива местами
        //    (массив может быть любого ссылочного типа);
        ArrayList<String> strings = new ArrayList<>(Arrays.asList("three", "two", "one"));
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(2, 4, 6));

        swap(strings, 0, 2);
        swap(integers, 1, 2);

        System.out.println(strings);
        System.out.println(integers);
    }

    public static <E> void swap(ArrayList<E> arr, int index1, int index2) {
        E tmpElement = arr.get(index1);
        arr.set(index1, arr.get(index2));
        arr.set(index2, tmpElement);
    }
}
