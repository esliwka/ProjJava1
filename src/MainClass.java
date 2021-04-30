import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) throws FileNotFoundException,ZeroException,NegativeException {
        System.out.println("Podaj ścieżkę do pliku z danymi (Format: [typ_bryły] [wymiar1] *[wymiar2] *[wymiar3]). Wyniki zostaną zapisane do pliku output.dat.");
        Scanner inputPath = new Scanner(System.in);
        String sfilePath = inputPath.nextLine();
        System.out.println(sfilePath);
        // input file
        File fin = new File(sfilePath);
        File fout = new File("src\\output.dat");
        Solid s1;
        try (Scanner sc = new Scanner(fin)) {
            PrintWriter pw = new PrintWriter(fout);
            try {
                while (sc.hasNextLine()) {
                    String solidType = sc.next();
                    s1 = switch (solidType) {
                        case "Cuboid" -> new Cuboid();
                        case "Cube" -> new Cube();
                        case "Cone" -> new Cone();
                        case "Cylinder" -> new Cylinder();
                        case "Sphere" -> new Sphere();
                        default -> throw new IllegalStateException("Unexpected value: " + solidType);
                    };
                    s1.parseLine(sc);
                    System.out.println(s1.toString());
                    s1.saveToFile(s1.toString(), pw);
                }
            } finally {
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