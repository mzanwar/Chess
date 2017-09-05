package pieces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pawn extends Piece implements PawnMoves {

    public Pawn(String type, Color color, location coordinate) {
        super(type, color, coordinate);
    }

    public Pawn(String type, Color color) {
        super(type, color);
    }

    @Override
    public List<MoveTypes> getAllPossibleMoves() {
        List<MoveTypes> moves = new ArrayList<>();
        if (this.getColor().equals(Color.WHITE)) {
            moves.addAll(Arrays.asList(
                    MoveTypes.MOVE_DIAGONAL_UP_LEFT,
                    MoveTypes.MOVE_DIAGONAL_UP_RIGHT,
                    MoveTypes.MOVE_UP
            ));
        } else { //BLACK
            moves.addAll(Arrays.asList(
                    MoveTypes.MOVE_DOWN,
                    MoveTypes.MOVE_DIAGONAL_DOWN_LEFT,
                    MoveTypes.MOVE_DIAGONAL_DOWN_RIGHT
            ));
        }

        return moves;
    }
}
