package board;

import javafx.geometry.Point2D;
import pieces.*;
import pieces.HasColor.Color;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Board {
    private List<Piece> whitePieces;
    private List<Piece> blackPieces;

    private HashMap<BoardLocation.location, Piece> board = new HashMap<>();


    public Board() {
        whitePieces = new ArrayList<>();
        blackPieces = new ArrayList<>();
        createPieces();
        addPiecesToMap();

    }

    private void addPiecesToMap() {
        whitePieces.forEach(piece -> {
            board.put(piece.getCoordinate(), piece);
        });

        blackPieces.forEach(piece -> {
            board.put(piece.getCoordinate(), piece);
        });
    }

    public void move(BoardLocation.location from, BoardLocation.location to){
        Piece piece = board.get(from);
        piece.setCoordinate(to);
        board.put(to, piece);
    }

    public void move(int from, int to){
        BoardLocation.location[] values = BoardLocation.location.values();
        move(values[from], values[to]);
    }

    public List<Piece> getWhitePieces() {
        return whitePieces;
    }

    public List<Piece> getBlackPieces() {
        return blackPieces;
    }

    public HashMap<BoardLocation.location, Piece> getBoard() {
        return board;
    }

    private void createPieces(){
        whitePieces.add(new Pawn("P1", Color.WHITE, BoardLocation.location.A2));
        whitePieces.add(new Pawn("P2", Color.WHITE, BoardLocation.location.B2));
        whitePieces.add(new Pawn("P3", Color.WHITE, BoardLocation.location.C2));
        whitePieces.add(new Pawn("P4", Color.WHITE, BoardLocation.location.D2));
        whitePieces.add(new Pawn("P5", Color.WHITE, BoardLocation.location.E2));
        whitePieces.add(new Pawn("P6", Color.WHITE, BoardLocation.location.F2));
        whitePieces.add(new Pawn("P7", Color.WHITE, BoardLocation.location.G2));
        whitePieces.add(new Pawn("P8", Color.WHITE, BoardLocation.location.H2));

        whitePieces.add(new Rook("R1", Color.WHITE, BoardLocation.location.A1));
        whitePieces.add(new Rook("R2", Color.WHITE, BoardLocation.location.H1));
        whitePieces.add(new Knight("N1", Color.WHITE, BoardLocation.location.B1));
        whitePieces.add(new Knight("N2", Color.WHITE, BoardLocation.location.G1));
        whitePieces.add(new Bishop("B1", Color.WHITE, BoardLocation.location.C1));
        whitePieces.add(new Bishop("B2", Color.WHITE, BoardLocation.location.F1));
        whitePieces.add(new Queen("Q", Color.WHITE, BoardLocation.location.D1));
        whitePieces.add(new King("K", Color.WHITE, BoardLocation.location.E1));

        blackPieces.add(new Pawn("P1", Color.BLACK, BoardLocation.location.A7));
        blackPieces.add(new Pawn("P2", Color.BLACK, BoardLocation.location.B7));
        blackPieces.add(new Pawn("P3", Color.BLACK, BoardLocation.location.C7));
        blackPieces.add(new Pawn("P4", Color.BLACK, BoardLocation.location.D7));
        blackPieces.add(new Pawn("P5", Color.BLACK, BoardLocation.location.E7));
        blackPieces.add(new Pawn("P6", Color.BLACK, BoardLocation.location.F7));
        blackPieces.add(new Pawn("P7", Color.BLACK, BoardLocation.location.G7));
        blackPieces.add(new Pawn("P8", Color.BLACK, BoardLocation.location.H7));

        blackPieces.add(new Rook("R1", Color.BLACK, BoardLocation.location.A8));
        blackPieces.add(new Rook("R2", Color.BLACK, BoardLocation.location.H8));
        blackPieces.add(new Knight("N1", Color.BLACK, BoardLocation.location.B8));
        blackPieces.add(new Knight("N2", Color.BLACK, BoardLocation.location.G8));
        blackPieces.add(new Bishop("B1", Color.BLACK, BoardLocation.location.C8));
        blackPieces.add(new Bishop("B2", Color.BLACK, BoardLocation.location.F8));
        blackPieces.add(new Queen("Q", Color.BLACK, BoardLocation.location.D8));
        blackPieces.add(new King("K", Color.BLACK, BoardLocation.location.E8));
    }
}
