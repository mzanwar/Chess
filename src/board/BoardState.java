package board;

import pieces.HasColor;

public class BoardState {
    private HasColor.Color turn;

    public HasColor.Color getIsTurn() {
        return turn;
    }

    public Board getBoard() {
        return board;
    }

    private Board board;

    public BoardState(HasColor.Color turn, Board board) {
        this.turn = turn;
        this.board = board;
    }
}
