package ie.atu.bookapp;

import java.util.Scanner; // Import Scanner for user input

import ie.atu.bookapp.features.Manager;
import ie.atu.bookapp.features.Statistics;
import ie.atu.bookapp.nav.Navigation;
import ie.atu.bookapp.utilities.ASCII;

/**
 * The App class is responsible for starting and managing the main flow of the Booklet application.
 * It initializes the Manager, populates the book data, and handles the main menu interactions.
 */
public class App {

    // Scanner for user input
    public static Scanner scanner = new Scanner(System.in);

    // Boolean variable to determine if the app is active (true) or should stop (false)
    private static boolean running = true;

    /**
     * Constructor for the App class.
     * It initializes the Manager and populates the list of books.
     */
    public App() {
        new Manager();         // Initialize the Manager
        Manager.populateBooks(); // Populate the initial book data
    }

    /**
     * Starts the application and continuously displays the main menu
     * until the user decides to exit.
     */
    public void run() {
        while (running) {
            printMainMenu(); // Continuously show the main menu
        }
    }

    /**
     * Displays the main menu and handles user input to navigate to different features.
     */
    public static void printMainMenu() {
        Navigation.setCurrentPage("main");

        // Display ASCII art for branding
        ASCII.printArt();

        // Main menu header
        System.out.println();
        System.out.println("===============================================");
        System.out.println("========== Library Management System ==========");
        System.out.println("============ Author: Jakub Nasta ==============");
        System.out.println("===============================================");
        System.out.println();

        // Menu options
        System.out.println("How may I help you today?");
        System.out.println();
        System.out.println("(1) Manage Books");
        System.out.println("(2) View Statistics");
        System.out.println("(3) Exit");
        System.out.println("---------------------------------------------");
        System.out.print("Enter your choice: ");

        // Read user input and handle menu selection
        String choice = scanner.nextLine();

        switch (choice) {
            case "1": {
                Manager.printMenu(); // Navigate to book management
                break;
            }
            case "2": {
                Statistics.printMenu(); // Navigate to statistics menu
                break;
            }
            case "3": {
                System.out.println("Exiting the application...");
                running = false; // Set running to false to exit the loop
                break; // Exit the switch case
            }
            default: {
                System.out.println("Invalid option. Please try again.");
            }
        }

        // Ensure that after exiting, the loop is properly checked
        if (!running) {
            System.out.println("Goodbye!");
            System.exit(0);
        }
    }
}
