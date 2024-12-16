package ie.atu.bookapp;

public class Navigation {
    private static String previousPage;
    private static String currentPage;

    public static void moveTo(String page) {
        ClearConsole.clearConsole();

        if(page.equals("manager")) {
            BookManager.printMenu();
        }

        if(page.equals("addBook")) {
            BookManager.printAddBookMenu();
        }

        if(page.equals("main")) {
            App.printMainMenu();
        }

        if(page.equals("removeBook")) {
            BookManager.printRemoveBookMenu();
        }

        if (page.equals("findBook")) {
            BookManager.printFindBookMenu();
        }

        if (page.equals("showBooks")) {
            BookManager.printShowBooksMenu();
        }

        if (page.equals("stats")) {
            Statistics.printMenu();
        }
    }

    public static void sideMenu() {
        System.out.println("---------------------------------------------");
        System.out.println("(B) Go Back | (M) Go to Main Menu");
        System.out.println("---------------------------------------------");
    }

    public static void sideMenu(String choice) {
        ClearConsole.clearConsole();

        if(choice.equals("b") ) {
            Navigation.moveTo(Navigation.previousPage);
        }

        if(choice.equalsIgnoreCase("m")) {
            App.printMainMenu();
        }
    }

    public static String handleChoice() {
        System.out.print("Enter your choice: ");
        String choice = App.scanner.nextLine();
        Navigation.sideMenu(choice);
        return choice;
    }

    public static void setCurrentPage(String page) {
        Navigation.currentPage = page;
    }

    public static String getCurrentPage() {
        return Navigation.currentPage;
    }

    public static void setPreviousPage(String page) {
        Navigation.previousPage = page;
    }

    public static String getPreviousPage() {
        return Navigation.previousPage;
    }
}
