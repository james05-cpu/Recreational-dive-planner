        package com.DiverPlan;

        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        public class doubleDiveINFO extends JFrame implements ActionListener {
            private JPanel upper, bottom;
            private JLabel div1DepthLabel, div1TimeLabel, div2DepthLabel;
            private JLabel div2surfLabel, div2TimeLabel, div1, div2;
            private JTextField div1DepthField, div1TimeField, div2surfField, div2DepthField, div2TimeField;
            private JButton submit, cancel;
        private DoubleDiverGroup doubleDiverGroup=null;
            doubleDiveINFO() {
                doubleDiverGroup=new DoubleDiverGroup();
                upper = createPanel(400, 500);
                div1 = createLabel("First Dive");
                div1.setBounds(160, 15, 100, 15);
                div2 = createLabel("Last Dive");
                div2.setBounds(160, 135, 100, 15);
                upper.add(div1);
                upper.add(div2);
                div1DepthLabel = createLabel("Enter Depth(fts)");
                div1DepthLabel.setBounds(20, 50, 150, 30);
                div1TimeLabel = createLabel("Set Time(min)");
                div1TimeLabel.setBounds(20, 100, 150, 30);
                div1TimeField = createField(20);
                div1DepthField = createField(20);
                div1DepthField.setBounds(160, 50, 150, 30);
                div1TimeField.setBounds(160, 100, 150, 30);
                upper.add(div1DepthLabel);
                upper.add(div1TimeLabel);
                upper.add(div1DepthField);
                upper.add(div1TimeField);
                div2DepthLabel = createLabel("Enter Depth(fts)");
                div2DepthLabel.setBounds(20, 160, 150, 30);
                div2TimeLabel = createLabel("Set Time(min)");
                div2TimeLabel.setBounds(20, 220, 150, 30);
                div2TimeField = createField(20);
                div2DepthField = createField(20);
                div2DepthField.setBounds(160, 170, 150, 30);
                div2TimeField.setBounds(160, 220, 150, 30);
                div2surfLabel = createLabel("Interval");
                div2surfLabel.setBounds(20, 270, 80, 30);
                div2surfField = createField(20);
                div2surfField.setBounds(110, 270, 150, 30);
                upper.add(div2DepthLabel);
                upper.add(div2TimeLabel);
                upper.add(div2DepthField);
                upper.add(div2TimeField);
                upper.add(div2surfLabel);
                upper.add(div2surfField);
                ;
                submit = createButton("Submit", Color.BLUE, Color.pink);
                cancel = createButton("Clear", Color.red, Color.LIGHT_GRAY);
                submit.setBounds(200, 320, 80, 40);
                cancel.setBounds(100, 320, 80, 40);
                upper.add(submit);
                upper.add(cancel);
                add(upper);
                setLayout(null);
                setSize(400, 500);
                setResizable(false);
                setTitle("Double Dive");
                setLocation(150, 30);
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
                if (e.getSource()==cancel){
                    div1DepthField.setText("");
                    div2DepthField.setText("");
                    div1TimeField.setText("");
                    div2TimeField.setText("");
                    div2surfField.setText("");
                }
                if (e.getSource() == submit) {
                    if (div1DepthField.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "First depth is missing");
                        return;
                    }
                    else if (div1TimeField.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "First duration is missing");
                        return;
                    }
                   else if (div2surfField.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "First surface interval is missing");
                        return;
                    }
                   else if(div2DepthField.getText().equals("") && div2TimeField.getText().equals("")){
                       JOptionPane.showMessageDialog(null,"Second depth or time is missing");
                       return;
                    }
                   else if (div2TimeField.getText().equals("")) {
                       int d1,t1,interval,d2;
                       try {
                           d1 = Integer.parseInt(div1DepthField.getText());
                           t1 = Integer.parseInt(div1TimeField.getText());
                           interval = Integer.parseInt(div2surfField.getText());
                            d2= Integer.parseInt(div2DepthField.getText());
                           if (d2>=d1){
                               JOptionPane.showMessageDialog(null,"Second dive should be shallower");
                               return;
                           }
                           else {
                               doubleDiverGroup.Case1(d1, t1, d2, interval);
                           }
                       }
                       catch(Exception ex){
                           JOptionPane.showMessageDialog(null, "values should be in number format");
                       }
                    }
                   else if (div2DepthField.getText().equals("")) {
                        int d1,t1,interval,t2;
                        try {
                            d1 = Integer.parseInt(div1DepthField.getText());
                            t1 = Integer.parseInt(div1TimeField.getText());
                            interval = Integer.parseInt(div2TimeField.getText());
                            t2= Integer.parseInt(div2TimeField.getText());
                            doubleDiverGroup.Case2(d1,t1,t2,interval);
                        }
                        catch(Exception ex){
                            JOptionPane.showMessageDialog(null, "Values should be in number format");
                        }
                    }
                    }
                   else {

                    }
                }
            }