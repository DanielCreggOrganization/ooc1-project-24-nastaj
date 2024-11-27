package ie.atu.bookapp;

// Scanner for user input
import java.util.Scanner;

// App class responsible for starting up the Booklet app. Prints out the main menu.
public class App {
    // Scanner variable is used for user input. 
    // Running bolean variable is used for determining if the app is active (true) or paused (false).
    private static Scanner scanner = new Scanner(System.in);
    private static boolean running = true;
    private BookManager bookManager;

    App() {
        this.bookManager = new BookManager();
    }

    // Run function is responsible for starting up the app and printing the main menu for the first time the app is launched.
    // Does not return anything and is used only once in the Main class.
    public void run() {
        while (running) {
            App.printMainMenu();
        }
    }

    public static void printMainMenu() {
        Navigation.setCurrentPage("main");
            // I have put the ASCII art in the main menu in its own class to abstract it away and not clutter the code responsible for running the app.
            ASCII.printArt();

            System.out.println();

            System.out.println("===============================================");
            System.out.println("========== Library Management System ==========");
            System.out.println("============ Author: Jakub Nasta ==============");
            System.out.println("===============================================");
            System.out.println();

            System.out.println("How may I help you today?");
            System.out.println();

            System.out.println("1. Manage Books");
            System.out.println("2. View Statistics");
            System.out.println("0. Exit");
            System.out.println("---------------------------------------------");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 1: {
                    BookManager.printMenu();
                    running = false;
                    break;
                }
                case 2: {
                    System.out.println("TODO: Statistics Panel");
                    running = false;
                    break;
                }
                case 0: {
                    System.out.println("Exiting the application...");
                    running = false;
                    break;
                }
                default: {
                    System.out.println("Invalid option. Please try again.");
                    running = false;
                }
            }
    }
}
