import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MainClass {
    
    public static void main(String[] args) throws FileNotFoundException {

        // input file
        File fin = new File("src\\input.dat");
        File fout = new File("src\\output.dat");

        // try(Scanner sc = new Scanner(f)) {
            
        // } catch (Exception e) {
        //     //TODO: handle exception
        // }
        
        // Cone 3 arguments
        // Cube 1
        // Cuboid 3
        // Cylinder 2
        // Sphere 1

        Scanner sc = new Scanner(fin);
        PrintWriter pw = new PrintWriter(fout);
        while(sc.hasNextLine()){
            Solid s1 = new Cuboid();
            s1.parseLine(sc);
            System.out.println(s1.toString());
            s1.saveToFile(s1.toString(), pw);
        }

    }

}
