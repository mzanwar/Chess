package board;

import move.Move;
import pieces.*;
import pieces.HasColor.Color;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import player.*;

public class Board {

    private List<Player> players = new ArrayList<Player>();

    private List<Piece> whitePieces;
    private List<Piece> blackPieces;

    private HashMap<BoardLocation.location, Piece> board = new HashMap<>();


    public Board() {
        whitePieces = new ArrayList<>();
        blackPieces = new ArrayList<>();
        createPlayers();
        createPieces();
        addPiecesToMap();

    }

    private void createPlayers() {
        players.add(new Human("Human", "Human", Color.WHITE, whitePieces));
        players.add(new AI("AI", "AI", Color.BLACK, blackPieces));
    }

    private void addPiecesToMap() {
        whitePieces.forEach(piece -> {
            board.put(piece.getCoordinate(), piece);
        });

        blackPieces.forEach(piece -> {
            board.put(piece.getCoordinate(), piece);
        });
    }

    public void move(BoardLocation.location from, BoardLocation.location to) {
        Piece movingPiece = board.get(from);
        Piece capturedPiece = board.get(to);

        movingPiece.setCoordinate(to);
        board.put(to, movingPiece);
        board.remove(from);

        if (capturedPiece != null) {
            capturedPiece.setCoordinate(BoardLocation.location.CAPTURED);
            removePieceFromList(capturedPiece);
        }
    }

    private void removePieceFromList(Piece capturedPiece) {
        whitePieces.remove(capturedPiece);
        blackPieces.remove(capturedPiece);
    }

    public void move(int from, int to) {
        BoardLocation.location[] values = BoardLocation.location.values();
        move(values[from], values[to]);
    }

    public List<Piece> getWhitePieces() {
        return whitePieces;
    }

    public List<Piece> getBlackPieces() {
        return blackPieces;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public HashMap<BoardLocation.location, Piece> getBoard() {
        return board;
    }


    private void createPieces() {
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

    public List<Move> generateMoves(Piece piece) {
        List<Move> validMoves = new ArrayList<>();
        for (MoveTypes move :
                piece.getAllPossibleMoves()) {

            double moveAmount = move.getMoveAmount();
            final BoardLocation.location from = piece.getCoordinate();

            boolean multipleMoves = true;
            boolean isPawnKnightKing = piece instanceof Pawn || piece instanceof King || piece instanceof Knight;
            if (isPawnKnightKing) multipleMoves = false;
            double moveDelta = moveAmount;
            int count = 0;
            do {
                final double denormalizedLocation = locationToNum(from) + moveDelta;
                if (denormalizedLocation > 64 || denormalizedLocation < 1) break;
                final BoardLocation.location to = numToLocation(denormalizedLocation);
                final Piece otherPiece = board.containsKey(to) ? board.get(to) : null;

                if (move.getHowManyRowsMoved() + count !=
                        Math.abs(Math.ceil(locationToNum(to) / 8) - Math.ceil(locationToNum(from) / 8))) {
                    //out of bounds
                    break;
                }
                //check to see if valid move
                if (piece instanceof Pawn) {
                    if (isDiagonalMove(move)) {
                        if (otherPiece != null && otherPiece.getColor() != piece.getColor()) {
                            validMoves.add(new Move(piece, from, to, 20,true)); // <- Capture
                        }
                    } else { // can only push if empty square
                        if (otherPiece == null) validMoves.add(new Move(piece, from, to, 10));
                    }
                    break;
                }
                if (otherPiece != null) {
                    if (otherPiece.getColor() != piece.getColor()) {
                        // Capture, But still cannot cross!
                        validMoves.add(new Move(piece, from, to, 20, true));
                        break;
                    }
                    if (otherPiece.getColor() == piece.getColor()) {
                        // same color piece, cannot cross
                        break;
                    }
                }
                validMoves.add(new Move(piece, from, to, 10));
                moveDelta += moveAmount;
                if (move != MoveTypes.MOVE_LEFT && move != MoveTypes.MOVE_RIGHT) {
                    count++;
                }
            } while (multipleMoves);


        }
        return validMoves;
    }

    public BoardLocation.location numToLocation(double number) {
        return BoardLocation.location.values()[(int) number];
    }

    public double locationToNum(BoardLocation.location loc) {
        return loc.ordinal();
    }

    public boolean isDiagonalMove(MoveTypes move) {
        return move.equals(MoveTypes.MOVE_DIAGONAL_UP_LEFT) || move.equals(MoveTypes.MOVE_DIAGONAL_UP_RIGHT) || move.equals(MoveTypes.MOVE_DIAGONAL_DOWN_RIGHT) || move.equals(MoveTypes.MOVE_DIAGONAL_DOWN_LEFT);
    }
}
