package ie.atu.bookapp;

import java.util.ArrayList;
import java.util.Scanner;

public class BookManager {
    // Because the size of the arrays are not known at the start of the program, they should be getting resized dynamically.
    // ArrayList is perfect for that. It makes the CRUD operations on arrays much easier.
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Book> books;
    private ArrayList <BookPrinted> booksPrinted;
    private ArrayList<Ebook> ebooks;
    private ArrayList <Audiobook> audiobooks;

    // TODO: Getters and setters
    public void printMenu() {
        App.setCurrentPage("manager");
        App.setPreviousPage("main");

        ClearConsole.clearConsole();

        System.out.println();
        System.out.println("============ Book Manager ============");
        System.out.println("1. Add a Book");
        System.out.println("2. Remove a Book");
        System.out.println("3. Find a Book");
        System.out.println("4. Show Books");
        System.out.println("---------------------------------------------");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch(choice) {
            // TODO: All choices for this menu
            case 1: {
                App.setCurrentPage("addBook");
                App.setPreviousPage("manager");

                this.printAddBookMenu();
            }
        }

        scanner.close();
    }

    public void printAddBookMenu() {
        ClearConsole.clearConsole();

        System.out.println("What do you want to add?");
        System.out.println("1. Printed Book");
        System.out.println("2. Ebook");
        System.out.println("3. Audiobook");
        System.out.println("---------------------------------------------");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch(choice) {
            // TODO: All choices for this menu
            case 1:
            {
                App.setCurrentPage("printedBook");
                App.setPreviousPage("addBook");

                this.printPrintedBookMenu();
            }
        }
    }

    public void printPrintedBookMenu() {
        ClearConsole.clearConsole();

        // TODO: Further menus and functionality
    }
}
