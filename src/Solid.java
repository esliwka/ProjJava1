public abstract class Solid {

    protected String name;
    public abstract double getVolume();
    public abstract double getArea();

    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return name+" SA = "+getArea()+" V = "+getVolume();
    }

}