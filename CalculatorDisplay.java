// Created by Ben Akrish (business inquiries: benakrish0@gmail.com)
// The CalculatorDisplay class represents a window that holds the visual elements
// of my simple calculator program.

package display;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.Color;

public class CalculatorDisplay extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JLabel calcDisplay;
	private JLabel[] integers;
	private JLabel[] functions; // "functions" is an array corresponding to
								// JLabel functions in the following order:
								// C, ±, √, ÷, *, -, +, =, .

	public CalculatorDisplay() {
		this.setTitle("Calculator by Ben Akrish");
		this.setVisible(true);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // This ensures that the window 
															 // closes properly upon exit.
		ImageIcon windowIcon = new ImageIcon("resources/windowIcon16.png");
		this.setIconImage(windowIcon.getImage()); // Must "get" the image stored within the
												  // windowIcon object
		this.setSize(480, 660);
		this.setMinimumSize(new Dimension(240, 330));
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setPreferredSize(this.getSize());
		this.add(panel);
		makeIntegers();
		makeCalcDisplay();
		makeFunctions();
	}
	
	private void makeIntegers() {
		integers = new JLabel[10];
		Border blackline = BorderFactory.createLineBorder(Color.BLACK);
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.weighty = 1;
		for (int i = 9; i >= 0; i--) {
			integers[i] = new JLabel(i + "");
			c.gridx = 2 - ((9 - i) % 3);
			c.gridy = (9 - i) / 3 + 2;
			if (i == 0) {
				c.gridwidth = 2;
				c.gridx = 0;
			}
			panel.add(integers[i], c);
			integers[i].setBorder(blackline);
			integers[i].setBackground(Color.decode("#545454"));
			integers[i].setForeground(Color.WHITE);
			integers[i].setHorizontalAlignment(SwingConstants.CENTER);
			integers[i].setVerticalAlignment(SwingConstants.CENTER);
			integers[i].setOpaque(true);
			integers[i].setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 32));
		}
	}
	
	private void makeCalcDisplay() {
		calcDisplay = new JLabel("0");
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weighty = 0.5;
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 4;
		panel.add(calcDisplay, c);	
		calcDisplay.setBackground(Color.BLACK);
		calcDisplay.setForeground(Color.WHITE);
		calcDisplay.setFont(new Font("Monospaced", Font.BOLD, 24));
		calcDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
		calcDisplay.setVerticalAlignment(SwingConstants.CENTER);
		calcDisplay.setOpaque(true);	
	}
	
	private void makeFunctions() {
		functions = new JLabel[9];
		String[] functionOrder = {"C", "±", "√", "÷", "x", "-", "+", "=", "."};
		for (int i = 0; i < functions.length; i++) {
			functions[i] = new JLabel(functionOrder[i] + "");
		}
		Border blackline = BorderFactory.createLineBorder(Color.BLACK);
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.weighty = 1;
		c.gridy = 1;
		for (int i = 0; i < 4; i++) {
			c.gridx = i;
			panel.add(functions[i], c);	
			functions[i].setBackground(Color.decode("#854a22"));
			functions[i].setForeground(Color.WHITE);
			functions[i].setHorizontalAlignment(SwingConstants.CENTER);
			functions[i].setVerticalAlignment(SwingConstants.CENTER);
			functions[i].setOpaque(true);
			functions[i].setBorder(blackline);
			functions[i].setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 32));
		}
		functions[2].setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 32));
		c.gridx = 3;
		for (int i = 4; i < functions.length; i++) {
			c.gridy = i - 2;
			if (i == functions.length - 1) {
				c.gridy = 5;
				c.gridx = 2;
			}
			panel.add(functions[i], c);	
			functions[i].setBackground(Color.decode("#854a22"));
			functions[i].setForeground(Color.WHITE);
			functions[i].setHorizontalAlignment(SwingConstants.CENTER);
			functions[i].setVerticalAlignment(SwingConstants.CENTER);
			functions[i].setOpaque(true);
			functions[i].setBorder(blackline);
			functions[i].setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 32));			
		}
	}
	
	public JLabel[] getIntLabels() {
		return integers;
	}
	
	public JLabel[] getFunctionLabels() {
		return functions;
	}
	
	public void setOutputText(String text) {
		calcDisplay.setText(text);
	}
}
