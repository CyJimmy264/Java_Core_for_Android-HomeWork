package ru.cj264.geekbrains.java_core_for_android.hw7;

public class Robot implements Runner {
    String id;
    int jumpHeightLimit;
    int runDistanceLimit;
    boolean gotOutOfRace = false;

    public Robot(String id, int jumpHeightLimit, int runDistanceLimit) {
        this.id = id;
        this.jumpHeightLimit = jumpHeightLimit;
        this.runDistanceLimit = runDistanceLimit;
    }

    public Robot(String id) { this.id = id; }

    @Override
    public String getName() { return "Robot " + id; }

    @Override
    public int getJumpHeightLimit() { return jumpHeightLimit; }

    @Override
    public int getRunDistanceLimit() { return runDistanceLimit; }

    @Override
    public boolean isGotOutOfRace() { return gotOutOfRace; }

    @Override
    public void getOutOfRace() { gotOutOfRace = true; }
}
