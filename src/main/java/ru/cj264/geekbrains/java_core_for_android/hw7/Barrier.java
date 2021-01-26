package ru.cj264.geekbrains.java_core_for_android.hw7;

public class Barrier extends TrackPart {
    private int height;

    public Barrier(int height) {
        this.height = height;
    }

    @Override
    public void pass(Runner runner) {
        if (runner.getJumpHeightLimit() >= height) {
            runner.jump();
            System.out.println(runner.getName() + " overcomes " + height + " cm barrier.");
        } else {
            runner.getOutOfRace();
            System.out.println(runner.getName() + " didn't overcome " + height + " cm barrier.");
            System.out.println(runner.getName() + " is getting out of race.");
        }
    }
}
