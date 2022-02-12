            package com.DiverPlan;

            import javax.swing.*;
            import java.awt.*;
            import java.awt.event.ActionEvent;
            import java.awt.event.ActionListener;

            public class multipleDiveINFO extends JFrame implements ActionListener {
                private JPanel upper, bottom;
                private JLabel div1DepthLabel, div1TimeLabel, div2DepthLabel, div2TimeLabel;
                private JLabel div3DepthLabel, div3TimeLabel, div1, div2, div3, div1SurfLabel, div2surfLabel;
                private JTextField div1DepthField, div1TimeField, div2DepthField;
                private JTextField  div2TimeField, div3DepthField, div3TimeField, div1sufField, div2surfField;
                private final JButton submit, cancel;
                MultiDiveGroup multiDiveGroup = null;

                multipleDiveINFO() {
                    multiDiveGroup=new MultiDiveGroup();
                    upper = createPanel(500, 470);
                    div1 = createLabel("First");
                    div1.setBounds(0, 15, 80, 15);
                    div2 = createLabel("Mid");
                    div2.setBounds(0, 185, 100, 15);
                    div3 = createLabel("Last");
                    div3.setBounds(300, 15, 80, 15);
                    upper.add(div1);
                    upper.add(div2);
                    upper.add(div3);
                    div1DepthLabel = createLabel("Depth(fts)");
                    div1DepthLabel.setBounds(20, 50, 80, 30);
                    div1TimeLabel = createLabel("Time(min)");
                    div1TimeLabel.setBounds(20, 100, 80, 30);
                    div3DepthLabel = createLabel("Depth(fts)");
                    div3DepthLabel.setBounds(250, 50, 80, 30);
                    div3DepthField = createField(20);
                    div3DepthField.setBounds(340, 50, 80, 30);
                    div3TimeLabel = createLabel("Time(min)");
                    div3TimeLabel.setBounds(250, 100, 80, 30);
                    div3TimeField = createField(20);
                    div3TimeField.setBounds(340, 100, 80, 30);
                    div1SurfLabel = createLabel("Interval");
                    div1SurfLabel.setBounds(20, 150, 80, 30);
                    div1sufField = createField(20);
                    div1sufField.setBounds(110, 150, 80, 30);
                    div2surfLabel = createLabel("Interval");
                    div2surfLabel.setBounds(20, 310, 80, 30);
                    div2surfField = createField(20);
                    div2surfField.setBounds(110, 310, 80, 30);
                    upper.add(div1SurfLabel);
                    upper.add(div1sufField);
                    upper.add(div2surfLabel);
                    upper.add(div2surfField);
                    upper.add(div3TimeField);
                    upper.add(div3TimeLabel);
                    upper.add(div3DepthLabel);
                    upper.add(div3DepthField);
                    div1TimeField = createField(20);
                    div1DepthField = createField(20);
                    div1DepthField.setBounds(110, 50, 80, 30);
                    div1TimeField.setBounds(110, 100, 80, 30);
                    upper.add(div1DepthLabel);
                    upper.add(div1TimeLabel);
                    upper.add(div1DepthField);
                    upper.add(div1TimeField);
                    div2DepthLabel = createLabel("Depth(fts)");
                    div2DepthLabel.setBounds(20, 210, 80, 30);
                    div2TimeLabel = createLabel("Time(min)");
                    div2TimeLabel.setBounds(20, 260, 80, 30);
                    div2TimeField = createField(20);
                    div2DepthField = createField(20);
                    div2DepthField.setBounds(110, 200, 150, 30);
                    div2TimeField.setBounds(110, 260, 150, 30);
                    upper.add(div2DepthLabel);
                    upper.add(div2TimeLabel);
                    upper.add(div2DepthField);
                    upper.add(div2TimeField);
                    submit = createButton("Submit",Color.BLUE,Color.pink);
                    cancel = createButton("Clear", Color.red, Color.LIGHT_GRAY);
                    submit.setBounds(260, 300, 80, 40);
                    cancel.setBounds(360, 300, 80, 40);
                    upper.add(submit);
                    upper.add(cancel);
                    add(upper);
                    setLayout(null);
                    setSize(500, 470);
                    setResizable(false);
                    setLocation(150, 30);
                    setTitle("   Multiple Dive");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setVisible(true);
                }

                JLabel createLabel(String text) {
                    JLabel label = new JLabel(text);
                    label.setFont(new Font("Arial", Font.PLAIN, 18));
                    return label;
                }
                JTextField createField(int columns) {
                    JTextField textField = new JTextField(columns);
                    textField.setFont(new Font("Arial", Font.PLAIN, 18));
                    return textField;
                }
                JPanel createPanel(int x, int y) {
                    JPanel panel = new JPanel();
                    panel.setLayout(null);
                    panel.setForeground(Color.black);
                    panel.setBackground(Color.CYAN);
                    panel.setSize(x, y);
                    return panel;
                }
                JButton createButton(String text, Color color, Color color1) {
                    JButton jButton = new JButton(text);
                    jButton.addActionListener(this);
                    jButton.setForeground(color);
                    jButton.setBackground(color1);
                    return jButton;
                }
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(e.getSource()==cancel){
                        div1DepthField.setText("");
                        div2DepthField.setText("");
                        div3DepthField.setText("");
                        div1TimeField.setText("");
                        div2TimeField.setText("");
                        div3TimeField.setText("");
                        div1sufField.setText("");
                        div2surfField.setText("");
                    }
                    if (e.getSource() == submit) {
                        // String y=div3DepthField.getText();
                        if (div1DepthField.getText().equals("")) {
                            JOptionPane.showMessageDialog(null, "First depth is missing");
                            return;
                        }
               else if (div1TimeField.getText().equals("")) {
                                JOptionPane.showMessageDialog(null, "First duration is missing");
                                return;
                            } else if (div2DepthField.getText().equals("")) {
                                JOptionPane.showMessageDialog(null, "Second depth is missing");
                                return;
                            } else if (div2TimeField.getText().equals("")) {
                                JOptionPane.showMessageDialog(null, "Second duration is missing");
                                return;
                            } else if (div1sufField.getText().equals("")) {
                                JOptionPane.showMessageDialog(null, "First surface interval is missing");
                                return;
                            } else if (div2surfField.getText().equals("")) {
                                JOptionPane.showMessageDialog(null, "Second surface interval is missing");
                                return;
                            } else if (div3TimeField.getText().equals("") && div3DepthField.getText().equals("")) {
                                JOptionPane.showMessageDialog(null, "Requires third depth\n or time to operate");
                            } else if (div3TimeField.getText().equals("")) {
                   int d1,t1,interval1,d2,t2,interval2,d3;
                   try {
                        d1 = Integer.parseInt(div1DepthField.getText());
                        t1 = Integer.parseInt(div1TimeField.getText());
                       interval1 = Integer.parseInt(div1sufField.getText());
                        d2 = Integer.parseInt(div2DepthField.getText());
                       t2 = Integer.parseInt(div2TimeField.getText());
                       interval2 = Integer.parseInt(div2surfField.getText());
                       d3 = Integer.parseInt(div3DepthField.getText());
                       if (d3>=d2||d2>=d1||d3>=d1){
                           JOptionPane.showMessageDialog(null,"dives should be in decreasing order");
                      return;
                       }
                       else {
                           multiDiveGroup.Case1(d1, t1, interval1, d2, t2, d3, interval2);
                       }
                   }  catch(Exception ex){
                           JOptionPane.showMessageDialog(null, "values should be in number format");
                       }
                            } else if (div3DepthField.getText().equals("")) {
                            int d1,t1,interval1,d2,t2,interval2,t3;
                            try {
                                d1 = Integer.parseInt(div1DepthField.getText());
                                t1 = Integer.parseInt(div1TimeField.getText());
                                interval1 = Integer.parseInt(div1sufField.getText());
                                d2 = Integer.parseInt(div2DepthField.getText());
                                t2 = Integer.parseInt(div2TimeField.getText());
                                interval2 = Integer.parseInt(div2surfField.getText());
                                t3 = Integer.parseInt(div3TimeField.getText());
                                if (d2>d1){
                                    JOptionPane.showMessageDialog(null,"Second dive should be shallower");
                                 return;
                                }
                                else {
                                    multiDiveGroup.Case2(d1, t1, interval1, d2, t2, t3, interval2);
                                }
                            }  catch(Exception ex){
                                JOptionPane.showMessageDialog(null, "None integer value Encountered");
                            }

                        } else {

                            }
                        }
                    }
                }