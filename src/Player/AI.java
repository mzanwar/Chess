package Player;

import Move.Move;
import pieces.Piece;

import java.util.List;

public class AI extends Player {
    public AI(String name, String type, Color color, List<Piece> pieces) {
        super(name, type, color, pieces);
    }

    @Override
    public Move WhatsMyMove() {
        //calculate move
        return null;
    }
}
