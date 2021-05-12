package geometric_colorable;

import entity.Circle;
import entity.Rectangle;
import entity.Shape;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];

        shapes[0] = new Rectangle(4,5);
        shapes[1] = new Circle(3);
        shapes[2] = new SquareColorable(3);

        for (Shape shape : shapes) {
            System.out.println(shape);
            System.out.println("Area: " + shape.getArea());

            if (shape instanceof SquareColorable){
                ((SquareColorable) shape).howToColor();
            }
        }
    }
}
