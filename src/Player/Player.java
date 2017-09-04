package Player;

import Move.Move;
import pieces.HasColor;
import pieces.Piece;

import java.util.List;

public class Player implements HasColor {

    String name;
    String type;
    Color color;
    List<Piece> pieces;

    public Player(String name, String type, Color color, List<Piece> pieces) {
        this.name = this.getClass().getSimpleName();
        this.type = this.getClass().getSimpleName();
        this.color = color;
        this.pieces = pieces;
    }


    public Move WhatsMyMove() {
        return null;
    }
}
