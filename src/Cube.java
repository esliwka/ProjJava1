import java.util.Scanner;
import java.util.StringTokenizer;

public class Cube extends Cuboid {

    public Cube() {
        setName("Szescian");
    }

    public Cube(double a) {
        super(a, a, a);
        setName("Szescian");
    }
    
    public void parseLine(Scanner sc) throws ZeroException, NegativeException{
        String line = sc.nextLine();
        StringTokenizer st = new StringTokenizer(line);
        String t1;
        t1 = st.nextToken();
        double a = Double.parseDouble(t1);
        setA(a);
        setB(a);
        setH(a);
        if(a==0) throw new ZeroException();
        if(a<0) throw new NegativeException();
    }
    
}
