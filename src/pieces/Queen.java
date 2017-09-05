package pieces;

import move.Move;

import java.util.List;

public class Queen extends Piece implements DiagonalMoves, StraightMoves {
    public Queen(String type, Color color, location coordinate) {
        super(type, color, coordinate);
    }

    @Override
    public List<MoveTypes> getAllPossibleMoves() {
        List<MoveTypes> moves = DiagonalMoves.super.getAllPossibleMoves();
        moves.addAll(StraightMoves.super.getAllPossibleMoves());
        return moves;
    }
}
