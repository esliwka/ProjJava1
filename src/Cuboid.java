import java.util.Scanner;
import java.util.StringTokenizer;

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

    public void parseLine(Scanner sc){
        String line = sc.nextLine();
        StringTokenizer st = new StringTokenizer(line);
        String t1,t2,t3;
        t1 = st.nextToken();
        t2 = st.nextToken();
        t3 = st.nextToken();
        a = Double.parseDouble(t1);
        b = Double.parseDouble(t2);
        h = Double.parseDouble(t3);
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
