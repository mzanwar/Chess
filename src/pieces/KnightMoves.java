package pieces;

import java.util.Arrays;
import java.util.List;

public interface KnightMoves extends HasMoves {

    @Override
    default List<MoveTypes> getAllPossibleMoves() {
        List<MoveTypes> combinedMoves = HasMoves.super.getAllPossibleMoves();
        combinedMoves.addAll(Arrays.asList(
                MoveTypes.MOVE_L_DOWN_LEFT,
                MoveTypes.MOVE_L_DOWN_RIGHT,
                MoveTypes.MOVE_L_LEFT_DOWN,
                MoveTypes.MOVE_L_RIGHT_DOWN,
                MoveTypes.MOVE_L_RIGHT_UP,
                MoveTypes.MOVE_L_LEFT_UP,
                MoveTypes.MOVE_L_UP_LEFT,
                MoveTypes.MOVE_L_UP_RIGHT
        ));
        return combinedMoves;
    }
}
