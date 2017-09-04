package pieces;

public class Pawn extends Piece implements PawnMoves {

    public Pawn(String type, Color color, location coordinate) {
        super(type, color, coordinate);
    }

    public Pawn(String type, Color color) {
        super(type, color);
    }
}
