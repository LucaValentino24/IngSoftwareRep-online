package Figure2D.Adapter;

public class Main {

    public static void main(String[] args) {
        Figure2D[] figure = new Figure2D[2];
        figure[0] = new Rectangle(3.0,7.0);
        figure[1] = new TriangleObject(3.0,7.0);
        System.out.println(figure[0].area());
        System.out.println(figure[1].area());
    }
}
