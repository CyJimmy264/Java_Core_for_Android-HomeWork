package ru.cj264.geekbrains.java_core_for_android.hw11;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        step1();

        step2();

        step3();
    }

    private static void step3() {
        // a. Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;

        // b. Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта,
        //    поэтому в одну коробку нельзя сложить и яблоки, и апельсины;

        // c. Для хранения фруктов внутри коробки можно использовать ArrayList;

        // d. Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество:
        //    вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);

        // e. Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той,
        //    которую подадут в compare() в качестве параметра.
        //    true – если их массы равны, false в противоположном случае.
        //    Можно сравнивать коробки с яблоками и апельсинами;

        // f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
        //    Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами. Соответственно,
        //    в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;

        // g. Не забываем про метод добавления фрукта в коробку.

        Box<Apple> apples = new Box<>(
                new Apple(),
                new Apple(),
                new Apple()
        );

        Box<Orange> oranges = new Box<>(
                new Orange(),
                new Orange()
        );

        System.out.println("Apples box weight: " + apples.getWeight());
        System.out.println("Oranges box weight: " + oranges.getWeight());
        System.out.println("Compare weights: " + apples.compare(oranges));
    }

    private static void step2() {
        // 2. Написать метод, который преобразует массив в ArrayList;
        int[] ints = {1, 2, 3, 4, 5};
        String[] strings = {"A", "B", "C", "D", "E"};

        ArrayList<Integer> alInts = arrayToArrayList(ArrayUtils.toObject(ints));
        ArrayList<String> alStrings = arrayToArrayList(strings);

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
