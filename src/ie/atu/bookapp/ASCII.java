package ie.atu.bookapp;

/**
 * The ASCII class is responsible for printing ASCII art to the console.
 * This art is used as part of the main menu display in the application.
 */
public class ASCII {

    /**
     * Prints the ASCII art for the main menu.
     * This art represents a stylized representation of the application title.
     */
    public static void printArt() {
        System.out.println("     ______             _    _      _   \n" + 
                           "     | ___ \\           | |  | |    | |  \n" + 
                           "     | |_/ / ___   ___ | | _| | ___| |_ \n" + 
                           "     | ___ \\/ _ \\ / _ \\| |/ / |/ _ \\ __|\n" + 
                           "     | |_/ / (_) | (_) |   <| |  __/ |_ \n" + 
                           "     \\____/ \\___/ \\___/|_|\\_\\_|\\___|\\__|");
    }
}
