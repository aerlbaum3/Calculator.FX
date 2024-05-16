package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CalculatorController {
	
	@FXML
	private Label display;
	
	public double startNumber = 0;
	public String operator = "";
	public boolean newCalc = true; //flag to indicate the start of a new calc.
	
	//method to handle the user clicks
	
	@FXML
	public void clickOnNumbers(ActionEvent event) {
		//if start of new calc want to clear the display
		if(newCalc) {
			display.setText("");
			newCalc = false;
		}
		
		//when click number place it on the display
		String value = ((Button) event.getSource()).getText();
		display.setText(display.getText() + value);
	}
	@FXML 
	public void clickOnOperator(ActionEvent event) {
		if(!operator.isEmpty()) {
			return;
		}
		
		//get operator that user clicked
		
		operator = ((Button) event.getSource()).getText();
		
		//store the display number as the firstNumber of the calculation
		
		startNumber = Double.parseDouble(display.getText());
		
	}
	@FXML
	public void clickOnEqualsOperator() {
		//get the next number from the display
		
		double nextNumber = Double.parseDouble(display.getText());
		double result = 0;
		
		switch(operator) {
			case "+":
				result = startNumber + nextNumber;
				break;
			case "*":
				result = startNumber * nextNumber;
				break;
			case "-":
				result = startNumber - nextNumber;
				break;
			case "/":
				if(nextNumber == 0) {
					display.setText("Error");
					return;
				}
					else {
						result = startNumber / nextNumber;
						
					}
				break;
				
				}
		//display the result
		display.setText(String.valueOf(result));
		operator = ""; //reset operator
		newCalc = true; //reset flag
		}
	@FXML
	public void clickOnClearOperator() {
		display.setText("");
		operator = "";
		newCalc = true;
		startNumber = 0;
	}
	
}
