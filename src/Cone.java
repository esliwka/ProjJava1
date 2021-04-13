public class Cone extends Solid {
    
    private double r;
    private double h;
    private double l;

    public Cone(double r, double h, double l) {
        this.r = r;
        this.h = h;
        this.l = l;
        setName("Stozek");
    }

    @Override
    public double getVolume() {
        return 1/3*Math.PI*r*l*h;
    }
    @Override
    public double getArea() {
        return Math.PI*r*(l+2*r);
    }
    
}
