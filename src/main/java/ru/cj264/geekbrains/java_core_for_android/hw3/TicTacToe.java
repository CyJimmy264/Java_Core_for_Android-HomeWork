package ru.cj264.geekbrains.java_core_for_android.hw3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private static char[][] field;
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static final char DOT_EMPTY = '.';

    private static final char HUMAN_DOT = DOT_X;
    private static final char AI_DOT = DOT_O;

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random rand = new Random();

    private static final int fieldSizeX = 5;
    private static final int fieldSizeY = 5;
    private static final int lineLength = 4;

    private static long aiTimeFrom;

    private static void initField() {
        field = new char[fieldSizeY][fieldSizeX];

        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    private static void printField() {
        printField(field);
    }

    private static void printField(char[][] field) {
        System.out.print("   ");
        for (int i = 1; i <= fieldSizeX; i++) {
            System.out.printf("%3d", i);
        }
        System.out.println();
        int row = 1;
        for (char[] j : field) {
            System.out.printf("%3d", row++);
            for (char i : j) {
                System.out.printf("%3c", i);
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void printSteps(int[][] steps) {
        System.out.print("   ");
        for (int i = 1; i <= steps[0].length; i++) {
            System.out.printf("%3d", i);
        }
        System.out.println();

        int row = 1;
        for (int[] j : steps) {
            System.out.printf("%3d", row++);
            for (int i : j) {
                System.out.printf("%3d", i);
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

        field[y][x] = HUMAN_DOT;
    }

    private static char[][] deepCopy(char[][] matrix) {
        return Arrays.stream(matrix).map(el -> el.clone()).toArray($ -> matrix.clone());
    }

    private static int[][] deepCopy(int[][] matrix) {
        return Arrays.stream(matrix).map(el -> el.clone()).toArray($ -> matrix.clone());
    }

    private static int aiCheckTurn(int x, int y, char aiDot, char[][] field, int[][] steps, int inc) {
        field[y][x] = aiDot;
        steps[y][x] = inc;

        if (nInLine(field)) {
            return 1;
        } else if (checkDraw(field)) {
            return 2;
        } else {
            char opponentDot = aiDot == DOT_O ? DOT_X : DOT_O;
            int[] opponentTurnXY = aiCalculateTurn(opponentDot, deepCopy(field), deepCopy(steps), inc + 1);
            field[opponentTurnXY[0]][opponentTurnXY[1]] = opponentDot;

            if (nInLine(field)) {
                return fieldSizeX*fieldSizeY+1;
            } else if (checkDraw(field)) {
                return 2;
            } else {
                int[] aiTurnXY = aiCalculateTurn(aiDot, deepCopy(field), deepCopy(steps), inc + 2);
                if (aiTurnXY[0] == -1 || field[aiTurnXY[0]][aiTurnXY[1]] != DOT_EMPTY) {
                    System.out.println("!!!");
                }
                return aiCheckTurn(aiTurnXY[1], aiTurnXY[0], aiDot, deepCopy(field), deepCopy(steps), inc + 2) + 1;
            }
        }
    }

    private static void drawWind(int x, int y, char[][] field, int[][] calcField) {
        int[][] directions = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
        int windX; int windY;
        int forceWind;
        char opponentDot = field[y][x];
        char myDot = opponentDot == DOT_X ? DOT_O : DOT_X;
        for (int j = 0; j < 8; j++) {
            windX = x;
            windY = y;
            forceWind = 0;
            windDirection:
            for (int i = 1; i < lineLength; i++) {
                do {
                    windX += directions[j][1];
                    windY += directions[j][0];
                    if (isCellValid(windX, windY) && field[windY][windX] == myDot) break windDirection;
                    if (isCellValid(windX, windY) && field[windY][windX] == opponentDot) forceWind += 1;
                } while (isCellValid(windX, windY) && !isCellEmpty(windX, windY, field));
                if (isCellValid(windX, windY)) {
                    calcField[windY][windX] += lineLength - i + forceWind;
                    forceWind = 0;
                } else break windDirection;
            }
        }
    }

    private static int[] aiPreventLine(char aiDot, char[][] field, int inc) {
        char opponentDot = aiDot == DOT_X ? DOT_O : DOT_X;

        int maxX = -1; int maxY = -1; int maxCalc = 0;

        int[][] calcField = new int[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] == opponentDot) {
                    drawWind(x, y, field, calcField);
                }
            }
        }

//        // DEBUG
//        if (inc == 1) {
//            System.out.println("Prevent Line");
//            printSteps(calcField);
//        }

        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (calcField[y][x] > maxCalc) {
                    maxCalc = calcField[y][x];
                    maxX = x;
                    maxY = y;
                }
            }
        }

        return new int[]{maxY, maxX};
    }

    private static int[] aiCalculateTurn(char aiDot, char[][] field, int[][] steps, int inc) {
        int aiX = -1; int aiY = -1;
        int turnsCount;
        int aiFastest = fieldSizeX*fieldSizeY*2;
        calculate:
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (System.nanoTime() - aiTimeFrom > 1_000_000_000L) {
                    aiX = -1;
                    aiY = -1;
                    break calculate;
                }
                if (field[y][x] == DOT_EMPTY) {
                    turnsCount = aiCheckTurn(x, y, aiDot, deepCopy(field), deepCopy(steps), inc);
                    if (turnsCount < aiFastest) {
                        aiY = y;
                        aiX = x;
                        aiFastest = turnsCount;
                        if (aiFastest == 1) break calculate;
                    }
                }
            }
        }
        if (aiY == -1) {
            int[] preventXY = aiPreventLine(aiDot, field, inc);
            aiY = preventXY[0];
            aiX = preventXY[1];
        }
        if (aiY == -1) {
            do {
                aiX = rand.nextInt(fieldSizeX);
                aiY = rand.nextInt(fieldSizeY);
            } while (!isCellEmpty(aiX, aiY, field));
        }
        return new int[] {aiY, aiX};
    }

    private static void aiTurn() {
        aiTimeFrom = System.nanoTime();
        int[] aiTurnXY = aiCalculateTurn(AI_DOT, deepCopy(field), new int[fieldSizeY][fieldSizeX], 1);
        field[aiTurnXY[0]][aiTurnXY[1]] = AI_DOT;
    }

    private static boolean isCellEmpty(int x, int y) {
        return isCellEmpty(x, y, field);
    }

    private static boolean isCellEmpty(int x, int y, char[][] field) {
        return field[y][x] == DOT_EMPTY;
    }

    private static boolean isCellValid(int x, int y) {
        return x >= 0 && y >=0 && x < fieldSizeX && y < fieldSizeY;
    }

    private static boolean checkGame(String s) {
        if (nInLine()) {
            System.out.println(s);
            return true;
        }
        if (checkDraw()) {
            System.out.println("Draw!!!");
            return true;
        }
        return false;
    }

    private static boolean nInLine() {
        return nInLine(field);
    }

    private static boolean nInLine(char[][] field) {
        int x; int y; int i;
        int n = lineLength;
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
        return checkDraw(field);
    }

    private static boolean checkDraw(char[][] field) {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isCellEmpty(x, y, field)) return false;
            }
        }
        return true;
    }

    // *По желанию! Написать метод, который принимает на вход 2 целых числа, например, x и y.
    // Внутри метода создаётся целочисленный двумерный массив со сторонами х и у.
    // Потом этот массив заполняется последовательно инкрементируемыми числами по спирали (или змейкой).
    // То есть, в позиции [0,0] будет 1, в [0,1] 2 и так далее. Потом по достижении правой границы
    // направление заполнения меняется на вертикальное и так далее.
    // Так, что последний заполненный элемент будет посередине массива.
    public static void snake() {
        System.out.print("Введите x, y: ");
        int x = SCANNER.nextInt();
        int y = SCANNER.nextInt();

        int[][] arr = new int[y][x];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int direction = 0;
        int sx = 0; int sy = 0;
        for (int i = 1; i <= x*y; i++) {
            arr[sy][sx] = i;

            if (sy + directions[direction][0] >= 0 && sy + directions[direction][0] < y &&
                sx + directions[direction][1] >= 0 && sx + directions[direction][1] < x &&
                arr[sy + directions[direction][0]][sx + directions[direction][1]] == 0) {
                sy += directions[direction][0];
                sx += directions[direction][1];
            } else {
                direction = Math.floorMod(direction + 1, 4);
                sy += directions[direction][0];
                sx += directions[direction][1];
            }
        }

        printSteps(arr);
    }

    public static void main(String[] args) {
        while (true) {
            initField();
            printField();

//            aiTurn();
//            printField();

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

        snake();
    }
}
