public class Sphere extends Solid {
    
    private double r;

    public Sphere(double r) {
        this.r = r;
        setName("Kula");
    }

    @Override
    public double getVolume() {
        return 4*Math.PI*Math.pow(r,3)/3;
    }
    @Override
    public double getArea() {
        return 4*Math.PI*Math.pow(r,2);
    }
    
}
