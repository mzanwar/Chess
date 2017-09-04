package pieces;

public abstract class Piece implements HasColor, BoardLocation {
    private String name;
    private String type;
    private Color color;
    private location coordinate;


    public Piece(String type, Color color, location coordinate) {
        this.name = this.getClass().getSimpleName();
        this.type = type;
        this.color = color;
        this.coordinate = coordinate;
    }
    public Piece(String type, Color color) {
        this.name = this.getClass().getSimpleName();
        this.type = type;
        this.color = color;
    }

    public void setCoordinate(location coordinate) {
        this.coordinate = coordinate;
    }

    public location getCoordinate() {
        return coordinate;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Color getColor() {
        return color;
    }
}
