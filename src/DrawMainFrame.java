import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.io.*;
import java.nio.charset.StandardCharsets;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.filechooser.FileFilter;

public class DrawMainFrame extends JFrame implements Runnable {

    private ButtonPanel buttonPanel;
    private CalculationPanel calculationPanel;
    private ResultPanel resultPanel;
    private JTextField a = new JTextField(5), b = new JTextField(5), c = new JTextField(5);
    private JLabel result, aLabel, bLabel, cLabel;
    private String[] solidList = {"Cuboid", "Cube", "Cone", "Cylinder", "Sphere"};
    private JComboBox<String> cbSolidList;
    private String s1 = "Cuboid";

    public static void main(String[] args) {
        EventQueue.invokeLater(new DrawMainFrame("Solid calculator"));
    }

    @Override
    public void run() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // main app window
    public DrawMainFrame(String title) {
        super(title);
        setSize(600, 400);
        // adding 3 panels
        calculationPanel = new CalculationPanel(this);
        add(calculationPanel, BorderLayout.NORTH);
        resultPanel = new ResultPanel(this);
        add(resultPanel);
        buttonPanel = new ButtonPanel(this);
        buttonPanel.setBorder(new BevelBorder(BevelBorder.RAISED));
        add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }

    // panel with input elements
    class CalculationPanel extends JPanel {

        private JFrame parentFrame;

        public CalculationPanel(JFrame parentFrame) {
            this.parentFrame = parentFrame;
            setPreferredSize(new Dimension(parentFrame.getWidth(), parentFrame.getHeight() / 5));
            DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<>(solidList);
            cbSolidList = new JComboBox<String>(dcbm);
            add(cbSolidList);

            aLabel = new JLabel("a = ");
            add(aLabel);
            add(a);
            bLabel = new JLabel("b = ");
            add(bLabel);
            add(b);
            cLabel = new JLabel("h = ");
            add(cLabel);
            add(c);

            cbSolidList.addItemListener(
                    e -> {

                        if (e.getStateChange() == ItemEvent.SELECTED) {

                            switch (e.getItem().toString()) {
                                case "Cuboid" -> {
                                    a.setVisible(true);
                                    aLabel.setText("a = ");
                                    b.setVisible(true);
                                    bLabel.setText("b = ");
                                    c.setVisible(true);
                                    cLabel.setText("h = ");
                                    s1 = "Cuboid";
                                }

                                case "Cube" -> {
                                    a.setVisible(true);
                                    aLabel.setText("a = ");
                                    b.setVisible(false);
                                    bLabel.setText("");
                                    c.setVisible(false);
                                    cLabel.setText("");
                                    s1 = "Cube";
                                }

                                case "Cone" -> {
                                    a.setVisible(true);
                                    aLabel.setText("r = ");
                                    b.setVisible(true);
                                    bLabel.setText("h = ");
                                    c.setVisible(true);
                                    cLabel.setText("l = ");
                                    s1 = "Cone";
                                }

                                case "Cylinder" -> {
                                    a.setVisible(true);
                                    aLabel.setText("r = ");
                                    b.setVisible(true);
                                    bLabel.setText("h = ");
                                    c.setVisible(false);
                                    cLabel.setText("");
                                    s1 = "Cylinder";
                                }

                                case "Sphere" -> {
                                    a.setVisible(true);
                                    aLabel.setText("r = ");
                                    b.setVisible(false);
                                    bLabel.setText("");
                                    c.setVisible(false);
                                    cLabel.setText("");
                                    s1 = "Sphere";
                                }
                            }
                        }
                    });

        }
    }

    // panel displaying results
    class ResultPanel extends JPanel {

        private JFrame parentFrame;

        public ResultPanel(JFrame parentFrame) {
            this.parentFrame = parentFrame;
            setPreferredSize(new Dimension(parentFrame.getWidth(), parentFrame.getHeight() / 10 * 7));

            result = new JLabel("");
            add(result);
        }
    }

