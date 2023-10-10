package TDD;

import com.practice.testing.TicTacToe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TDD4 {
    @Test
    public void testing_ai_move_function_5() {
        ArrayList<Character> arrayList = new ArrayList<>();
        arrayList.add('X');
        arrayList.add('O');
        arrayList.add('X');
        arrayList.add('X');
        arrayList.add('O');
        arrayList.add(' ');
        arrayList.add(' ');
        arrayList.add(' ');
        arrayList.add(' ');
        Assertions.assertEquals(7, TicTacToe.computerMove(arrayList, 'O'));
    }
    @Test
    public void testing_ai_move_function_8() {
        ArrayList<Character> arrayList = new ArrayList<>();
        arrayList.add('X');
        arrayList.add('O');
        arrayList.add(' ');
        arrayList.add(' ');
        arrayList.add('X');
        arrayList.add(' ');
        arrayList.add(' ');
        arrayList.add(' ');
        arrayList.add(' ');
        Assertions.assertEquals(8, TicTacToe.computerMove(arrayList, 'O'));
    }
}
