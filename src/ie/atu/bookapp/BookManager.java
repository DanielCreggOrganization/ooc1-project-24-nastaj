package ie.atu.bookapp;

import java.util.ArrayList;
import java.util.Scanner;

public class BookManager {
    // Because the size of the arrays are not known at the start of the program, they should be getting resized dynamically.
    // ArrayList is perfect for that. It makes the CRUD operations on arrays much easier.
    private static Scanner scanner = new Scanner(System.in);
    private ArrayList<Book> books;
    private static ArrayList <BookPrinted> booksPrinted;
    private ArrayList<Ebook> ebooks;
    private ArrayList <Audiobook> audiobooks;

    BookManager() {
        BookManager.booksPrinted = new ArrayList<>();
    }

    // TODO: Getters and setters
    public static void printMenu() {
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

        int choice = BookManager.scanner.nextInt();
        scanner.nextLine();

        switch(choice) {
            // TODO: All choices for this menu
            case 1: {
                App.setCurrentPage("addBook");
                App.setPreviousPage("manager");

                BookManager.printAddBookMenu();
            }
        }

        scanner.close();
    }

    public static void printAddBookMenu() {
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

                BookManager.printPrintedBookMenu();
            }
        }
    }

    public static void printPrintedBookMenu() {
        String title;
        String author;
        double price;
        int publicationYear;
        int pageCount;
        String choice;

        ClearConsole.clearConsole();

        System.out.println("Enter details");
        System.out.println("=================");

        System.out.print("Title: ");
        title = scanner.nextLine();

        System.out.print("Author: ");
        author = scanner.nextLine();

        System.out.print("Price: ");
        price = scanner.nextDouble();

        System.out.print("Publication Year: ");
        publicationYear = scanner.nextInt();

        System.out.print("Page Count: ");
        pageCount = scanner.nextInt();

        System.out.println("==============");
        System.out.println("Is this correct?");
        System.out.println("--------------");
        System.out.print("Y / N: ");
        choice = scanner.next();

        if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")) {
            BookPrinted bookPrinted = new BookPrinted(title, author, price, publicationYear, pageCount);
            BookManager.booksPrinted.add(bookPrinted);

            System.out.println("Book added successfully!");
            System.out.println("Add another book?");

            System.out.println("--------------");
            System.out.print("Y / N: ");
            choice = scanner.next();

            if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")) {
                // Prompt the user again
                BookManager.printPrintedBookMenu();
            }
            
            else if (choice.equalsIgnoreCase("n") || choice.equalsIgnoreCase("no")) {
                Navigation.moveTo(App.getPreviousPage());
            }

        }
        else if (choice.equalsIgnoreCase("n") || choice.equalsIgnoreCase("no")) {
            // Prompt the user again
            BookManager.printPrintedBookMenu();
        }
        

        // TODO: Further menus and functionality
    }
}
