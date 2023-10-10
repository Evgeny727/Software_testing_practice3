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

    public static void main(String[] args) {

    }
}

