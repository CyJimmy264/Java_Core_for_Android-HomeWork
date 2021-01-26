package ru.cj264.geekbrains.java_core_for_android.hw7;

public class Main {

    public static void obstacleCourse() {
        Runner[] runners = {
                new Human("Adam", 60, 200),
                new Cat("Pushok", 150, 100),
                new Robot("707", 50, 400),
        };

        TrackPart[] obstacleCourse = {
                new Track(50),
                new Barrier(20),
                new Track(200),
                new Barrier(40),
                new Track(20),
                new Barrier(55),
                new Track(80),
                new Barrier(49),
                new Track(90),
                new Barrier(55),
                new Track(200),
        };

        for (TrackPart trackPart : obstacleCourse) {
            for (Runner runner : runners) {
                runner.pass(trackPart);
            }
        }
    }

    public static void sumTwoDimensionStringArray(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        if (arr.length != 4)
            throw new MyArraySizeException();
        else {
            for (String[] strings : arr) {
                if (strings.length != 4) throw new MyArraySizeException();
            }
        }

        int sum = 0;

        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < arr.length; i++) {
                try {
                    sum += Integer.parseInt(arr[j][i]);
                } catch (Exception e) {
                    throw new MyArrayDataException(String.format("%s at array cell [%d][%d]", e.getMessage(), j, i));
                }
            }
        }
        System.out.println("Array sum: " + sum);
    }

    public static void arrayConversion() {
        String[][] arr1 = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"},
        };

        String[][] arr2 = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"},
                {"1", "2", "3", "4"},
        };

        String[][] arr3 = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16", "17"},
        };

        String[][] arr4 = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", null, "12"},
                {"13", "14", "15", "16"},
        };

        String[][] arr5 = {
                {"1", "u2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"},
        };

        String[][][] arrays = {arr1, arr2, arr3, arr4, arr5};

        for (String[][] arr : arrays) {
            try{
                sumTwoDimensionStringArray(arr);
            } catch (MyArraySizeException e) {
                System.out.println(e.getMessage());
            } catch (MyArrayDataException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        // 1. Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса.
        //    Эти классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в консоль).

        // 2. Создайте два класса: беговая дорожка и стена, при прохождении через которые,
        //    участники должны выполнять соответствующие действия (бежать или прыгать),
        //    результат выполнения печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).

        // 3. Создайте два массива: с участниками и препятствиями, и заставьте всех участников
        //    пройти этот набор препятствий.

        // 4. У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения на бег и прыжки.
        //    Если участник не смог пройти одно из препятствий, то дальше по списку препятствий он не идет.

        // 5. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
        //    При подаче массива другого размера необходимо бросить исключение MyArraySizeException.

        // 6. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
        //    Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или
        //    текст вместо числа), должно быть брошено исключение MyArrayDataException с детализацией,
        //    в какой именно ячейке лежат неверные данные.

        // 7. В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException
        //    и MyArrayDataException и вывести результат расчета.

        obstacleCourse();
        System.out.println();

        arrayConversion();
    }
}
