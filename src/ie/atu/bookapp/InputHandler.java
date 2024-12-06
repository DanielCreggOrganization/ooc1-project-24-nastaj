package ie.atu.bookapp;

import java.util.Scanner;

public class InputHandler {
    private static Scanner scanner = new Scanner(System.in);
    
    public static String promptString(String field) {
        String string;
        String output = field + ": ";

        do {
            System.out.print(output);
            string = scanner.nextLine();

            if (string.trim().isEmpty()) {
                System.out.println("Invalid input! Value cannot be empty.");
            }
        } while (string.trim().isEmpty());
            
        return string;
    }

    public static double promptDouble(String field) {
        double value;
        String output = field + ": ";
    
        while (true) {
            System.out.print(output);
            String input = scanner.nextLine(); // Read the input as a string first
    
            if (input.isEmpty()) { // Check if the input is empty
                System.out.println("Invalid input! Value cannot be empty.");
                continue; // Restart the loop
            }
    
            try {
                value = Double.parseDouble(input); // Attempt to parse the input as a double
                if (value >= 0) {
                    return value; // Valid non-negative value
                } else {
                    System.out.println("Invalid input! Value cannot be negative.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid value.");
            }
        }
    }

    public static int promptInt(String field) {
        int value;
        String output = field + ": ";
    
        while (true) {
            System.out.print(output);
            String input = scanner.nextLine(); // Read the input as a string first
    
            if (input.isEmpty()) { // Check if the input is empty
                System.out.println("Invalid input! Value cannot be empty.");
                continue; // Restart the loop
            }
    
            try {
                value = Integer.parseInt(input); // Attempt to parse the input as an integer
                if (value >= 0) {
                    return value; // Valid non-negative publication year
                } else {
                    System.out.println("Invalid input! Value cannot be negative.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid value.");
            }
        }
    }
}
