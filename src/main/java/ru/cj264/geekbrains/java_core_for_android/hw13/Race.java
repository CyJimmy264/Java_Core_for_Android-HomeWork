package ru.cj264.geekbrains.java_core_for_android.hw13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CyclicBarrier;

public class Race {
    private ArrayList<Stage> stages;
    private CyclicBarrier cyclicBarrier;
    public final ArrayList<Integer> raceResults;

    public Race(ArrayList<Integer> raceResults, CyclicBarrier cyclicBarrier, Stage... stages) {
        this.cyclicBarrier = cyclicBarrier;
        this.stages = new ArrayList<>(Arrays.asList(stages));
        this.raceResults = raceResults;
    }

    public ArrayList<Stage> getStages() { return stages; }
    public CyclicBarrier getCyclicBarrier() { return cyclicBarrier; }
}

