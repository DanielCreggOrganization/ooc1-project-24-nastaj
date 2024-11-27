package ie.atu.bookapp;

public class Navigation {
    private static String previousPage;
    private static String currentPage;

    public static void moveTo(String page) {
        if(page.equals("manager")) {
            ClearConsole.clearConsole();

            BookManager.printMenu();
        }

        if(page.equals("addBook")) {
            ClearConsole.clearConsole();

            BookManager.printAddBookMenu();
        }
    }

    public static void sideMenu(String choice) {
        ClearConsole.clearConsole();

        if(choice.equals("-1") ) {
            Navigation.moveTo(Navigation.previousPage);
        }

        if(choice.equalsIgnoreCase("m")) {
            App.printMainMenu();
        }
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
