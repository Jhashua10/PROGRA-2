
package com.mycompany.calculadora1;
import javax.swing.JOptionPane;

public class Calculadora1 {
    private static double addition(double num1, double num2) {
        return num1 + num2;
    }

    private static double subtraction(double num1, double num2) {
        return num1 - num2;
    }

    
    private static double multiplication(double num1, double num2) {
        return num1 * num2;
    }

    
    private static double division(double num1, double num2) {
        return num1 / num2;
    }

    
    private static double parseInput(String input) {
        double number = 0;
        try {
            number = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.", "Error",
                    JOptionPane.ERROR_MESSAGE);
           
            String newInput = JOptionPane.showInputDialog("Enter the number again:");
            number = parseInput(newInput);
        }
        return number;
    }

    
    
   
    public static void main(String[] args) {
        while (true) {
            
            String input1 = JOptionPane.showInputDialog("Enter the first number:");
            double num1 = parseInput(input1);
            String input2 = JOptionPane.showInputDialog("Enter the second number:");
            double num2 = parseInput(input2);

            
            Object[] operations = {"Addition", "Subtraction", "Multiplication", "Division", "Exit"};
            int option = JOptionPane.showOptionDialog(null, "Select the operation to perform:", "Calculator",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, operations, operations[0]);

            if (option == 4) {
                JOptionPane.showMessageDialog(null, "Goodbye!", "Exit",
                        JOptionPane.INFORMATION_MESSAGE);
                break; 
            }

            
            double result = 0;
            String operation = "";

            switch (option) {
                case 0 -> {
                    result = addition(num1, num2);
                    operation = "Addition";
                }
                case 1 -> {
                    result = subtraction(num1, num2);
                    operation = "Subtraction";
                }
                case 2 -> {
                    result = multiplication(num1, num2);
                    operation = "Multiplication";
                }
                case 3 -> {
                    if (num2 != 0) {
                        result = division(num1, num2);
                        operation = "Division";
                    } else {
                        JOptionPane.showMessageDialog(null, "Cannot divide by zero.", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        continue; 
                    }
                }
                default -> {
                    JOptionPane.showMessageDialog(null, "Invalid option", "Error", JOptionPane.ERROR_MESSAGE);
                    continue; 
                }
            }

            
            JOptionPane.showMessageDialog(null, "The result of the " + operation + " is: " + result, "Result",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
   
}