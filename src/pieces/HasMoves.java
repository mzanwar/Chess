package pieces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

 public interface HasMoves {
    default List<MoveTypes> getAllPossibleMoves(){
        List<MoveTypes> moves = new ArrayList<>();
        return moves;
    }
}
