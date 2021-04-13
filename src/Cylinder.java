public class Cylinder extends Solid {
    
    private double r;
    private double h;

    public Cylinder(double r, double h) {
        this.r = r;
        this.h = h;
        setName("Walec");
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
