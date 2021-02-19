package ru.cj264.geekbrains.java_core_for_android.hw13;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private final Race race;
    private final int speed;
    private final String name;
    private final int number;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.number = CARS_COUNT;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(1500 + (int)(Math.random() * 4800));
            System.out.println(this.name + " готов");
            race.getCyclicBarrier().await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        synchronized (race.raceResults) {
            race.raceResults.add(number);
        }
    }
}
