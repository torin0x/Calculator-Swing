package com.Kuster;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class JavaCalculatorGUI extends JFrame implements ActionListener {

    static double a = 0, b = 0, result = 0;
    static int operator = 0;
    HashMap<String, String> calculations = new HashMap<>();

    JButton key1 = new JButton("1");
    JButton key2 = new JButton("2");
    JButton key3 = new JButton("3");
    JButton key4 = new JButton("4");
    JButton key5 = new JButton("5");
    JButton key6 = new JButton("6");
    JButton key7 = new JButton("7");
    JButton key8 = new JButton("8");
    JButton key9 = new JButton("9");
    JButton key0 = new JButton("0");
    JButton keyFill = new JButton("");
    JButton keySubtraction = new JButton("-");
    JButton keyAddition = new JButton("+");
    JButton keyDivision = new JButton("/");
    JButton keyMultiplication = new JButton("*");
    JButton keyClear = new JButton("Clear");
    JTextField display = new JTextField();
    JButton keyCalculate = new JButton("=");
    JLabel state = new JLabel("Calculation: ");
    JLabel recentCalculationsLabel = new JLabel("Recent calculations: ");
    JTextArea recentCalculationsTextArea = new JTextArea(5, 1);
    JScrollPane scroll = new JScrollPane(recentCalculationsTextArea);


    //Panels
    JPanel keyPanel = new JPanel();
    JPanel keyDisplayPanel = new JPanel();
    JPanel labelPanel = new JPanel();
    JPanel clearPanel = new JPanel();
    JPanel operandPanel = new JPanel();
    JPanel recentCalculationsPanel = new JPanel();


    public JavaCalculatorGUI() {
        super("Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(20, 20));
        // Panel Layout
        keyPanel.setLayout(new GridLayout(4, 3, 20, 20));
        keyDisplayPanel.setLayout(new BorderLayout(20, 20));
        labelPanel.setLayout(new BorderLayout(20, 20));
        clearPanel.setLayout(new BorderLayout(20, 20));
        operandPanel.setLayout(new GridLayout(4, 1, 20, 20));
        recentCalculationsPanel.setLayout(new BorderLayout(20, 20));


        // add keys to keyPanel
        keyPanel.add(key1);
        keyPanel.add(key2);
        keyPanel.add(key3);
        keyPanel.add(keyAddition);
        keyPanel.add(key4);
        keyPanel.add(key5);
        keyPanel.add(key6);
        keyPanel.add(keySubtraction);
        keyPanel.add(key7);
        keyPanel.add(key8);
        keyPanel.add(key9);
        keyPanel.add(keyMultiplication);
        keyPanel.add(key0);
        keyPanel.add(keyDivision);
        keyPanel.add(keyFill);
        keyFill.setVisible(false);
        keyPanel.add(key0);
        keyPanel.add(keyCalculate);
        operandPanel.add(keyAddition);
        operandPanel.add(keySubtraction);
        operandPanel.add(keyMultiplication);
        operandPanel.add(keyDivision);


        // top Panel
        labelPanel.add(state, BorderLayout.WEST);
        labelPanel.add(display, BorderLayout.CENTER);
        display.setEditable(false);
        // Clear Panel
        clearPanel.add(keyClear, BorderLayout.CENTER);

        recentCalculationsPanel.add(recentCalculationsLabel, BorderLayout.WEST);
        recentCalculationsPanel.add(scroll, BorderLayout.CENTER);
        recentCalculationsTextArea.setEditable(false);
        // alignment
        keyDisplayPanel.add(keyPanel, BorderLayout.CENTER);
        keyDisplayPanel.add(labelPanel, BorderLayout.NORTH);
        keyDisplayPanel.add(clearPanel, BorderLayout.WEST);
        keyDisplayPanel.add(operandPanel, BorderLayout.EAST);
        keyDisplayPanel.add(recentCalculationsPanel, BorderLayout.SOUTH);
        keyDisplayPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        getContentPane().add(keyDisplayPanel, BorderLayout.CENTER);
        // set keys to listener
        key1.addActionListener(this);
        key2.addActionListener(this);
        key3.addActionListener(this);
        key4.addActionListener(this);
        key5.addActionListener(this);
        key6.addActionListener(this);
        key7.addActionListener(this);
        key8.addActionListener(this);
        key9.addActionListener(this);
        key0.addActionListener(this);
        keyMultiplication.addActionListener(this);
        keyAddition.addActionListener(this);
        keyDivision.addActionListener(this);
        keySubtraction.addActionListener(this);
        keyCalculate.addActionListener(this);
        keyClear.addActionListener(this);

        setVisible(true);
        setSize(600, 400);

    }
    //Calculator
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == key1) {
            this.display.setText(this.display.getText() + "1");
        }
        if (e.getSource() == key2) {
            this.display.setText(this.display.getText() + "2");
        }
        if (e.getSource() == key3) {
            this.display.setText(this.display.getText() + "3");
        }
        if (e.getSource() == key4) {
            this.display.setText(this.display.getText() + "4");
        }
        if (e.getSource() == key5) {
            this.display.setText(this.display.getText() + "5");
        }
        if (e.getSource() == key6) {
            this.display.setText(this.display.getText() + "6");
        }
        if (e.getSource() == key7) {
            this.display.setText(this.display.getText() + "7");
        }
        if (e.getSource() == key8) {
            this.display.setText(this.display.getText() + "8");
        }
        if (e.getSource() == key9) {
            this.display.setText(this.display.getText() + "9");
        }
        if (e.getSource() == key0) {
            this.display.setText(this.display.getText() + "0");
        }
        if (e.getSource() == keyAddition) {
            a = Double.parseDouble(display.getText());
            operator = 1;
            display.setText("");
        }

        if (e.getSource() == keySubtraction) {
            a = Double.parseDouble(display.getText());
            operator = 2;
            display.setText("");
        }

        if (e.getSource() == keyMultiplication) {
            a = Double.parseDouble(display.getText());
            operator = 3;
            display.setText("");
        }
        if (e.getSource() == keyDivision) {
            a = Double.parseDouble(display.getText());
            operator = 4;
            display.setText("");
        }

        if (e.getSource() == keyCalculate) {
            b = Double.parseDouble(display.getText());
            String calculation = null;
            switch (operator) {
                case 1:
                    result = a + b;
                    calculation = a + " + " + b;
                    break;

                case 2:
                    result = a - b;
                    calculation = a + " - " + b;
                    break;
                case 3:
                    result = a * b;
                    calculation = a + " * " + b;
                    break;
                case 4:
                    result = a / b;
                    calculation = a + " / " + b;
                    break;
                default:
                    result = 0;
            }
            display.setText("" + result);

            calculations.put(calculation, String.valueOf(result));
            System.out.println(calculations);
            recentCalculationsTextArea.selectAll();
            recentCalculationsTextArea.replaceSelection("");
            calculations.forEach((k, v) -> {
                recentCalculationsTextArea.append(k + " = " + v + "\n");
            });


        }
        if (e.getSource() == keyClear)
            display.setText("");
    }
}
