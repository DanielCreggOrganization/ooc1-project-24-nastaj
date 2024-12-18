package ie.atu.bookapp.nav;

import ie.atu.bookapp.App;
import ie.atu.bookapp.classes.Audiobook;
import ie.atu.bookapp.classes.Book;
import ie.atu.bookapp.classes.Ebook;
import ie.atu.bookapp.classes.PrintedBook;
import ie.atu.bookapp.features.Add;
import ie.atu.bookapp.features.Display;
import ie.atu.bookapp.features.Find;
import ie.atu.bookapp.features.Manager;
import ie.atu.bookapp.features.Remove;
import ie.atu.bookapp.utilities.ClearConsole;

/**
 * The Menu class manages the display of various menus related to book operations, such as adding, updating, 
 * removing, and displaying books. It interacts with the user to make choices and execute actions.
 */
public class Menu {

    /**
     * Displays the menu for showing books, with options to view printed books, ebooks, audiobooks, or all books.
     */
    public static void printShowBooksMenu() {
        Navigation.setCurrentPage("showBooks");
        Navigation.setPreviousPage("manager");
        ClearConsole.clearConsole();

        System.out.println("Show Books");
        System.out.println("=================");
        System.out.println("What books do you want to show?");
        System.out.println("(1) Printed Books");
        System.out.println("(2) Ebooks");
        System.out.println("(3) Audiobooks");
        System.out.println("(4) Show All");
        Navigation.sideMenu();

        // Handle user's menu choice
        String choice = Navigation.handleChoice();

        switch(choice) {
            case "1": 
                Display.showBooks("printed");
                break;
            case "2": 
                Display.showBooks("ebooks");
                break;
            case "3": 
                Display.showBooks("audiobooks");
                break;
            case "4": 
                Display.showBooks("all");
                break;
            default:
                printShowBooksMenu(); // Invalid input, re-display the menu
        }
    }

    /**
     * Displays the menu for sorting books based on different criteria (title, author, price, etc.).
     * 
     * @param type The type of books to sort (printed, ebooks, audiobooks).
     * @param results The number of results to be sorted.
     */
    public static void printSortMenu(String type, int results) {
        Navigation.setCurrentPage("sortMenu");
        Navigation.setPreviousPage("showBooks");
        ClearConsole.clearConsole();

        System.out.println("Sort " + type + " books by:");
        System.out.println("(1) Title (A-Z)");
        System.out.println("(2) Title (Z-A)");
        System.out.println("(3) Author");
        System.out.println("(4) Genre");
        System.out.println("(5) Price (Ascending)");
        System.out.println("(6) Price (Descending)");

        // Additional sorting options based on the type of book
        if (type.equals("printed")) {
            System.out.println("(7) Page Count");
        } else if (type.equals("ebooks")) {
            System.out.println("(7) File Size");
        } else if (type.equals("audiobooks")) {
            System.out.println("(7) Duration");
        }
        
        System.out.println("(0) Default (No Sorting)");

        System.out.print("Enter your choice: ");

        // Read and handle sorting choice
        String sortBy = "";
        String choice = App.scanner.nextLine();
        switch(choice) {
            case "1": 
                sortBy = "titleasc";
                break;
            case "2": 
                sortBy = "titledesc";
                break;
            case "3": 
                sortBy = "author";
                break;
            case "4": 
                sortBy = "genre";
                break;
            case "5": 
                sortBy = "priceasc";
                break;
            case "6": 
                sortBy = "pricedesc";
                break;
            case "7":
                if (type.equals("printed")) sortBy = "pages";
                if (type.equals("ebooks")) sortBy = "filesize";
                if (type.equals("audiobooks")) sortBy = "duration";
                break;
            default: 
                sortBy = "default";
        }

        // Display the sorted books
        if (!type.equals("all")) {
            Display.displayBooks(type, sortBy, results);
        } else {
            Display.displayAllBooks(type, sortBy, results);
        }
    }

    /**
     * Displays the menu for adding a new book, with options for different types of books.
     */
    public static void printAddBookMenu() {
        Navigation.setCurrentPage("addBook");
        Navigation.setPreviousPage("manager");
        ClearConsole.clearConsole();

        System.out.println("Add Book");
        System.out.println("=================");
        System.out.println("What do you want to add?");
        System.out.println("(1) Printed Book");
        System.out.println("(2) Ebook");
        System.out.println("(3) Audiobook");
        Navigation.sideMenu();

        // Handle user's choice for adding a book
        String choice = Navigation.handleChoice();

        switch(choice) {
            case "1": 
                Add.book();
                break;
            case "2": 
                Add.ebook();
                break;
            case "3": 
                Add.audiobook();
                break;
            default:
                Menu.printAddBookMenu(); // Invalid input, re-display the menu
        }
    }

