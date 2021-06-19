public class Cylinder extends Solid {
    
    private double r;
    private double h;

    public Cylinder() {
        this.name = "Cylinder";
    }

    public Cylinder(double r, double h) {
        this.r = r;
        this.h = h;
        this.name = "Cylinder";
    }

    @Override
    public double getVolume() {
        return Math.PI*Math.pow(r,2)*h;
    }
    @Override
    public double getArea() {
        return 2*Math.PI*r*(r+h);
    }
    
}
