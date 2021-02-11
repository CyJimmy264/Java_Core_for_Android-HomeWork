package ru.cj264.geekbrains.java_core_for_android.hw10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // 1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
        // Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
        // Посчитать, сколько раз встречается каждое слово.

        String[] words = {
            "создать", "массив", "с", "набором", "слов", "слов", "должны", "встречаться", "дубликаты",
            "найти", "вывести", "список", "уникальных", "слов", "из", "которых", "состоит", "массив", "дубликаты",
        };

        HashMap<String, Integer> dict = new HashMap<>();

        Arrays.stream(words).forEach(w -> {
                dict.merge(w, 1, Integer::sum);
        });

        System.out.println("Список уникальных слов:");
        System.out.println(
                dict.entrySet().stream()
                        .filter(e -> e.getValue().equals(1))
                        .map(Map.Entry::getKey)
                        .sorted().collect(Collectors.toList())
        );

        System.out.println("Често встречаемые слова:");
        LinkedHashMap<String, Integer> sortedDict =
                dict.entrySet().stream()
                        .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                                .thenComparing(Map.Entry.comparingByKey()))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        System.out.println(sortedDict);

        // 2. Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров.

        // В этот телефонный справочник с помощью метода add() можно добавлять записи, а с помощью метода get() искать
        // номер телефона по фамилии.

        // Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев), тогда при
        // запросе такой фамилии должны выводиться все телефоны.

        // Желательно не добавлять лишний функционал (дополнительные поля (имя, отчество, адрес), взаимодействие с
        // пользователем через консоль и т.д). Консоль использовать только для вывода результатов проверки телефонного
        // справочника.

        PhoneBook book = new PhoneBook();
        book.add("Johnson", "+195654722");
        book.add("Johnson", "+154715566577");
        book.add("Johnson", "+13214564");
        book.add("Anderson", "+100021455");

        System.out.println("\nPhone book");
        System.out.println("Johnson phone: " + book.get("Johnson"));
        System.out.println("Anderson phone: " + book.get("Anderson"));
    }
}
