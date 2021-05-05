package movablepoint;

public class Main {
    public static void main(String[] args) {
        MovablePoint p = new MovablePoint(2,2);

        System.out.println(p.toString());
        p.move();

        System.out.println(p.toString());
    }
}
