package ru.cj264.geekbrains.java_core_for_android.hw4;

public class Main {

    // 1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
    // 2. Конструктор класса должен заполнять эти поля при создании объекта.
    // 3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
    // 4. Создать массив из 5 сотрудников.
    // 5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
    public static void main(String[] args) {
        Employee first = new Employee("Maksim", "Veynberg", "Evgen'evich",
                "programmer", "mv@cj264.ru", "+7(908)252-33-66", 888, 36);
        first.printInfo();
    }
}
