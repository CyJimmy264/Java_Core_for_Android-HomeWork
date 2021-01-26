package ru.cj264.geekbrains.java_core_for_android.hw7;

public interface Runner {
    String getName();
    int getJumpHeightLimit();
    int getRunDistanceLimit();
    void getOutOfRace();
    boolean isGotOutOfRace();

    default void run() {
        System.out.println(getName() + " runs.");
    }

    default void jump() {
        System.out.println(getName() + " jumps.");
    }

    default void pass(TrackPart trackPart) {
        if (!isGotOutOfRace()) trackPart.pass(this);
    }
}
