import java.util.Scanner;
import java.util.StringTokenizer;

public class Sphere extends Solid {
    
    private double r;

    public Sphere() {
        setName("Kula");
    }

    public Sphere(double r) {
        this.r = r;
        setName("Kula");
    }

    public void parseLine(Scanner sc){
        String line = sc.nextLine();
        StringTokenizer st = new StringTokenizer(line);
        String t1;
        t1 = st.nextToken();
        r = Double.parseDouble(t1);
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
