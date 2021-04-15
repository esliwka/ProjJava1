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
    
    public void parseLine(Scanner sc){
        String line = sc.nextLine();
        StringTokenizer st = new StringTokenizer(line);
        String t1;
        t1 = st.nextToken();
        setA(Double.parseDouble(t1));
        setB(Double.parseDouble(t1));
        setH(Double.parseDouble(t1));
    }
    
}
