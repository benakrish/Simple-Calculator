// Created by Ben Akrish (business inquiries: benakrish0@gmail.com)
// The class CalculatorMain is responsible for launching the calculator
// and handling user input.

package mainFiles;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import display.CalculatorDisplay;

public class CalculatorMain {

	// Post: Creates a visual calculator that can be interacted with by
	// 	     clicking.
	public static void main(String[] args) {
		CalculatorDisplay display = new CalculatorDisplay();
		CalculatorManager manager = new CalculatorManager();
		makeClickable(display, manager);
	}
	// Pre: The CalculatorDisplay "display" and the CalculatorManager "manager"
	// 		objects must be created prior to this method call, and the display
	// 		needs to initialize all of its contents before they can be made
	// 		interactive.
	// Post: Makes the visual calculator GUI interactive with the mouse.
	private static void makeClickable(CalculatorDisplay display, 
										   CalculatorManager manager) {
		JLabel[] integers = display.getIntLabels();
		JLabel[] functions = display.getFunctionLabels();
		for (int i = 0; i < integers.length; i++) {
			final int iFinal = i;
			integers[i].addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					display.setOutputText(manager.numPressed(iFinal));
				}
				
			});
		}
		functions[0].addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				display.setOutputText(manager.doClear());
			}
		});
		functions[1].addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				display.setOutputText(manager.doNegative());
			}
		});
		functions[2].addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				display.setOutputText(manager.doRoot());
			}
		});
		functions[3].addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				display.setOutputText(manager.doDivide());
			}
		});
		functions[4].addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				display.setOutputText(manager.doMultiply());
			}
		});
		functions[5].addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				display.setOutputText(manager.doSubtract());
			}
		});
		functions[6].addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				display.setOutputText(manager.doAdd());
			}
		});
		functions[7].addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				display.setOutputText(manager.doEquals());
			}
		});
		functions[8].addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				display.setOutputText(manager.doDecimal());
			}
		});
	}

}
