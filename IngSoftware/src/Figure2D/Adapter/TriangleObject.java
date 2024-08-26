package Figure2D.Adapter;

public class TriangleObject implements Figure2D {

    private XXXTriangle triangle;

    public TriangleObject(double height, double base) {
        triangle = new XXXTriangle(height, base);
    }

    public double area(){
        return triangle.computeArea();
    }

    @Override
    public double perimeter() {
        return triangle.computePerimeter();
    }
}