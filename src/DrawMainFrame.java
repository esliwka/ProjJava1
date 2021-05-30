import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class DrawMainFrame extends JFrame implements Runnable {

    private ButtonPanel buttonPanel;
    private CalculationPanel calculationPanel;
    private ResultPanel resultPanel;
    private JTextField a = new JTextField(5), b = new JTextField(5), c = new JTextField(5);
    private JLabel result, aLabel, bLabel, cLabel;
    private String[] solidList = {"Cuboid", "Cube", "Cone", "Sphere", "Cylinder"};
    private JComboBox<String> cbSolidList;
    private Solid s1 = new Cuboid();

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
            setPreferredSize(new Dimension(parentFrame.getWidth(), parentFrame.getHeight()/5));
            DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<>(solidList);
            cbSolidList = new JComboBox<String>(dcbm);
            add(cbSolidList);
            
            JCheckBox volumeCheckBox = new JCheckBox("Volume");
            JCheckBox areaCheckBox = new JCheckBox("Area");
            volumeCheckBox.setSelected(true);
            areaCheckBox.setSelected(true);
            add(volumeCheckBox);
            add(areaCheckBox);

            aLabel = new JLabel("a = ");
            add(aLabel);
            add(a);
            bLabel = new JLabel("b = ");
            add(bLabel);
            add(b);
            cLabel = new JLabel("h = ");
            add(cLabel);
            add(c);

            cbSolidList.addItemListener(new ItemListener(){

                @Override
                public void itemStateChanged(ItemEvent e) {

                    // System.out.println(e.getItem() + " " + e.getStateChange());

                    if(e.getStateChange() == ItemEvent.SELECTED) {

                        switch (e.getItem().toString()) {
                            case "Cuboid":
                                a.setVisible(true);
                                aLabel.setText("a = ");
                                aLabel.setVisible(true);
                                b.setVisible(true);
                                bLabel.setText("b = ");
                                bLabel.setVisible(true);
                                c.setVisible(true);
                                cLabel.setText("h = ");
                                cLabel.setVisible(true);
                                s1 = new Cuboid();
                                break;

                            case "Cube":
                                a.setVisible(true);
                                aLabel.setText("a = ");
                                aLabel.setVisible(true);
                                b.setVisible(false);
                                bLabel.setVisible(false);
                                c.setVisible(false);
                                cLabel.setVisible(false);
                                s1 = new Cube();
                                break;
                        
                            default:
                                break;
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
            setPreferredSize(new Dimension(parentFrame.getWidth(), parentFrame.getHeight()/10*7));

            result = new JLabel("");
            add(result);
            // result.setVisible(false);
        }
    }

    // panel with main buttons
    class ButtonPanel extends JPanel {

        private JFrame parentFrame;
        private JButton calculateButton, clearButton, exportResultsButton;

        public ButtonPanel(JFrame parentFrame) {
            this.parentFrame = parentFrame;
            setPreferredSize(new Dimension(parentFrame.getWidth(), parentFrame.getHeight()/10));

            // adding buttons
            // export button - process input button instead?
            // exportResultsButton = new JButton("Export results");
            // exportResultsButton.addActionListener(new ActionListener(){

            //     @Override
            //     public void actionPerformed(ActionEvent e) {
            //         // check for results and export into a file or inform theres nothing to export
            //         // [fill]
            //     }
                
            // });
            // add(exportResultsButton);

            // clear button
            clearButton = new JButton("Clear all");
            clearButton.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent e) {
                    // clear input fields and result panel
                    a.setText("");
                    b.setText("");
                    c.setText("");
                    result.setText("");
                }
            });
            add(clearButton);

            // calculate button
            calculateButton = new JButton("Calculate");
            calculateButton.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent e) {
                    // calculate and display results in the results panel
                    // [fix]
                    // if(a.getText().length()>0) {
                    //     double val = Double.parseDouble(a.getText());
                    //     result.setText(Double.toString(((UnitConversionAlgorithm)cbJednostki.getSelectedItem()).changeUnit(val)));
                    // }

                    switch (s1.getName()) {
                        case "Prostopadloscian":
                            if(a.getText().length() > 0 && b.getText().length() > 0 && c.getText().length() > 0) {
                                s1 = new Cuboid(Double.parseDouble(a.getText()), Double.parseDouble(b.getText()), Double.parseDouble(c.getText()));
                            result.setText("V = " + s1.getVolume() + "  SA = " + s1.getArea());
                            }
                            else {
                                result.setText("Uzupelnij wszystkie pola.");
                            }
                            break;

                        case "Szescian":
                            a.setVisible(true);
                            aLabel.setText("a = ");
                            aLabel.setVisible(true);
                            b.setVisible(false);
                            bLabel.setVisible(false);
                            c.setVisible(false);
                            cLabel.setVisible(false);
                            break;
                    
                        default:
                            break;
                    }
                }
            });
            add(calculateButton);
        }

    }

}