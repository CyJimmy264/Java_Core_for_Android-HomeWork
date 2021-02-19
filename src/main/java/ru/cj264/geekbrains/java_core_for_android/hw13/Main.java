package ru.cj264.geekbrains.java_core_for_android.hw13;

import java.util.ArrayList;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Main {
    public static final int CARS_COUNT = 4;

    // 1. Перенести приведенный ниже код в новый проект, где мы организуем гонки.

    // 2. Все участники должны стартовать одновременно, несмотря на разное время подготовки.
    //    В тоннель не может одновременно заехать больше половины участников (условность).
    //    Попробовать это синхронизировать.

    // 3. Первый участник, пересекший финишную черту, объявляется победителем (в момент пересечения этой самой черты).
    //    Победитель должен быть только один (ситуация с 0 или 2+ победителями недопустима).

    // 4. Когда все завершат гонку, нужно выдать объявление об окончании.

    //    Можно корректировать классы (в том числе конструктор машин) и добавлять объекты классов
    //    из пакета java.util.concurrent.

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");

        Race race = new Race(new Road(60), new Tunnel(), new Road(40));

        for (int i = 0; i < CARS_COUNT; i++) {
            Car car = new Car(race, 10 + (int) (Math.random() * 10));
            new Thread(car).start();
        }

        try {
            race.cyclicBarrier.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            race.cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");

        System.out.println("\n=============================\nРезультаты гонки:");
        int place = 0;
        for (Integer raceResult : race.raceResults) {
            System.out.printf("Место %d занял участник #%d\n", ++place, raceResult);
        }
    }
}
