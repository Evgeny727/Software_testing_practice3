package com.practice.testing;

import java.util.ArrayList;
import java.util.Scanner;

public class TicTacToe {
    static final char X = 'X';
    static final char O = 'O';
    static final char EMPTY = ' ';
    static final char TIE = 'T';
    static final char NO_ONE = 'N';

    void insructions() {
        System.out.println("Добро пожалоать в игру 'крестики-нолики'");
        System.out.println("Чтобы сделать действие введите число от 0 до 8, которое обозначает клетку поля");
        System.out.println("    0 | 1 | 2");
        System.out.println("    ---------");
        System.out.println("    3 | 4 | 5");
        System.out.println("    ---------");
        System.out.println("    6 | 7 | 8");
    }

    static char askYesNo(String question) {
        char response;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println(question + " (y/n): ");
            response = in.next().charAt(0);
        } while (askYesNoTest(response));
        in.close();
        return response;
    }

    public static boolean askYesNoTest(char input) {
        if (input != 'y' && input != 'n') return true;
        else return false;
    }

    static int askNumber(String question, int high, int low) {
        int number;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println(question + " (" + low + " - " + high + "): ");
            number = in.next().charAt(0);
        } while (askNumberTest(number, high, low));
        in.close();
        return number;
    }

    public static boolean askNumberTest(int input, int high, int low) {
        if (input > high || input < low) return true;
        else return false;
    }

    public static char humanPiece(char symbol) {
        if (symbol == 'y'){
            System.out.println("Хорошо, тогда ходи!");
            return X;
        }
        else {
            System.out.println("Хорошо, я хожу первым!");
            return O;
        }
    }

    public static char opponent(char piece) {
        if (piece == X) return O;
        else return X;
    }

    public static char winner(final ArrayList<Character> pBoard) {
        final int[][] WINNING_ROWS = {{0, 1, 2},
                {3, 4, 5},
                {6, 7, 8},
                {0, 3, 6},
                {1, 4, 7},
                {2, 5, 8},
                {0, 4, 8},
                {2, 4, 6}};
        final int TOTAL_ROWS = 8;

        for (int row = 0; row < TOTAL_ROWS; row++) {//если в какой-то строке есть 3 одинаковые не пустые значения -> есть победитель
            if ((pBoard.get(WINNING_ROWS[row][0]) != EMPTY) &&
                    (pBoard.get(WINNING_ROWS[row][0]) == pBoard.get(WINNING_ROWS[row][1])) &&
                    (pBoard.get(WINNING_ROWS[row][1]) == pBoard.get(WINNING_ROWS[row][2]))) {
                return pBoard.get(WINNING_ROWS[row][0]);
            }
        }
        //проверка на ничью
        if (!pBoard.contains(EMPTY)) {
            return TIE;
        }

        //никто не победил
        return NO_ONE;
    }

    public static boolean isLegal(int move, final ArrayList<Character> pBoard) {
        return (pBoard.get(move) == EMPTY);
    }

    public static void main(String[] args) {

    }
}

