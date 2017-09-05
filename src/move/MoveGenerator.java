package move;

import player.Player;
import board.Board;
import board.BoardState;

import java.util.ArrayList;
import java.util.List;

public class MoveGenerator {

    public static List<Move> generate(BoardState boardState, Player player) {
        List<Move> moves = new ArrayList<Move>();
        Board board = boardState.getBoard();
        player.getPieces().forEach(piece -> {
            moves.addAll(board.generateMoves(piece));
        });
        return moves;
    }
}
