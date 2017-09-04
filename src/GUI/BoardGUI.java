package GUI;

import board.Board;
import board.BoardSize;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Pair;
import pieces.BoardLocation;

import java.io.*;
import java.util.*;


public class BoardGUI extends Application implements BoardSize {
    // split this into GameGUI
    GraphicsContext brush;
    GraphicsContext annotationsBrush;

    static Board board;

    private HashMap<BoardLocation.location, Point2D> boardCoordinates = new HashMap<>();

    public BoardGUI(Board board) {
        this.board = board;
        setupMap();
        System.out.println(boardCoordinates);
    }

    public BoardGUI() {
        setupMap();
        System.out.println(boardCoordinates);
    }

    public void startGame() {
        launch();
    }

    @Override
    public void init() {
        System.out.println("Initializing Board");
    }

    private void setupMap() {
        for (BoardLocation.location location : BoardLocation.location.values()) {
            double x, y;
            x = ((location.ordinal() - 1) % 8) * Constants.SquareLength.getDimension();
            y = Constants.BoardLength.getDimension() - (Math.ceil((double) location.ordinal() / 8) * Constants.SquareLength.getDimension());
            boardCoordinates.put(location, new Point2D(x, y));
        }
    }

    @Override
    public void start(Stage gameBoard) throws Exception {
        gameBoard.setTitle("Chess");
        StackPane rootNode = new StackPane();
        rootNode.setAlignment(Pos.CENTER);
        Scene gameScene = new Scene(rootNode, 1000, 1000);
        gameBoard.setScene(gameScene);

        Canvas canvas = new Canvas(BoardSize.Constants.BoardLength.getDimension(), BoardSize.Constants.BoardWidth.getDimension());
        Canvas annotations = new Canvas(900, 900);

        annotations.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Mouse Click");
                board.move(BoardLocation.location.D1, BoardLocation.location.D4);
            }
        });
        brush = canvas.getGraphicsContext2D();
        annotationsBrush = annotations.getGraphicsContext2D();

        drawBoard(brush);
        drawAnnotations(annotationsBrush);
        drawPieces(annotationsBrush);

        rootNode.getChildren().addAll(canvas, annotations);
        gameBoard.show();

    }

    public void refresh(){
        if (annotationsBrush == null) return;
        annotationsBrush.clearRect(50, 50, 800, 800);
        drawPieces(annotationsBrush);
    }

    private void drawPieces(GraphicsContext brush) {
        brush.setFont(new Font("Arial", 30));
        Point2D offset = new Point2D(85, 105);

        brush.setFill(Color.BLACK);
        board.getBlackPieces().forEach(piece -> {
            final double posx = boardCoordinates.get(piece.getCoordinate()).getX() + offset.getX();
            final double posy = boardCoordinates.get(piece.getCoordinate()).getY() + offset.getY();
            brush.fillText(piece.getType(), posx, posy);
        });

        brush.setFill(Color.WHITE);
        board.getWhitePieces().forEach(piece -> {
            final double posx = boardCoordinates.get(piece.getCoordinate()).getX() + offset.getX();
            final double posy = boardCoordinates.get(piece.getCoordinate()).getY() + offset.getY();
            brush.fillText(piece.getType(), posx, posy);
        });
    }

    private void drawAnnotations(GraphicsContext brush) {

        brush.setFill(Color.BLACK);
        brush.setFont(new Font("TimesNewRoman", 20));
        List<String> letters = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H");
        double posx = 0;
        for (String letter :
                letters) {
            brush.fillText(letter, 90 + posx, 30);
            brush.fillText(letter, 90 + posx, 890);
            posx += 100;

        }

        List<String> numbers = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8");
        Collections.reverse(numbers);
        double posy = 0;
        for (String number :
                numbers) {
            brush.fillText(number, 15, 105 + posy);
            brush.fillText(number, 880, 105 + posy);
            posy += 100;

        }
    }

    private void drawBoard(GraphicsContext brush) {
        Paint a = Color.SANDYBROWN;
        Paint b = Color.SADDLEBROWN;

        double length = Constants.BoardLength.getDimension();
        double width = Constants.BoardWidth.getDimension();
        double squareDimension = Constants.SquareLength.getDimension();

        brush.setStroke(Color.BLACK);
        Paint col = a;
        for (int i = 0; i < length; i += squareDimension) {
            col = (col == b) ? a : b;
            for (int j = 0; j < width; j += squareDimension) {
                col = (col == a) ? b : a;
                brush.setFill(col);
                brush.fillRect(i, j, squareDimension, squareDimension);
            }
        }
    }

    @Override
    public void stop() {
        System.out.println("Closed Chess Game");
    }
}
