public class Cuboid extends Solid {
    
    private double a;
    private double b;
    private double h;

    public Cuboid(double a, double b, double h) {
        this.a = a;
        this.b = b;
        this.h = h;
        setName("Prostopadloscian");
    }

    @Override
    public double getVolume() {
        return a*b*h;
    }
    @Override
    public double getArea() {
        return 2*(a*b+a*h+b*h);
    }

}