    /**
     * Displays the menu for updating an existing book, allowing the user to select a field to update.
     */
    public static void printUpdateBookMenu() {
        if (Navigation.getCurrentPage().equals("manager")) {
            Navigation.setPreviousPage("manager");
        }
        
        Navigation.setCurrentPage("updateBook");
        ClearConsole.clearConsole();

        if (Manager.getAllBooks().isEmpty()) {
            System.out.println("No books available.");
            Navigation.sideMenu();
            Navigation.handleChoice();
        }
        
        String bookId = "";
        // Loop until a valid book ID is entered
        while (true) {
            System.out.print("Enter Book ID: ");
            bookId = App.scanner.nextLine().trim();

            // Validate the input for book ID
            if (bookId.isEmpty()) {
                System.out.println("Book ID cannot be empty. Please try again.\n");
                continue; // Restart the loop
            }

            if (!bookId.matches("\\d+")) { // Checks if the input is numeric
                System.out.println("Invalid Book ID. Please enter numbers only.\n");
                continue; // Restart the loop
            } else {
                break;
            }
        }

        // Find the book by ID
        Book bookToUpdate = Find.findBookById(bookId);
        
        if (bookToUpdate == null) {
            System.out.println("Book with ID " + bookId + " not found.");
            return;
        }

        ClearConsole.clearConsole();
        System.out.println(bookToUpdate);
        System.out.println("Enter the field you want to update: ");
        System.out.println("(1) Title");
        System.out.println("(2) Author");
        System.out.println("(3) Genre");
        System.out.println("(4) Price");
    
        // Display additional fields for specific book types
        if (bookToUpdate instanceof PrintedBook) {
            System.out.println("(5) Page Count");
        } else if (bookToUpdate instanceof Ebook) {
            System.out.println("(5) File Size");
        } else if (bookToUpdate instanceof Audiobook) {
            System.out.println("(5) Duration");
        }
    
        System.out.println("------------------------------------");
        System.out.print("Enter your choice: ");
        String choice = App.scanner.nextLine();
    
        // Handle the update based on user's choice
        switch (choice) {
            case "1":
                System.out.print("Enter new title: ");
                String newTitle = App.scanner.nextLine();
                bookToUpdate.setTitle(newTitle);
                break;
            case "2":
                System.out.print("Enter new author: ");
                String newAuthor = App.scanner.nextLine();
                bookToUpdate.setAuthor(newAuthor);
                break;
            case "3":
                System.out.print("Enter new genre: ");
                String newGenre = App.scanner.nextLine();
                bookToUpdate.setGenre(newGenre);
                break;
            case "4":
                System.out.print("Enter new price: ");
                double newPrice = App.scanner.nextDouble();
                bookToUpdate.setPrice(newPrice);
                break;
            case "5":
                if (bookToUpdate instanceof PrintedBook) {
                    System.out.print("Enter new page count: ");
                    int newPageCount = App.scanner.nextInt();
                    ((PrintedBook) bookToUpdate).setPageCount(newPageCount);
                } else if (bookToUpdate instanceof Ebook) {
                    System.out.print("Enter new file size (MB): ");
                    double newFileSize = App.scanner.nextDouble();
                    ((Ebook) bookToUpdate).setFileSize(newFileSize);
                } else if (bookToUpdate instanceof Audiobook) {
                    System.out.print("Enter new duration (hours): ");
                    int newDuration = App.scanner.nextInt();
                    ((Audiobook) bookToUpdate).setDuration(newDuration);
                } else {
                    System.out.println("Invalid choice for this book type.");
                }
                break;
            default:
                System.out.println("Invalid choice. No updates made.");
                return;
        }
    
        // Display the updated book information
        ClearConsole.clearConsole();
        System.out.println(bookToUpdate);
        System.out.println("Book updated successfully!");

        Navigation.sideMenu();
        Navigation.handleChoice();
    }

    /**
     * Displays the menu for removing a book, with options to remove by ID or title.
     */
    public static void printRemoveBookMenu() {
        if (Navigation.getCurrentPage().equals("manager")) {
            Navigation.setPreviousPage("manager");
        }
        Navigation.setCurrentPage("removeBook");
        ClearConsole.clearConsole();

        System.out.println("Remove a Book");
        System.out.println("=================");
        System.out.println("Remove a book by:");
        System.out.println("(1) ID");
        System.out.println("(2) Title");
        Navigation.sideMenu();

        String choice = Navigation.handleChoice();
        
        // Handle book removal choice
        switch (choice) {
            case "1":
                Remove.removeBookById();
                break;
            case "2":
                Remove.removeBookByTitle();
                break;
            default:
                printRemoveBookMenu(); // Invalid choice, re-display the menu
        }
    }

    /**
     * Displays the menu for finding a book by either ID or title.
     */
    public static void printFindBookMenu() {
        Navigation.setCurrentPage("findBook");
        Navigation.setPreviousPage("manager");
        ClearConsole.clearConsole();

        System.out.println("Find a Book");
        System.out.println("=================");
        System.out.println("Find a book by:");
        System.out.println("(1) ID");
        System.out.println("(2) Title");
        Navigation.sideMenu();

        String choice = Navigation.handleChoice();

        switch (choice) {
            case "1":
                Find.findBookById();
                break;
            case "2":
                Find.findBookByTitle();
                break;
            default:
                printFindBookMenu(); // Invalid choice, re-display the menu
        }
    }
}
