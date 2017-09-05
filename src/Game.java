import GUI.BoardGUI;
import board.Board;
import board.BoardState;
import move.Move;
import move.MoveGenerator;
import pieces.HasColor;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {

    public static void main(final String[] args) throws FileNotFoundException {
        System.out.println("Chess Game V 0.1");
        Board board = new Board();

        BoardGUI gui = new BoardGUI(board);

//        File f = new File("/Users/zeshan.anwar/Learning/Chess/src/MovingTest.txt");
//
//        List<String> move;
//
//        Scanner scanner = new Scanner(f);
//        while (scanner.hasNextLine()) {
//            String line = scanner.nextLine();
//            move = Arrays.asList(line.split(" "));
//            board.move(Integer.parseInt(move.get(0)), Integer.parseInt(move.get(1)));
//        }

        gui.startGame();

    }
}
