package ru.cj264.geekbrains.java_core_for_android.hw7;

public class MyArraySizeException extends Exception {
    @Override
    public String getMessage() {
        return "Array size is not 4x4";
    }
}
