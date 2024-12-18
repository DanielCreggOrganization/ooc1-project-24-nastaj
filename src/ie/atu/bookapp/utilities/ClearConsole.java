package ie.atu.bookapp.utilities;

public class ClearConsole {
    
    /**
     * Clears the console screen using an ANSI escape code.
     * 
     * This method sends an escape code to the terminal to clear the screen and 
     * reset the cursor position to the top-left corner.
     * This approach works in most terminal environments that support ANSI escape codes.
     */
    public static void clearConsole() {
        // ANSI escape code to clear the screen and move the cursor to the top-left corner
        System.out.print("\033[H\033[2J"); // \033[H moves the cursor to the home position, \033[2J clears the screen
        System.out.flush(); // Ensures that the output is immediately displayed
    }
}
