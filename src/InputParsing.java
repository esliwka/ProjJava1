import javax.swing.JLabel;
import javax.swing.JTextField;

public class InputParsing {

public void screenCalculate(Solid s1, JTextField a, JTextField b, JTextField c, JLabel result){

    try {
        switch (s1.getName()) {
            case "Cuboid" -> {
                if(a.getText().length() > 0 && b.getText().length() > 0 && c.getText().length() > 0) {
                    Double t1,t2,t3;
                    t1 = Double.parseDouble(a.getText());
                    t2 = Double.parseDouble(b.getText());
                    t3 = Double.parseDouble(c.getText());
                    if(t1==0 || t2==0 || t3==0) throw new ZeroException();
                    if(t1<0 || t2<0 || t3<0) throw new NegativeException();
                    s1 = new Cuboid(t1, t2, t3);
                    result.setText(s1.toString());
                }
                else
                    result.setText("Input missing");
            }

            case "Cube" -> {
                if(a.getText().length() > 0) {
                    Double t1;
                    t1 = Double.parseDouble(a.getText());
                    if(t1==0) throw new ZeroException();
                    if(t1<0) throw new NegativeException();
                    s1 = new Cube(t1);
                    result.setText(s1.toString());
                }
                else
                    result.setText("Input missing");
            }

            case "Cone" -> {
                if(a.getText().length() > 0 && b.getText().length() > 0 && c.getText().length() > 0) {
                    Double t1,t2,t3;
                    t1 = Double.parseDouble(a.getText());
                    t2 = Double.parseDouble(b.getText());
                    t3 = Double.parseDouble(c.getText());
                    if(t1==0 || t2==0 || t3==0) throw new ZeroException();
                    if(t1<0 || t2<0 || t3<0) throw new NegativeException();
                    s1 = new Cone(t1, t2, t3);
                    result.setText(s1.toString());
                }
                else
                    result.setText("Input missing");
            }

            case "Cylinder" -> {
                if(a.getText().length() > 0 && b.getText().length() > 0) {
                    Double t1,t2;
                    t1 = Double.parseDouble(a.getText());
                    t2 = Double.parseDouble(b.getText());
                    if(t1==0 || t2==0) throw new ZeroException();
                    if(t1<0 || t2<0) throw new NegativeException();
                    s1 = new Cylinder(t1, t2);
                    result.setText(s1.toString());
                }
                else
                    result.setText("Input missing");
            }

            case "Sphere" -> {
                if(a.getText().length() > 0) {
                    Double t1;
                    t1 = Double.parseDouble(a.getText());
                    if(t1==0) throw new ZeroException();
                    if(t1<0) throw new NegativeException();
                    s1 = new Sphere(t1);
                    result.setText(s1.toString());
                }
                else
                    result.setText("Input missing");
            }
        }

    } // catching exceptions
    catch (NumberFormatException numberFormatException) {
        result.setText("Incorrect input");
    }
    catch(ZeroException e) {
        result.setText(e.getMessage());
    }
    catch(NegativeException e) {
        result.setText(e.getMessage());
    }

}
}