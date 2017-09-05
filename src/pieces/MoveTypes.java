package pieces;

public enum MoveTypes {
    MOVE_UP(8, 1),
    MOVE_DOWN(-8, 1),
    MOVE_RIGHT(1, 0),
    MOVE_LEFT(-1, 0),
    MOVE_DIAGONAL_UP_LEFT(7, 1),
    MOVE_DIAGONAL_UP_RIGHT(9, 1),
    MOVE_DIAGONAL_DOWN_LEFT(-9, 1),
    MOVE_DIAGONAL_DOWN_RIGHT(-7, 1),

    MOVE_L_UP_RIGHT(17, 2),
    MOVE_L_UP_LEFT(15, 2),
    MOVE_L_RIGHT_UP(10, 1),
    MOVE_L_LEFT_UP(6, 1),
    MOVE_L_RIGHT_DOWN(-6, 1),
    MOVE_L_LEFT_DOWN(-10, 1),
    MOVE_L_DOWN_RIGHT(-15, 2),
    MOVE_L_DOWN_LEFT(-17, 2);

    private double moveAmount;
    private double howManyRowsMoved;

    MoveTypes(double moveAmount, double howManyRowsMoved) {
        this.moveAmount = moveAmount;
        this.howManyRowsMoved = howManyRowsMoved;
    }

    public double getMoveAmount() {
        return moveAmount;
    }

    public double getHowManyRowsMoved() {
        return howManyRowsMoved;
    }
}
