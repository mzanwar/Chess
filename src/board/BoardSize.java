package board;

public interface BoardSize {
     enum Constants {
        BoardLength(800),
        BoardWidth(800),
        SquareLength(100);

        private double dimension;

        Constants(double l) {
            dimension = l;
        }

        public double getDimension(){
            return dimension;
        }
    }
}
