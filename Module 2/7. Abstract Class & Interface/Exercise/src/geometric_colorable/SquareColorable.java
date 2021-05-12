package geometric_colorable;

import entity.Square;

public class SquareColorable extends Square implements Colorable {
    public SquareColorable() {
    }

    public SquareColorable(double side) {
        super(side);
    }

    public SquareColorable(double side, String color, boolean filled) {
        super(side, color, filled);
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides");
    }
}
