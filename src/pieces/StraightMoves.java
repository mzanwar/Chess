package pieces;

import java.util.Arrays;
import java.util.List;

public interface StraightMoves extends HasMoves {

    @Override
    default List<MoveTypes> getAllPossibleMoves() {
        List<MoveTypes> combinedMoves = Arrays.asList(MoveTypes.MOVE_UP, MoveTypes.MOVE_DOWN, MoveTypes.MOVE_RIGHT, MoveTypes.MOVE_LEFT);
        return combinedMoves;
    }
}
