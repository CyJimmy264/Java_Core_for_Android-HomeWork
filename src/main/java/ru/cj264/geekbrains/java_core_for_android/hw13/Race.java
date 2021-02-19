package ru.cj264.geekbrains.java_core_for_android.hw13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CyclicBarrier;



public class Race {
    private ArrayList<Stage> stages;
    public final ArrayList<Integer> raceResults = new ArrayList<>();;
    public CyclicBarrier cyclicBarrier = new CyclicBarrier(Main.CARS_COUNT + 1);

    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }

    public ArrayList<Stage> getStages() { return stages; }
    public CyclicBarrier getCyclicBarrier() { return cyclicBarrier; }
}