    // panel with main buttons
    class ButtonPanel extends JPanel {

        private JFrame parentFrame;
        private JButton calculateButton, clearButton, fileButton;

        public ButtonPanel(JFrame parentFrame) {
            this.parentFrame = parentFrame;
            setPreferredSize(new Dimension(parentFrame.getWidth(), parentFrame.getHeight() / 10));

            // adding buttons
            // file button - process input from file like in project 1
            fileButton = new JButton("File");
            fileButton.addActionListener(
                    e -> {
                        result.setText("");
                        // choose a file with input like in project 1 and process it, output to file
                        JFileChooser fc = new JFileChooser(new File("."));
                        fc.setMultiSelectionEnabled(false);
                        fc.setFileFilter(new FileFilter() {

                            @Override
                            public boolean accept(File f) {
                                return f.getName().contains("dat") || f.getName().contains("txt");
                            }

                            @Override
                            public String getDescription() {
                                // TODO Auto-generated method stub
                                return null;
                            }

                        });

                        int result = fc.showOpenDialog(parentFrame);
                        if (result == JFileChooser.APPROVE_OPTION) {

                            // ############################################################
                            // reading input filepath of the file pointed to by the user
                            String sfilePath = fc.getSelectedFile().getAbsolutePath();
                            // input output files
                            File fin;
                            if (sfilePath == null || sfilePath.isEmpty())
                                fin = new File("input.dat");
                            else
                                fin = new File(sfilePath);
                            File fout = new File("output.dat");
                            // reading input file, executing calculations, writing output
                            try (final var is = new FileInputStream(fin)) {
                                PrintWriter pw = new PrintWriter(fout);
                                final var r = new InputStreamReader(is, StandardCharsets.UTF_8);
                                final var br = new BufferedReader(r);
                                InputProcessing fh = new InputProcessing();
                                br.lines().map(fh::parseLine)
                                        .forEach(solid -> {
                                            fh.saveToFile(solid.toString(), pw);
                                            System.out.println(solid.toString());
                                        });
                                DrawMainFrame.this.result.setText("Output saved to output.dat");
                            }
                            // catching exceptions
                            catch (FileNotFoundException ex) {
                                System.out.println("File not found");
                                DrawMainFrame.this.result.setText("File not found");
                            } catch (ZeroException ex) {
                                System.out.println(ex.getMessage());
                                DrawMainFrame.this.result.setText(ex.getMessage());
                            } catch (NegativeException ex) {
                                System.out.println(ex.getMessage());
                                DrawMainFrame.this.result.setText(ex.getMessage());
                            } catch (IllegalStateException ex) {
                                System.out.println("Solid type not recognized: " + ex.getMessage());
                                DrawMainFrame.this.result.setText("Solid type not recognized: " + ex.getMessage());
                            } catch (IOException ioException) {
                                ioException.printStackTrace();
                            }
                            // ############################################################
                        }
                    });
            add(fileButton);

            // clear button
            clearButton = new JButton("Clear all");
            clearButton.addActionListener(
                    e -> {
                        // clear input fields and result panel
                        a.setText("");
                        b.setText("");
                        c.setText("");
                        result.setText("");
                    });
            add(clearButton);

            // calculate button
            calculateButton = new JButton("Calculate");
            calculateButton.addActionListener(
                    e -> {
                        // calculate and display results in the results panel
                        InputProcessing ip = new InputProcessing();
                        try {
                            ip.screenCalculate(s1, Double.parseDouble(a.getText()), Double.parseDouble(b.getText()), Double.parseDouble(c.getText()), result);
                        } catch (NumberFormatException numberFormatException) {
                            result.setText("Incorrect input");
                        } catch (NegativeException negativeException) {
                            result.setText("Input can't be negative");
                        } catch (ZeroException zeroException) {
                            result.setText("Input can't be 0");
                        }
                    });
            add(calculateButton);
        }

    }

}