package cycleandcyllinder;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(2, "Blue");
        Cylinder cylinder = new Cylinder(10, "Red", 5);

        System.out.println(circle.toString());
        System.out.println(cylinder.toString());
    }
}
