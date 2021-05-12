package geometric_resize;

import entity.Rectangle;

public class RectangleResizeable extends Rectangle implements Resizeable {
    public RectangleResizeable() {
    }

    public RectangleResizeable(double width, double length) {
        super(width, length);
    }

    public RectangleResizeable(double width, double length, String color, boolean filled) {
        super(width, length, color, filled);
    }

    @Override
    public void resize(double percent) {
        this.setLength(this.getLength()*percent/100+this.getLength());
        this.setWidth(this.getWidth()*(percent/100+1));
    }
}
