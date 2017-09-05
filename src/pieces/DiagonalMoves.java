package pieces;

import java.util.Arrays;
import java.util.List;

import static pieces.MoveTypes.*;

public interface DiagonalMoves extends HasMoves {

    @Override
    default List<MoveTypes> getAllPossibleMoves() {
        List<MoveTypes> combinedMoves = HasMoves.super.getAllPossibleMoves();
        combinedMoves.addAll(Arrays.asList(MOVE_DIAGONAL_DOWN_LEFT, MOVE_DIAGONAL_DOWN_RIGHT, MOVE_DIAGONAL_UP_LEFT, MOVE_DIAGONAL_UP_RIGHT));
        return combinedMoves;
    }
}
