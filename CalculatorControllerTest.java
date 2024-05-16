package application;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class CalculatorControllerTest {
    
    private CalculatorController controller;
    private Label display;
  
    
    @Before
    public void setUp() {
    	display = new Label();
        controller.startNumber = 0;
        controller.operator = "";
        controller.newCalc = true;
    }
    
    @Test
    public void testAddition() {
        display.setText("5");
        Button addButton = new Button("+");
        addButton.fire();
        display.setText("7");
        controller.clickOnEqualsOperator();
        assertEquals("12.0", display.getText());
    }
    
    @Test
    public void testSubtraction() {
        display.setText("10");
        Button subtractButton = new Button("-");
        subtractButton.fire();
        display.setText("3");
        controller.clickOnEqualsOperator();
        assertEquals("7.0", display.getText());
    }
    
    @Test
    public void testMultiplication() {
        display.setText("4");
        Button multiplyButton = new Button("*");
        multiplyButton.fire();
        display.setText("6");
        controller.clickOnEqualsOperator();
        assertEquals("24.0", display.getText());
    }
    
    @Test
    public void testDivision() {
        display.setText("8");
        Button divideButton = new Button("/");
        divideButton.fire();
        display.setText("2");
        controller.clickOnEqualsOperator();
        assertEquals("4.0", display.getText());
    }
    
    @Test
    public void testDivisionByZero() {
        display.setText("8");
        Button divideButton = new Button("/");
        divideButton.fire();
        display.setText("0");
        controller.clickOnEqualsOperator();
        assertEquals("Error", display.getText());
    }
    
    @Test
    public void testClear() {
        display.setText("123");
        controller.clickOnClearOperator();
        assertEquals("", display.getText());
        assertEquals("", controller.operator);
        assertTrue(controller.newCalc);
        assertEquals(0, controller.startNumber, 0);
    }
    
    @Test
    public void testMultipleOperations() {
        display.setText("10");
        Button addButton = new Button("+");
        addButton.fire();
        display.setText("5");
        controller.clickOnEqualsOperator();
        assertEquals("15.0", display.getText());
        
        Button multiplyButton = new Button("*");
        multiplyButton.fire();
        display.setText("2");
        controller.clickOnEqualsOperator();
        assertEquals("30.0", display.getText());
    }
}

