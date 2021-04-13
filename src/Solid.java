public abstract class Solid {

    private String name;
    public abstract double getVolume();
    public abstract double getArea();

    public String getName() {
        return name;
    }
    protected void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name+" "+getArea()+" "+getVolume();
    }

}
