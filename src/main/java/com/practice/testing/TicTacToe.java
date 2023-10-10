package com.practice.testing;

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

    public static void main(String[] args) {

    }
}

