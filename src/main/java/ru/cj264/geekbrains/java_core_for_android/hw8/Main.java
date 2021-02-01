package ru.cj264.geekbrains.java_core_for_android.hw8;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void createTextFile(String filename, String text) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename)))
        {
            writer.write(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // 1. Создать 2 текстовых файла, примерно по 50-100 символов в каждом(особого значения не имеет);
        createTextFile("sample1.txt",
                "1. Создать 2 текстовых файла, примерно по 50-100\n"+
                        " символов в каждом(особого значения не имеет);\n");
        createTextFile("sample2.txt",
                "2. Написать метод, «склеивающий» эти файлы, то есть вначале идет текст из первого файла,\n" +
                        " потом текст из второго.\n");

        // 2. Написать метод, «склеивающий» эти файлы, то есть вначале идет текст из первого файла,
        //    потом текст из второго.
        // 3. * Написать метод, который проверяет присутствует ли указанное пользователем слово в файле
        //    (работаем только с латиницей).
        // 4. ** Написать метод, проверяющий, есть ли указанное слово в папке
    }
}
