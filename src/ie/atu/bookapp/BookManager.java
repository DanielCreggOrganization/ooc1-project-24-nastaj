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

    BookManager() {
        this.booksPrinted = new ArrayList<>();
    }

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
        String title;
        String author;
        double price;
        int publicationYear;
        int pageCount;
        String choice;

        ClearConsole.clearConsole();

        // Move the prompting menu into separate method 
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
            this.booksPrinted.add(bookPrinted);

            System.out.println("Book added successfully!");
            System.out.println("Add another book?");

            System.out.println("--------------");
            System.out.print("Y / N: ");
            choice = scanner.next();

            if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")) {
                // Prompt the user again
                this.printAddBookMenu();
            }
            
            else if (choice.equalsIgnoreCase("n") || choice.equalsIgnoreCase("no")) {
                // TODO: Navigate the user back to Book Manager menu
            }

        }
        else if (choice.equalsIgnoreCase("n") || choice.equalsIgnoreCase("no")) {
            // Prompt the user again
            this.printAddBookMenu();
        }
        

        // TODO: Further menus and functionality
    }
}
