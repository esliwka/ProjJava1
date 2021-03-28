public class Ball extends Solid {
    private double radius;
    final double PI = 3.14;

    public Ball(double radius) {
        super("ball");
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return 4/3 * PI * Math.pow(this.radius, 3);
    }

    public double getVolume() {
        return 4 * PI * Math.pow(this.radius, 2);
    }

}
