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

    private static int fieldSizeX;
    private static int fieldSizeY;

    private static void initField() {
        fieldSizeX = 3;
        fieldSizeY = 3;
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

    private static boolean checkGame(char dot, String s) {
        if (checkWin(dot)) {
            System.out.println(s);
            return true;
        }
        if (checkDraw()) {
            System.out.println("Draw!!!");
            return true;
        }
        return false;
    }

    private static boolean checkWin(char c) {
        // hor
        if (field[0][0] == c && field[0][1] == c && field[0][2] == c) return true;
        if (field[1][0] == c && field[1][1] == c && field[1][2] == c) return true;
        if (field[2][0] == c && field[2][1] == c && field[2][2] == c) return true;

        // ver
        if (field[0][0] == c && field[1][0] == c && field[2][0] == c) return true;
        if (field[0][1] == c && field[1][1] == c && field[2][1] == c) return true;
        if (field[0][2] == c && field[1][2] == c && field[2][2] == c) return true;

        // dia
        if (field[0][0] == c && field[1][1] == c && field[2][2] == c) return true;
        if (field[0][2] == c && field[1][1] == c && field[2][0] == c) return true;
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
                if (checkGame(DOT_X, "Human wins!!!")) break;

                aiTurn();
                printField();
                if (checkGame(DOT_O, "AI win!!!")) break;
            }

            System.out.println("Wanna play again?");
            if (!SCANNER.next().equals("y")){
                SCANNER.close();
                break;
            }
        }
    }
}
