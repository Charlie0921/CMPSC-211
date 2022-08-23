/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pizzaservingscalculator;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ButtonFrame extends JFrame{
    private final JLabel labelTitle;
    private final JPanel line2;
    private final JLabel labelAsk;
    private final JTextField input;
    private final JButton calculateButton;
    private final JLabel labelResult;
    
    public ButtonFrame()
    {
        super("Pizza Servings Calculator");
        setLayout(new GridLayout(4,1));
        
        labelTitle = new JLabel("Pizza Servings Calculator",SwingConstants.CENTER);
        labelTitle.setFont(new Font("Times new roman", Font.BOLD,20));
        labelTitle.setForeground(Color.red);
        add(labelTitle);
        
        line2 = new JPanel();
        labelAsk = new JLabel("Enter the size of the pizza in inches: ",SwingConstants.RIGHT);
        labelAsk.setFont(new Font("Arial",Font.BOLD,10));
        input = new JTextField("",4);
        line2.add(labelAsk);
        line2.add(input);
        add(line2);
        
        calculateButton = new JButton("Calculate Servings");
        add(calculateButton);
        ButtonHandler handler = new ButtonHandler();
        calculateButton.addActionListener(handler);
        
        labelResult = new JLabel("", SwingConstants.CENTER);
        add(labelResult);
    }
    
    private class ButtonHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            double size = Double.parseDouble(input.getText());
            double servings = Math.pow(size/8,2);
            labelResult.setText(String.format("A %.0f inch pizza will serve %.2f people.",size,servings));
            add(labelResult);
        }
    }
    
}
