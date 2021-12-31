// Created by Ben Akrish (business inquiries: benakrish0@gmail.com)
// The CalculatorManager class does all of the "behind-the-scenes" work,
// manipulating data and performing calculations. It is also responsible
// for storing all relevant data.

package mainFiles;

public class CalculatorManager {

	private double numSaved;
	private double numDisplayed;
	private boolean errorStatus;
	private boolean resetNext;
	private String awaitingOperation;
	private boolean decimalMode;
	
	public CalculatorManager() {
		numDisplayed = 0.0;
		numSaved = 0.0;
		awaitingOperation = "";
		errorStatus = false;
		decimalMode = false;
	}
	
	public String numPressed(int num) {
		if (errorStatus) {
			return "ERROR";
		}
		if (resetNext) {
			resetNext = false;
			decimalMode = false;
			if (awaitingOperation != "") {
				numSaved = numDisplayed;
			}
			return (int) (numDisplayed = num) + "";
		}
		if (!decimalMode) {
			numDisplayed = numDisplayed * 10 + num;
			if (numDisplayed < 1000000000) {
				return (int) numDisplayed + "";	
			}
			return numDisplayed + "";
		}
		if ((int) numDisplayed != numDisplayed) {
			numDisplayed = Double.parseDouble(numDisplayed + "" + num);
		} else {
			numDisplayed = Double.parseDouble((int) numDisplayed + "." + num);
		}
		return numDisplayed + "";
	}

	public String doClear() {
		numSaved = 0.0;
		numDisplayed = 0.0;
		errorStatus = false;
		awaitingOperation = "";
		return "0";
	}

	public String doNegative() {
		if (errorStatus) {
			return "ERROR";
		}
		numDisplayed = -numDisplayed;
		if (decimalMode) {
			return numDisplayed + "";
		} else {
			if (numDisplayed < 1000000000 && (int) numDisplayed == numDisplayed) {
				return (int) numDisplayed + "";	
			}
			return numDisplayed + "";
		}
	}
	
	public String doRoot() {
		if (errorStatus || numDisplayed < 0) {
			errorStatus = true;
			return "ERROR";
		}
		numDisplayed = Math.sqrt(numDisplayed);
		if (numDisplayed == 0.0) {
			return "0";
		}
		return numDisplayed + "";
	}

	public String doDivide() {
		if (errorStatus) {
			return "ERROR";
		}
		if (awaitingOperation == "") {
			resetNext = true;
			awaitingOperation = "d";
			if ((int) numDisplayed != numDisplayed) {
				return numDisplayed + "";
			}
			return (int) numDisplayed + "";
		}
		String returnVal = doEquals(awaitingOperation);
		awaitingOperation = "d";
		return returnVal;
	}

	public String doMultiply() {
		if (errorStatus) {
			return "ERROR";
		}
		if (awaitingOperation == "") {
			resetNext = true;
			awaitingOperation = "m";
			if ((int) numDisplayed != numDisplayed) {
				return numDisplayed + "";
			}
			return (int) numDisplayed + "";
		}
		String returnVal = doEquals(awaitingOperation);
		awaitingOperation = "m";
		return returnVal;
	}

	public String doSubtract() {
		if (errorStatus) {
			return "ERROR";
		}
		if (awaitingOperation == "") {
			resetNext = true;
			awaitingOperation = "s";
			if ((int) numDisplayed != numDisplayed) {
				return numDisplayed + "";
			}
			return (int) numDisplayed + "";
		}
		String returnVal = doEquals(awaitingOperation);
		awaitingOperation = "s";
		return returnVal;
	}
	
	public String doAdd() {
		if (errorStatus) {
			return "ERROR";
		}
		if (awaitingOperation == "") {
			resetNext = true;
			awaitingOperation = "a";
			if ((int) numDisplayed != numDisplayed) {
				return numDisplayed + "";
			}
			return (int) numDisplayed + "";
		}
		String returnVal = doEquals(awaitingOperation);
		awaitingOperation = "a";
		return returnVal;
	}
	
	public String doEquals() {
		if (errorStatus) {
			return "ERROR";
		} 
		if (awaitingOperation != "" && !resetNext) {
			return doEquals(awaitingOperation);
		}
		awaitingOperation = "";
		resetNext = true;
		if (decimalMode) {
			return numDisplayed + "";
		}
		return (int) numDisplayed + "";		
	}
	
	public String doDecimal() {
		if (errorStatus) {
			errorStatus = true;
			return "ERROR";
		}
		if (resetNext) {
			resetNext = false;
			decimalMode = true;
			if (awaitingOperation != "") {
				numSaved = numDisplayed;
			}
			return (int) (numDisplayed = 0.0) + "";
		}
		if (!decimalMode) {
			decimalMode = true;
			return (int) numDisplayed + ".";
		}
		if ((int) numDisplayed == numDisplayed) {
			return (int) numDisplayed + ".";
		}
		return numDisplayed + ""; // needs work
	}
	
	private String doEquals(String operation) {
		resetNext = true;
		if (operation.equals("d")) {
			if (numDisplayed == 0.0) {
				errorStatus = true;
				return "ERROR";
			}
			numDisplayed = numSaved / numDisplayed;
			awaitingOperation = "";
		}
		if (operation.equals("m")) {
			numDisplayed = numSaved * numDisplayed;
			awaitingOperation = "";
		}
		if (operation.equals("s")) {
			numDisplayed = numSaved - numDisplayed;
			awaitingOperation = "";
		}
		if (operation.equals("a")) {
			numDisplayed = numSaved + numDisplayed;
			awaitingOperation = "";
		}
		if (numDisplayed < 1000000000 && (int) numDisplayed == numDisplayed) {
			return (int) numDisplayed + "";
		}
		return numDisplayed + "";
	}
}
