import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MainClass {
    
    public static void main(String[] args) throws FileNotFoundException,ZeroException,NegativeException {

        // input file
        File fin = new File("src\\input.dat");
        File fout = new File("src\\output.dat");

        try {
            Scanner sc = new Scanner(fin);
            PrintWriter pw = new PrintWriter(fout);
            try {
                while (sc.hasNextLine()) {
                    Solid s1 = new Cuboid();
                    s1.parseLine(sc);
                    System.out.println(s1.toString());
                    s1.saveToFile(s1.toString(), pw);
                }
            }
            finally {
                sc.close();
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku");
        }
        catch(ZeroException e) {
            System.out.println(e.getMessage());
        }
        catch(NegativeException e) {
            System.out.println(e.getMessage());
        }

        // Cone 3 arguments
        // Cube 1
        // Cuboid 3
        // Cylinder 2
        // Sphere 1

    }

}
