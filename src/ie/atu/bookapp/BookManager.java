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
        Navigation.setCurrentPage("manager");
        Navigation.setPreviousPage("main");

        ClearConsole.clearConsole();

        System.out.println();
        System.out.println("============ Book Manager ============");
        System.out.println("(1) Add a Book");
        System.out.println("(2) Remove a Book");
        System.out.println("(3) Find a Book");
        System.out.println("(4) Show Books");
        Navigation.sideMenu();

        System.out.print("Enter your choice: ");

        String choice = BookManager.scanner.nextLine();

        Navigation.sideMenu(choice);
        
        switch(choice) {
            // TODO: All choices for this menu
            case "1": {
                BookManager.printAddBookMenu();
            }
        }
    }

    public static void printAddBookMenu() {
        Navigation.setCurrentPage("addBook");
        Navigation.setPreviousPage("manager");
        ClearConsole.clearConsole();

        System.out.println("What do you want to add?");
        System.out.println("1. Printed Book");
        System.out.println("2. Ebook");
        System.out.println("3. Audiobook");
        Navigation.sideMenu();

        System.out.print("Enter your choice: ");

        String choice = scanner.nextLine();

        Navigation.sideMenu(choice);

        switch(choice) {
            // TODO: All choices for this menu
            case "1":
            {
                Navigation.setCurrentPage("printedBook");
                Navigation.setPreviousPage("addBook");

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

        title = BookManager.promptTitle();
        author = BookManager.promptAuthor();
        price = BookManager.promptPrice();
        
                System.out.print("Publication Year: ");
                publicationYear = scanner.nextInt();
                scanner.nextLine(); // Consume the leftover newline
        
                System.out.print("Page Count: ");
                pageCount = scanner.nextInt();
                scanner.nextLine(); // Consume the leftover newline
        
                System.out.println("==============");
                System.out.println("Is this correct?");
                System.out.println("--------------");
                System.out.print("Y / N: ");
                choice = scanner.nextLine();
        
                if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")) {
                    BookPrinted bookPrinted = new BookPrinted(title, author, price, publicationYear, pageCount);
                    BookManager.booksPrinted.add(bookPrinted);
        
                    ClearConsole.clearConsole();
        
                    System.out.println(booksPrinted);
                    System.out.println("Book added successfully!");
                    System.out.println("Add another book?");
        
                    System.out.println("--------------");
                    System.out.print("Y / N: ");
                    choice = scanner.nextLine();
        
                    if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")) {
                        // Prompt the user again
                        BookManager.printPrintedBookMenu();
                    }
                    
                    else if (choice.equalsIgnoreCase("n") || choice.equalsIgnoreCase("no")) {
                        Navigation.moveTo(Navigation.getPreviousPage());
                    }
        
                }
                else if (choice.equalsIgnoreCase("n") || choice.equalsIgnoreCase("no")) {
                    // Prompt the user again
                    BookManager.printPrintedBookMenu();
                }
                
                // TODO: Further menus and functionality
    }
        
    public static String promptTitle() {
        String title;

        do {
            System.out.print("Title: ");
            title = scanner.nextLine();

            if (title.trim().isEmpty()) {
                System.out.println("Invalid input! Title cannot be empty.");
            }
        } while (title.trim().isEmpty());
            
        return title;
    }

    public static String promptAuthor() {
        String author;

        do {
            System.out.print("Author: ");
            author = scanner.nextLine();

            if (author.trim().isEmpty()) {
                System.out.println("Invalid input! Author cannot be empty.");
            }
            else if (!author.matches(".*[a-zA-Z]+.*")) {
                System.out.println("Invalid input! Author must contain letters.");
            }
        } while (author.trim().isEmpty() || !author.matches(".*[a-zA-Z]+.*"));
            
        return author;
    }

    public static double promptPrice() {
        double price;
    
        while (true) {
            System.out.print("Price: ");
    
            String input = scanner.nextLine(); // Read the input as a string first
    
            if (input.isEmpty()) { // Check if the input is empty
                System.out.println("Invalid input! Price cannot be empty.");
                continue; // Restart the loop
            }
    
            try {
                price = Double.parseDouble(input); // Attempt to parse the input as a double
                if (price >= 0) {
                    return price; // Valid non-negative price
                } else {
                    System.out.println("Invalid input! Price cannot be negative.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid price.");
            }
        }
    }
}
