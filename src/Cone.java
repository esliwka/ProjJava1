public class Cone extends Solid {
    
    private double r;
    private double h;
    private double l;

    public Cone() {
        this.name = "Cone";
    }

    public Cone(double r, double h, double l) {
        this.r = r;
        this.h = h;
        this.l = l;
        this.name = "Cone";
    }

    @Override
    public double getVolume() {
        return Math.PI*r*l*h/3;
    }
    @Override
    public double getArea() {
        return Math.PI*r*(l+2*r);
    }
    
}
