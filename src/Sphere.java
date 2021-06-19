public class Sphere extends Solid {
    
    private double r;

    public Sphere() {
        this.name = "Sphere";
    }

    public Sphere(double r) {
        this.r = r;
        this.name = "Sphere";
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
