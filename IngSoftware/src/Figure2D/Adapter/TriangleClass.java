package Figure2D.Adapter;

public class TriangleClass extends XXXTriangle implements Figure2D{

    public TriangleClass(double height, double base) {
        super(height, base);
    }

    @Override
    public double area() {
        return computeArea();
    }

    public double perimeter(){
        return computePerimeter();
    }
}