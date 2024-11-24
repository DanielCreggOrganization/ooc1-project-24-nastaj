package ie.atu.bookapp;

public class ClearConsole {
    public static void clearConsole() {
        // ANSI escape code to clear the screen
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
