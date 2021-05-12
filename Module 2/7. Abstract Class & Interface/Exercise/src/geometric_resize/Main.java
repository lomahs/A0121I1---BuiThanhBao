package geometric_resize;

public class Main {
    public static void main(String[] args) {
        Resizeable[] shapes = new Resizeable[3];

        shapes[0] = new CircleResizeable(3);
        shapes[1] = new SquareResizeable(5);
        shapes[2] = new RectangleResizeable(4,6);

        System.out.println("Shapes: ");
        for (Resizeable shape : shapes) {
            System.out.println(shape);
        }

        System.out.println("Shapes after resize:");
        for (Resizeable shape : shapes) {
            shape.resize(50);
            System.out.println(shape);
        }
    }
}
