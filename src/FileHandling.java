import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileHandling {
    
    // parsing line from input file depending on the type of solid
    public Solid parseLine(Scanner sc) throws ZeroException, NegativeException {

        String solidType = sc.next();
        String line = sc.nextLine();
        StringTokenizer st = new StringTokenizer(line);
        Solid s1 = switch (solidType) {
            case "Cone" ->
            {
                Double t1,t2,t3;
                t1 = Double.parseDouble(st.nextToken());
                t2 = Double.parseDouble(st.nextToken());
                t3 = Double.parseDouble(st.nextToken());
                if(t1==0 || t2==0 || t3==0) throw new ZeroException();
                if(t1<0 || t2<0 || t3<0) throw new NegativeException();
                yield new Cone(t1, t2, t3);
            }
            case "Cube" -> {
                Double t1;
                t1 = Double.parseDouble(st.nextToken());
                if(t1==0) throw new ZeroException();
                if(t1<0) throw new NegativeException();
                yield new Cube(t1);
            }
            case "Cuboid" -> {
                Double t1,t2,t3;
                t1 = Double.parseDouble(st.nextToken());
                t2 = Double.parseDouble(st.nextToken());
                t3 = Double.parseDouble(st.nextToken());
                if(t1==0 || t2==0 || t3==0) throw new ZeroException();
                if(t1<0 || t2<0 || t3<0) throw new NegativeException();
                yield new Cuboid(t1, t2, t3);
            }
            case "Cylinder" -> {
                Double t1,t2;
                t1 = Double.parseDouble(st.nextToken());
                t2 = Double.parseDouble(st.nextToken());
                if(t1==0 || t2==0) throw new ZeroException();
                if(t1<0 || t2<0) throw new NegativeException();
                yield new Cylinder(t1, t2);
            }
            case "Sphere" -> {
                Double t1;
                t1 = Double.parseDouble(st.nextToken());
                if(t1==0) throw new ZeroException();
                if(t1<0) throw new NegativeException();
                yield new Sphere(t1);
            }
            default -> throw new IllegalStateException(solidType);
        };
        return s1;
    }

    // writing to output file
    public void saveToFile(String str, PrintWriter pw) throws FileNotFoundException{
        pw.println(str);
        pw.flush();
    }

}

class ZeroException extends Exception {
    public ZeroException(){
        super("Input can't be 0");
    }
}

class NegativeException extends Exception {
    public NegativeException(){
        super("Input can't be negative");
    }
}