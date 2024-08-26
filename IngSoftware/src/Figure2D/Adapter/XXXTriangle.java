package Figure2D.Adapter;

public class XXXTriangle {
    private double height;
    private double base;

    public XXXTriangle(double height, double base) {
        this.height = height;
        this.base = base;
    }

    public double computeArea(){
        return (height * base)/2;
    }

    public double computePerimeter(){
        return height + base + Math.pow((Math.pow(height,2) + Math.pow(base,2)), 0.5);
    }
}