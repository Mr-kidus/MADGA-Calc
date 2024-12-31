package com.example.madgacalc.ui.calculator;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CalculatorViewModel extends ViewModel {

    private final MutableLiveData<String> currentInput = new MutableLiveData<>("");
    private final MutableLiveData<String> result = new MutableLiveData<>("");

    public LiveData<String> getCurrentInput() {
        return currentInput;
    }

    public LiveData<String> getResult() {
        return result;
    }

    // Append a value to the current input
    public void appendToInput(String value) {
        String currentText = currentInput.getValue();
        if (currentText != null) {
            currentInput.setValue(currentText + value);
        }
    }

    // Perform a calculation with the current operator
    public void performCalculation(String operator) {
        String currentText = currentInput.getValue();
        if (currentText != null && !currentText.isEmpty()) {
            // Add the operator to the current input (just an example, should handle more logic)
            currentInput.setValue(currentText + " " + operator + " ");
        }
    }

    // Perform a scientific function like sin, cos, or tan
    public void performScientificFunction(String function) {
        String currentText = currentInput.getValue();
        if (currentText != null && !currentText.isEmpty()) {
            // Example: Add a scientific function
            currentInput.setValue(function + "(" + currentText + ")");
        }
    }

    // Calculate the result of the current input
    public void calculateResult() {
        String currentText = currentInput.getValue();
        if (currentText != null && !currentText.isEmpty()) {
            try {
                // Here you'd need to parse and evaluate the mathematical expression
                // This is a placeholder, replace with actual calculation logic
                double calculationResult = evaluateExpression(currentText);
                result.setValue(String.valueOf(calculationResult));
                currentInput.setValue("");  // Clear input after calculation
            } catch (Exception e) {
                result.setValue("Error");
            }
        }
    }

    // Placeholder function for evaluating mathematical expressions
    private double evaluateExpression(String expression) {
        // You can use an external library for complex calculations or implement your own parser
        // For simplicity, returning a fixed value here.
        return 0.0;
    }

    // Clear the current input
    public void clearInput() {
        currentInput.setValue("");
    }

    // Remove the last character from the current input (backspace)
    public void backspaceInput() {
        String currentText = currentInput.getValue();
        if (currentText != null && !currentText.isEmpty()) {
            currentInput.setValue(currentText.substring(0, currentText.length() - 1));
        }
    }
}
