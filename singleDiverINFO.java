            package com.DiverPlan;

            import javax.swing.*;
            import java.awt.*;
            import java.awt.event.ActionEvent;
            import java.awt.event.ActionListener;

            public class singleDiverINFO  extends JFrame implements ActionListener {
            private  JLabel depthLabel,timeLabel;
            private JTextField depthField,timeField;
            private JPanel panel;
            JButton submit,cancel;
            private SingleModeGroup sglDiveType=null;
            singleDiverINFO(){
                sglDiveType=new SingleModeGroup();
                panel=createPanel();
                depthLabel=createLabel("Enter Depth(fts)");
                depthLabel.setBounds(20,50,120,40);
                timeLabel=createLabel("Time(Optional)");
                timeLabel.setBounds(20,100,120,40);
                depthField=createField(20);
                depthField.setBounds(160,50,150,30);
                timeField=createField(20);
                timeField.setBounds(160,100,150,30);
                submit=createButton("Submit",Color.BLUE,Color.pink);
                cancel=createButton("Clear",Color.red,Color.LIGHT_GRAY);
                submit.setBounds(220,200,80,40);
                cancel.setBounds(100,200,80,40);
                panel.add(depthLabel);
                panel.add(depthField);
                panel.add(timeLabel);
                panel.add(timeField);
                panel.add(submit);
                panel.add(cancel);
                add(panel);
                setSize(400,400);
                setResizable(false);
                setLocation(150,30);
                setTitle("    SINGLE DIVE");
                setLayout(null);
                setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                setVisible(true);
            }
            JLabel createLabel(String text){
                JLabel label=new JLabel(text);
                label.setFont(new Font("Arial", Font.PLAIN,17));
                return label;
            }
            JTextField createField(int columns){
                JTextField textField=new JTextField(columns);
                textField.setFont(new Font("Arial",Font.PLAIN,18));
                return textField;
            }
                JPanel createPanel(){
                    JPanel panel=new JPanel();
                    panel.setLayout(null);
                    panel.setForeground(Color.black);
                    panel.setBackground(Color.CYAN);
                    panel.setBounds(0,0,400,400);
                    return panel;
            }
            JButton createButton(String text,Color color,Color color1){
                JButton jButton=new JButton(text);
                jButton.addActionListener(this);
                jButton.setForeground(color);
                jButton.setBackground(color1);
                return jButton;
            }
                @Override
                public void actionPerformed(ActionEvent e) {
                if (e.getSource()==cancel){
                    depthField.setText("");
                    timeField.setText("");
                }
            if (e.getSource()==submit){
                if (depthField.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Depth field cannot be empty");
                    return;
                }
                else if (timeField.getText().equals("")){
                    int depth;
                    try {
                        depth = Integer.parseInt(depthField.getText());
                        sglDiveType.Case1(depth);
                    }catch (Exception ex1){
                        JOptionPane.showMessageDialog(null,"values should be in number format");
                    }

                }
                else{
                    int depth,duration;
                    try {
                        depth = Integer.parseInt(depthField.getText());
                        duration = Integer.parseInt(timeField.getText());
                        sglDiveType.Case2(depth, duration);
                    }catch (Exception ex2){
                        JOptionPane.showMessageDialog(null,"values should be in number format");
                    }
                }
            }
                }
            }
