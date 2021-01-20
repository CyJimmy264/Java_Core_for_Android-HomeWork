package ru.cj264.geekbrains.java_core_for_android.hw4;

public class Main {
    // 1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
    // 2. Конструктор класса должен заполнять эти поля при создании объекта.
    // 3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
    // 4. Создать массив из 5 сотрудников.
    // 5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("Nazarij", "Gavrilov", "Semenovich",
                        "analyst", "gavrilov.ns@rambler.ru", "+7(928)862-11-31 ",
                        888, 52),
                new Employee("Jeshli", "Kapustina", "Iosifovna",
                        "project manager", "esh.kapustina@yandex.ru", "+7(927)305-37-54",
                        888, 28),
                new Employee("Dominika", "Ignat'eva", "Glebovna",
                        "linguist", "akinimod@mail.ru", "+7(906)293-48-23",
                        888, 42),
                new Employee("Iraklij", "Rusakov", "Protas'evich",
                        "site administrator", "i.rusakov@mail.ru", "+7(915)618-67-59 ",
                        888, 38),
                new Employee("Simona", "Dement'eva", "Ruslanovna",
                        "programmer", "dementyeva.simona@gmail.com", "+7(972)843-27-76",
                        888, 37),
        };

        for (Employee employee : employees) {
            if (employee.getAge() >= 40) {
                employee.printInfo();
                System.out.println();
            }
        }
    }
}
