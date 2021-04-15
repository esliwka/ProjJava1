import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public abstract class Solid {

    private String name;
    public abstract double getVolume();
    public abstract double getArea();

    public String getName() {
        return name;
    }
    protected void setName(String name) {
        this.name = name;
    }

    public abstract void parseLine(Scanner sc);
    public void saveToFile(String str, PrintWriter pw) throws FileNotFoundException{
        pw.println(str);
        pw.flush();
    }

    @Override
    public String toString() {
        return name+" PP = "+getArea()+" V = "+getVolume();
    }

}
