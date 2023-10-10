package com.practice.testing;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Consumer;

public class TicTacToe {
    static final char X = 'X';
    static final char O = 'O';
    static final char EMPTY = ' ';
    static final char TIE = 'T';
    static final char NO_ONE = 'N';

    static Scanner in = new Scanner(System.in);

    static void instructions() {
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
        do {
            System.out.println(question + " (y/n): ");
            response = in.next().charAt(0);
        } while (askYesNoTest(response));
        return response;
    }

    public static boolean askYesNoTest(char input) {
        if (input != 'y' && input != 'n') return true;
        else return false;
    }

    static int askNumber(String question, int high, int low) {
        int number;
        do {
            System.out.println(question + " (" + low + " - " + high + "): ");
            number = in.nextInt();
        } while (askNumberTest(number, high, low));
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

    static void displayBoard(final ArrayList<Character> pBoard) {
        System.out.println("\n\t" + pBoard.get(0) + " | " + pBoard.get(1) + " | " + pBoard.get(2));
        System.out.println("\t" + "---------");
        System.out.println("\t" + pBoard.get(3) + " | " + pBoard.get(4) + " | " + pBoard.get(5));
        System.out.println("\t" + "---------");
        System.out.println("\t" + pBoard.get(6) + " | " + pBoard.get(7) + " | " + pBoard.get(8) + "\n");
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

    public static int humanMove(final ArrayList<Character> pBoard, char human) {
        int move = askNumber("Куды ты будешь ходить?", (pBoard.size() - 1), 0);
        while (!isLegal(move, pBoard))
        {
            System.out.println("\nЭта клетка уже занята!.");
            move = askNumber("Куды ты будешь ходить?", (pBoard.size() - 1), 0);
        }
        System.out.println("Хорошо...");
        return move;
    }

    public static int computerMove(ArrayList<Character> board, char computer) {
        int move = 0;
        boolean found = false;

        //если компьютер может выиграть следующим ходом, сделать этот ход
        while (!found && move < board.size()) {
            if (isLegal(move, board)) {
                //попробовать сходить
                board.set(move, computer);
                //проверить на победу
                found = winner(board) == computer;
                //отменить ход
                board.set(move, EMPTY);
            }
            if (!found) {
                ++move;
            }
        }

        //если же пользователь может выиграть следующим ходом, сделать этот ход
        if (!found) {
            move = 0;
            char human = opponent(computer);
            while (!found && move < board.size()) {
                if (isLegal(move, board)) {
                    //попробовать сходить
                    board.set(move, human);
                    //проверить на победу
                    found = winner(board) == human;
                    //отменить ход
                    board.set(move, EMPTY);
                }
                if (!found) {
                    ++move;
                }
            }
        }

        //иначе сделать наилучший ход
        if (!found) {
            move = 0;
            int i = 0;

            final int[] BEST_MOVES = { 4, 0, 2, 6, 8, 1, 3, 5, 7 };
            //выбрать лучшую пустую клетку
            while (!found && i <  board.size()) {
                move = BEST_MOVES[i];
                if (isLegal(move, board)){
                    found = true;
                }
                ++i;
            }
        }

        System.out.println("Я сделаю ход в клетку " + move);
        return move;
    }

    static void announceWinner(char winner, char computer, char human) {
        if (winner == computer || winner == human) {
            System.out.println(winner + " победил!");
        }

        else {
            System.out.println("Это ничья!");
        }
    }

    public static void main(String[] args) {
        int move;
        final int NUM_SQUARES = 9;
        ArrayList<Character> board = new ArrayList<>();
        for (int i = 0; i < NUM_SQUARES; i++) {
            board.add(EMPTY);
        }

        instructions();
        char go_first = askYesNo("Хочешь ходить первым?");
        char human = humanPiece(go_first);
        char computer = opponent(human);
        char turn = X;
        displayBoard(board);

        while (winner(board) == NO_ONE) {
            if (turn == human) {
                move = humanMove(board, human);
                board.set(move, human);
            }
            else {
                move = computerMove(board, computer);
                board.set(move, computer);
            }
            displayBoard(board);
            turn = opponent(turn);
        }

        announceWinner(winner(board), computer, human);
    }
}

