import GUI.BoardGUI;
import board.Board;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import pieces.BoardLocation;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {

    public static void main(final String[] args) {
        System.out.println("Chess Game V 0.1");
        Board board = new Board();
        board.move(BoardLocation.location.A2, BoardLocation.location.A3);

        BoardGUI gui = new BoardGUI(board);

        AnimationTimer animator = new AnimationTimer() {

            @Override
            public void handle(long now) {
                File f = new File("/Users/zeshan.anwar/Learning/Chess/src/MovingTest.txt");

                List<String> move;

                Scanner scanner = null;
                try {
                    scanner = new Scanner(f);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    move = Arrays.asList(line.split(" "));
                    board.move(Integer.parseInt(move.get(0)), Integer.parseInt(move.get(1)));
                }
                gui.refresh();


            }
        };

        animator.start();
        gui.startGame();

    }
}
