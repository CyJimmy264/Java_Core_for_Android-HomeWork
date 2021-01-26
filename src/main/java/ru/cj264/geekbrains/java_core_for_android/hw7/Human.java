package ru.cj264.geekbrains.java_core_for_android.hw7;

public class Human implements Runner {
    String name;
    int jumpHeightLimit;
    int runDistanceLimit;
    boolean gotOutOfRace = false;

    public Human(String name, int jumpHeightLimit, int runDistanceLimit) {
        this.name = name;
        this.jumpHeightLimit = jumpHeightLimit;
        this.runDistanceLimit = runDistanceLimit;
    }

    public Human(String name) { this.name = name; }

    @Override
    public String getName() { return name; }

    @Override
    public int getJumpHeightLimit() { return jumpHeightLimit; }

    @Override
    public int getRunDistanceLimit() { return runDistanceLimit; }

    @Override
    public boolean isGotOutOfRace() { return gotOutOfRace; }

    @Override
    public void getOutOfRace() { gotOutOfRace = true; }
}
