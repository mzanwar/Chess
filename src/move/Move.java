package move;

import pieces.BoardLocation;
import pieces.Piece;

import java.util.Comparator;

public class Move implements Comparable<Move> {

    // A move is basically a piece -> square
    Piece piece;
    BoardLocation.location from;
    BoardLocation.location to;
    int utility;
    boolean capture;

    public Move(Piece piece, BoardLocation.location from, BoardLocation.location to, int utility) {
        this.piece = piece;
        this.from = from;
        this.to = to;
        this.utility = utility;
    }

    public Move(Piece piece, BoardLocation.location from, BoardLocation.location to, int utility, boolean capture) {
        this.piece = piece;
        this.from = from;
        this.to = to;
        this.utility = utility;
        this.capture = capture;
    }


    public Piece getPiece() {
        return piece;
    }

    public BoardLocation.location getTo() {
        return to;
    }

    public BoardLocation.location getFrom() {
        return from;
    }

    public int getUtility() {
        return utility;
    }

    @Override
    public int compareTo(Move other) {
       return other.getUtility() - this.getUtility();
    }
}

