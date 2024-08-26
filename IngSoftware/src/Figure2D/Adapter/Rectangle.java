package Figure2D.Adapter;

public class Rectangle implements Figure2D{
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double area(){
        return width * height;
    }

    @Override
    public double perimeter() {
        return 2*(width+height);
    }
}
