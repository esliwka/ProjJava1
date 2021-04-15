import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainClass {
    
    public static void main(String[] args) throws FileNotFoundException {

        // input file
        File f = new File("src\\input.dat");

        // try(Scanner sc = new Scanner(f)) {
            
        // } catch (Exception e) {
        //     //TODO: handle exception
        // }
        
        // Solid s1 = new Cone(2, 3, 4);
        // Solid s2 = new Cube(5);
        // Solid s3 = new Cuboid(2, 3, 4);
        // Solid s4 = new Cylinder(2,5);
        // Solid s5 = new Sphere(10);
        // System.out.println(s1.toString());
        // System.out.println(s2.toString());
        // System.out.println(s3.toString());
        // System.out.println(s4.toString());
        // System.out.println(s5.toString());

        Scanner sc = new Scanner(f);
        Solid s1 = new Cuboid(0,0,0);
        s1.parseLine(sc);
        System.out.println(s1.toString());

    }

}
