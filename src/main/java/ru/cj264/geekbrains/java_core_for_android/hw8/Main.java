package ru.cj264.geekbrains.java_core_for_android.hw8;

import java.io.*;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

public class Main {
    public static void createTextFile(String filename, String text) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename)))
        {
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFile(String filename) {
        StringBuilder content = new StringBuilder();

        try (
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8)
                )
        ) {
            CharBuffer buf = CharBuffer.allocate(1024);
            while(reader.read(buf) > 0){
                buf.flip();
                content.append(buf);
                buf.clear();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return content.toString();
    }

    public static void concatFiles(String file1, String file2, String newFile) {
        String content = "";

        content += readFile(file1);
        content += readFile(file2);

        createTextFile(newFile, content);
    }

    public static boolean isFileContainsString(String filename, String sample) {
        try (
                BufferedReader reader = new BufferedReader(new FileReader(filename))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(sample)) return true;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean searchFileWithText(String sample) {
        final boolean[] found = {false};
        try {
            Files.walkFileTree(Paths.get(""), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) {
                    if (isFileContainsString(path.toString(), sample)) {
                        found[0] = true;
                        return FileVisitResult.TERMINATE;
                    } else
                        return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return found[0];
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
        concatFiles("sample1.txt", "sample2.txt", "sample_concat.txt");

        // 3. * Написать метод, который проверяет присутствует ли указанное пользователем слово в файле
        //    (работаем только с латиницей).
        System.out.print("Введите искомое слово: ");
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();

        if (isFileContainsString("sample_concat.txt", word)) {
            System.out.printf("Слово \"%s\" присутствует в файле sample_concat.txt!\n", word);
        } else {
            System.out.println("Не найдено в файле :(");
        }

        // 4. ** Написать метод, проверяющий, есть ли указанное слово в папке
        searchFileWithText(word);
        if (searchFileWithText(word)) {
            System.out.printf("Слово \"%s\" найдено в текущей директории!\n", word);
        } else {
            System.out.println("Не найдено в текущей директории :(");
        }
    }
}
