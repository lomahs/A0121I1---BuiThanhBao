package geometric_resize;

import entity.Square;

public class SquareResizeable extends Square implements Resizeable {
    public SquareResizeable() {
    }

    public SquareResizeable(double side) {
        super(side);
    }

    public SquareResizeable(double side, String color, boolean filled) {
        super(side, color, filled);
    }

    @Override
    public void resize(double percent) {
        this.setSide(this.getSide()*(100+percent)/100);
    }
}
