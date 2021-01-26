package ru.cj264.geekbrains.java_core_for_android.hw7;

public class Track extends TrackPart {
    private int length;

    public Track(int length) {
        this.length = length;
    }

    @Override
    public void pass(Runner runner) {
        if (runner.getRunDistanceLimit() >= length){
            runner.run();
            System.out.println(runner.getName() + " overcomes " + length + " meters track.");
        } else {
            runner.getOutOfRace();
            System.out.println(runner.getName() + " didn't overcome " + length + " meters track.");
            System.out.println(runner.getName() + " is getting out of race.");
        }
    }
}
