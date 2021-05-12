package geometric_resize;

import entity.Circle;

public class CircleResizeable extends Circle implements Resizeable {

    public CircleResizeable() {
    }

    public CircleResizeable(double radius) {
        super(radius);
    }

    public CircleResizeable(double radius, String color, boolean filled) {
        super(radius, color, filled);
    }

    @Override
    public void resize(double percent) {
        this.setRadius(this.getRadius() * (100+percent)/100);
    }
}
