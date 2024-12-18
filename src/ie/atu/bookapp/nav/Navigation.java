package ie.atu.bookapp.nav;

import ie.atu.bookapp.App;
import ie.atu.bookapp.features.Display;
import ie.atu.bookapp.features.Manager;
import ie.atu.bookapp.features.Statistics;
import ie.atu.bookapp.utilities.ClearConsole;

public class Navigation {
    // Store the previous and current page names for navigation purposes
    private static String previousPage;
    private static String currentPage;

    /**
     * Navigates to the specified page and displays its relevant content.
     * 
     * @param page The name of the page to navigate to.
     */
    public static void moveTo(String page) {
        // Clears the console before displaying the new page
        ClearConsole.clearConsole();

        // Navigating to different pages based on the provided page name
        if(page.equals("manager")) {
            Manager.printMenu(); // Display the manager menu
        }

        if(page.equals("addBook")) {
            Menu.printAddBookMenu(); // Display the add book menu
        }

        if(page.equals("main")) {
            App.printMainMenu(); // Display the main menu of the app
        }

        if(page.equals("removeBook")) {
            Menu.printRemoveBookMenu(); // Display the remove book menu
        }

        if (page.equals("findBook")) {
            Menu.printFindBookMenu(); // Display the find book menu
        }

        if (page.equals("showBooks")) {
            Menu.printShowBooksMenu(); // Display the show books menu
        }

        if (page.equals("stats")) {
            Statistics.printMenu(); // Display the statistics menu
        }

        if (page.equals("resultsPrinted")) {
            Display.showBooks("printed"); // Display results for printed books
        }

        if (page.equals("ebooks")) {
            Display.showBooks("ebooks"); // Display results for ebooks
        }

        if (page.equals("audiobooks")) {
            Display.showBooks("audiobooks"); // Display results for audiobooks
        }

        if (page.equals("all")) {
            Display.showBooks("all"); // Display all books
        }
    }

    /**
     * Displays the side menu with options to go back or return to the main menu.
     */
    public static void sideMenu() {
        System.out.println("---------------------------------------------");
        System.out.println("(B) Go Back | (M) Go to Main Menu");
        System.out.println("---------------------------------------------");
    }

    /**
     * Processes the user's choice in the side menu and navigates accordingly.
     * 
     * @param choice The user's choice to navigate either back or to the main menu.
     */
    public static void sideMenu(String choice) {
        // Clears the console before making the navigation
        ClearConsole.clearConsole();

        // Go back to the previous page if 'b' is selected
        if(choice.equals("b")) {
            Navigation.moveTo(Navigation.previousPage);
        }

        // Go to the main menu if 'm' is selected
        if(choice.equalsIgnoreCase("m")) {
            App.printMainMenu();
        }
    }

    /**
     * Handles the user's choice in navigating between pages.
     * 
     * @return The user's choice from the side menu.
     */
    public static String handleChoice() {
        System.out.print("Enter your choice: ");
        String choice = App.scanner.nextLine(); // Get user input for the choice
        Navigation.sideMenu(choice); // Handle the navigation based on choice
        return choice; // Return the user's choice
    }

    /**
     * Sets the current page.
     * 
     * @param page The page name to set as the current page.
     */
    public static void setCurrentPage(String page) {
        Navigation.currentPage = page;
    }

    /**
     * Gets the current page.
     * 
     * @return The name of the current page.
     */
    public static String getCurrentPage() {
        return Navigation.currentPage;
    }

    /**
     * Sets the previous page.
     * 
     * @param page The page name to set as the previous page.
     */
    public static void setPreviousPage(String page) {
        Navigation.previousPage = page;
    }

    /**
     * Gets the previous page.
     * 
     * @return The name of the previous page.
     */
    public static String getPreviousPage() {
        return Navigation.previousPage;
    }
}
