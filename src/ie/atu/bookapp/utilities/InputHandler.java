package ie.atu.bookapp.utilities;

import java.util.Scanner;

public class InputHandler {
    // Create a scanner instance to read input from the user
    private static Scanner scanner = new Scanner(System.in);
    
    /**
     * Prompts the user for a non-empty string input.
     * 
     * @param field The field name that will be displayed in the prompt.
     * @return The user's input as a non-empty string.
     */
    public static String promptString(String field) {
        String string;
        String output = field + ": "; // Prompt message to be displayed

        // Loop until the user enters a valid (non-empty) string
        do {
            System.out.print(output);
            string = scanner.nextLine();

            // Check if the input is empty or contains only spaces
            if (string.trim().isEmpty()) {
                System.out.println("Invalid input! Value cannot be empty.");
            }
        } while (string.trim().isEmpty()); // Continue looping until input is valid
            
        return string; // Return the valid input string
    }

    /**
     * Prompts the user for a valid non-negative double value.
     * 
     * @param field The field name that will be displayed in the prompt.
     * @return The user's input as a valid double.
     */
    public static double promptDouble(String field) {
        double value;
        String output = field + ": "; // Prompt message to be displayed
    
        // Loop until the user enters a valid double
        while (true) {
            System.out.print(output);
            String input = scanner.nextLine(); // Read input as a string first
    
            // Check if the input is empty
            if (input.isEmpty()) {
                System.out.println("Invalid input! Value cannot be empty.");
                continue; // Restart the loop if input is empty
            }
    
            try {
                value = Double.parseDouble(input); // Attempt to parse the input as a double
                if (value >= 0) {
                    return value; // Return the valid non-negative value
                } else {
                    System.out.println("Invalid input! Value cannot be negative.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid value.");
            }
        }
    }

    /**
     * Prompts the user for a valid non-negative integer value.
     * 
     * @param field The field name that will be displayed in the prompt.
     * @return The user's input as a valid integer.
     */
    public static int promptInt(String field) {
        int value;
        String output = field + ": "; // Prompt message to be displayed
    
        // Loop until the user enters a valid integer
        while (true) {
            System.out.print(output);
            String input = scanner.nextLine(); // Read input as a string first
    
            // Check if the input is empty
            if (input.isEmpty()) {
                System.out.println("Invalid input! Value cannot be empty.");
                continue; // Restart the loop if input is empty
            }
    
            try {
                value = Integer.parseInt(input); // Attempt to parse the input as an integer
                if (value >= 0) {
                    return value; // Return the valid non-negative value
                } else {
                    System.out.println("Invalid input! Value cannot be negative.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid value.");
            }
        }
    }
}
