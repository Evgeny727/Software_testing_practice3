package TDD;

import com.practice.testing.TicTacToe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TDD2 {
    @Test
    public void testing_winner_function_have_winner() {
        ArrayList<Character> arrayList = new ArrayList<>();
        arrayList.add('X');
        arrayList.add('O');
        arrayList.add('X');
        arrayList.add(' ');
        arrayList.add(' ');
        arrayList.add(' ');
        arrayList.add(' ');
        arrayList.add(' ');
        arrayList.add(' ');
        Assertions.assertTrue(TicTacToe.isLegal(4, arrayList));
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
        arrayList.add(' ');
        arrayList.add(' ');
        Assertions.assertFalse(TicTacToe.isLegal(3, arrayList));
    }
}
