package ie.atu.bookapp;

public class Navigation {
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
}
