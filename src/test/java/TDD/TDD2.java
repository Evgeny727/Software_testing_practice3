package TDD;

import com.practice.testing.TicTacToe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TDD2 {
    @Test
    public void testing_legal_move_function_legal() {
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
    public void testing_legal_move_function_illegal() {
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
