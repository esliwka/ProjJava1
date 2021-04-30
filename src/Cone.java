import java.util.Scanner;
import java.util.StringTokenizer;

public class Cone extends Solid {
    
    private double r;
    private double h;
    private double l;

    public Cone() {
        setName("Stozek");
    }

    public Cone(double r, double h, double l) {
        this.r = r;
        this.h = h;
        this.l = l;
        setName("Stozek");
    }

    public void parseLine(Scanner sc) throws ZeroException, NegativeException{
        String line = sc.nextLine();
        StringTokenizer st = new StringTokenizer(line);
        String t1,t2,t3;
        t1 = st.nextToken();
        t2 = st.nextToken();
        t3 = st.nextToken();
        r = Double.parseDouble(t1);
        h = Double.parseDouble(t2);
        l = Double.parseDouble(t3);
        if(r==0 || h==0 || l==0) throw new ZeroException();
        if(r<0 || h<0 || l<0) throw new NegativeException();
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
