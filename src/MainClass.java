import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) throws FileNotFoundException,ZeroException,NegativeException {

        // cli prompt
        System.out.println("Podaj ścieżkę do pliku z danymi np. src\\danewejsciowe.dat\nWyniki zostaną zapisane do pliku output.dat.");
        // reading input filepath from user
        Scanner inputPath = new Scanner(System.in);
        String sfilePath = inputPath.nextLine();
        inputPath.close();
        System.out.println(sfilePath);
        // input output files
        File fin;
        if (sfilePath == null || sfilePath.isEmpty()){
            fin = new File("src\\input.dat");
        }
        else {
            fin = new File(sfilePath);
        }
        File fout = new File("src\\output.dat");
        // reading input file, executing calculations, writing output
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
                    // writing to the output file
                    s1.saveToFile(s1.toString(), pw);
                }
            } finally {
                sc.close();
            }
        }
        // catching exceptions
        catch(FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku");
        }
        catch(ZeroException e) {
            System.out.println(e.getMessage());
        }
        catch(NegativeException e) {
            System.out.println(e.getMessage());
        }

    }

}