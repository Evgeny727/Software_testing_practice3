package TDD;

import com.practice.testing.TicTacToe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TDD1 {
    @Test
    public void testing_winner_function_have_winner() {
        ArrayList<Character> arrayList = new ArrayList<>();
        arrayList.add('X');
        arrayList.add('O');
        arrayList.add('X');
        arrayList.add('O');
        arrayList.add('X');
        arrayList.add('O');
        arrayList.add('X');
        arrayList.add(' ');
        arrayList.add(' ');
        Assertions.assertEquals('X', TicTacToe.winner(arrayList));
    }
    @Test
    public void testing_winner_function_no_one() {
        ArrayList<Character> arrayList = new ArrayList<>();
        arrayList.add('X');
        arrayList.add('O');
        arrayList.add('X');
        arrayList.add('O');
        arrayList.add('X');
        arrayList.add('O');
        arrayList.add(' ');
        arrayList.add('X');
        arrayList.add('O');
        Assertions.assertEquals('N', TicTacToe.winner(arrayList));
    }
}
