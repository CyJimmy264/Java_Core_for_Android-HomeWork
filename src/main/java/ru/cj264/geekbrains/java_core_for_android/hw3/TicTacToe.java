package ru.cj264.geekbrains.java_core_for_android.hw3;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private static char[][] field;
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static final char DOT_EMPTY = '.';

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random rand = new Random();

    private static final int fieldSizeX = 5;
    private static final int fieldSizeY = 5;
    private static final int lineLength = 3;

    private static void initField() {
        field = new char[fieldSizeY][fieldSizeX];

        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    private static void printField() {
        for (char[] j : field) {
            for (char i : j) {
                System.out.print(i + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void humanTurn() {
        int x; int y;

        do {
            System.out.print("Введите координаты хода: ");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isCellEmpty(x, y) || !isCellValid(x, y));

        field[y][x] = DOT_X;
    }

    private static void aiTurn() {
        int x; int y;

        do {
            x = rand.nextInt(3);
            y = rand.nextInt(3);
        } while (!isCellEmpty(x, y) || !isCellValid(x, y));

        field[y][x] = DOT_O;
    }

    private static boolean isCellEmpty(int x, int y) {
        return field[y][x] == DOT_EMPTY;
    }

    private static boolean isCellValid(int x, int y) {
        return x >= 0 && y >=0 && x < fieldSizeX && y < fieldSizeY;
    }

    private static boolean checkGame(String s) {
        if (nInLine(lineLength)) {
            System.out.println(s);
            return true;
        }
        if (checkDraw()) {
            System.out.println("Draw!!!");
            return true;
        }
        return false;
    }

    private static boolean nInLine(int n) {
        int x; int y; int i;

        char dot;

        for (y = 0; y < fieldSizeY; y++) {
            for (x = 0; x < fieldSizeX; x++) {
                dot = field[y][x];
                if (dot != DOT_EMPTY) {
                    // horizontal
                    if (x + n <= fieldSizeX) {
                        for (i = 1; i < n; i++) {
                            if (field[y][x + i] != dot) break;
                        }
                        if (i == n) return true;
                    }

                    // vertical
                    if (y + n <= fieldSizeY) {
                        for (i = 1; i < n; i++) {
                            if (field[y + i][x] != dot) break;
                        }
                        if (i == n) return true;
                    }

                    // diagonal
                    if (x + n <= fieldSizeX && y + n <= fieldSizeY) {
                        for (i = 1; i < n; i++) {
                            if (field[y + i][x + i] != dot) break;
                        }
                        if (i == n) return true;
                    }
                }

                // antidiagonal
                if (x + n <= fieldSizeX && y + n <= fieldSizeY) {
                    dot = field[y + n - 1][x];
                    if (dot == DOT_EMPTY) continue;
                    for (i = 1; i < n; i++) {
                        if (field[y + n - 1 - i][x + i] != dot) break;
                    }
                    if (i == n) return true;
                }
            }
        }

        return false;
    }

    private static boolean checkDraw() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isCellEmpty(x, y)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        while (true) {
            initField();
            printField();

            while (true) {
                humanTurn();
                printField();
                if (checkGame("Human wins!!!")) break;

                aiTurn();
                printField();
                if (checkGame("AI win!!!")) break;
            }

            System.out.println("Wanna play again?");
            if (!SCANNER.next().equals("y")){
                SCANNER.close();
                break;
            }
        }
    }
}
