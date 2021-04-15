import java.util.Scanner;
import java.util.StringTokenizer;

public class Cylinder extends Solid {
    
    private double r;
    private double h;

    public Cylinder() {
        setName("Walec");
    }

    public Cylinder(double r, double h) {
        this.r = r;
        this.h = h;
        setName("Walec");
    }

    public void parseLine(Scanner sc){
        String line = sc.nextLine();
        StringTokenizer st = new StringTokenizer(line);
        String t1,t2;
        t1 = st.nextToken();
        t2 = st.nextToken();
        r = Double.parseDouble(t1);
        h = Double.parseDouble(t2);
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
