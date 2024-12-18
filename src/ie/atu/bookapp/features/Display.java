package ie.atu.bookapp.features;

import java.util.ArrayList;

import ie.atu.bookapp.App;
import ie.atu.bookapp.classes.Audiobook;
import ie.atu.bookapp.classes.Book;
import ie.atu.bookapp.classes.Ebook;
import ie.atu.bookapp.classes.PrintedBook;
import ie.atu.bookapp.nav.Menu;
import ie.atu.bookapp.nav.Navigation;
import ie.atu.bookapp.utilities.ClearConsole;

public class Display {

    /**
     * Displays the list of books based on the specified type.
     * 
     * This method clears the console, displays the number of books of the specified
     * type (printed, ebooks, audiobooks, or all), and allows sorting and navigating options.
     * 
     * @param type The type of books to display (printed, ebooks, audiobooks, or all).
     */
    public static void showBooks(String type) {
        // Set the current and previous page for navigation
        Navigation.setCurrentPage("showBooksResults");
        Navigation.setPreviousPage("showBooks");
        
        // Clear the console screen for a fresh display
        ClearConsole.clearConsole();

        // Determine the number of books based on the selected type
        int results = 0;
        switch(type) {
            case "printed":
                results = Manager.getPrintedBooks().size();
                break; 
            case "ebooks":
                results = Manager.getEbooks().size();
                break;
            case "audiobooks":
                results = Manager.getAudiobooks().size();
                break;
            case "all":
                results = Manager.getAllBooks().size();
                break;
        }

        // Prompt the user to select sorting criteria (currently default)
        String sortBy = "default";

        // Call appropriate method to display books based on type
        if (!type.equals("all")) {
            displayBooks(type, sortBy, results);
        } else {
            displayAllBooks(type, sortBy, results);
        }
    }

    /**
     * Displays books of a specific type (printed, ebooks, audiobooks).
     * 
     * This method applies sorting to the books of the specified type and displays them in a table.
     * 
     * @param type The type of books to display (printed, ebooks, or audiobooks).
     * @param sortBy The sorting criteria to apply.
     * @param results The number of books to display.
     */
    public static void displayBooks(String type, String sortBy, int results) {
        // Get the respective list of books
        ArrayList<PrintedBook> printedBooks = Manager.getPrintedBooks();
        ArrayList<Ebook> ebooks = Manager.getEbooks();
        ArrayList<Audiobook> audiobooks = Manager.getAudiobooks();
    
        if (type.equals("printed")) {
            Navigation.setCurrentPage("resultsPrinted");
            Navigation.setPreviousPage("showBooks");

            // Check if the list is empty and inform the user
            if (printedBooks.isEmpty()) {
                System.out.println("No printed books available.");
                return;
            }
    
            // Apply sorting
            Sort.sortPrintedBooks(sortBy);
    
            // Display table header for printed books
            System.out.println("Number of Printed Books in library: " + results + "\n");
            System.out.printf("| %-4s | %-25s | %-20s | %-20s | %-7s | %-6s |%n", 
                              "ID", "Title", "Author", "Genre", "Price", "Pages");
            System.out.println("+------+---------------------------+----------------------+----------------------+---------+--------+");
            
            // Display each printed book's details
            for (PrintedBook book : printedBooks) {
                System.out.printf("| %-4d | %-25s | %-20s | %-20s | $%-6.2f | %-6d |%n",
                        book.getId(), book.getTitle(), book.getAuthor(), book.getGenre(), book.getPrice(), book.getPageCount());
            }
            System.out.println("+------+---------------------------+----------------------+----------------------+---------+--------+");
    
        } else if (type.equalsIgnoreCase("ebooks")) {
            Navigation.setCurrentPage("resultsEbook");
            Navigation.setPreviousPage("showBooks");

            // Check if the list is empty and inform the user
            if (ebooks.isEmpty()) {
                System.out.println("No ebooks available.");
                return;
            }
    
            // Apply sorting
            Sort.sortEbooks(sortBy);
    
            // Display table header for ebooks
            System.out.println("Number of Ebooks in library: " + results + "\n");
            System.out.printf("| %-4s | %-25s | %-20s | %-20s | %-7s | %-6s | %-8s |%n", 
                              "ID", "Title", "Author", "Genre", "Price", "Size", "Format");
            System.out.println("+------+---------------------------+----------------------+----------------------+---------+--------+----------+");
            
            // Display each ebook's details
            for (Ebook ebook : ebooks) {
                System.out.printf("| %-4d | %-25s | %-20s | %-20s | $%-6.2f | %-6.1f MB | %-8s |%n",
                        ebook.getId(), ebook.getTitle(), ebook.getAuthor(), ebook.getGenre(), ebook.getPrice(), ebook.getFileSize(), ebook.getFormat());
            }
            System.out.println("+------+---------------------------+----------------------+----------------------+---------+--------+----------+");
    
        } else if (type.equalsIgnoreCase("audiobooks")) {
            Navigation.setCurrentPage("resultsAudiobook");
            Navigation.setPreviousPage("showBooks");

            // Check if the list is empty and inform the user
            if (audiobooks.isEmpty()) {
                System.out.println("No audiobooks available.");
                return;
            }
    
            // Apply sorting
            Sort.sortAudiobooks(sortBy);
    
            // Display table header for audiobooks
            System.out.println("Number of Audiobooks in library: " + results + "\n");
            System.out.printf("| %-4s | %-25s | %-20s | %-20s | %-7s | %-6s | %-15s |%n", 
                              "ID", "Title", "Author", "Genre", "Price", "Duration", "Narrator");
            System.out.println("+------+---------------------------+----------------------+----------------------+---------+--------+-----------------+");
            
            // Display each audiobook's details
            for (Audiobook audiobook : audiobooks) {
                System.out.printf("| %-4d | %-25s | %-20s | %-20s | $%-6.2f | %-1dh | %-15s |%n",
                        audiobook.getId(), audiobook.getTitle(), audiobook.getAuthor(), audiobook.getGenre(), audiobook.getPrice(), audiobook.getDuration(), audiobook.getNarrator());
            }
            System.out.println("+------+---------------------------+----------------------+----------------------+---------+--------+-----------------+");
        }

        // Display navigation options
        Navigation.sideMenu();
        System.out.println("(S) Sort By | (R) Remove a Book | (U) Update a Book");
        System.out.println("---------------------------------------------");
        System.out.print("Enter your choice: ");

        String choice = App.scanner.nextLine();
        // Handle the user's choice for sorting, removing, or updating
        if (choice.equalsIgnoreCase("s")) {
            Menu.printSortMenu(type, results);
        }
        else if (choice.equalsIgnoreCase("r")) {
            Menu.printRemoveBookMenu();
        }
        else if (choice.equalsIgnoreCase("u")) {
            Menu.printUpdateBookMenu();
        }
        
        Navigation.sideMenu(choice);
    }

    /**
     * Displays all books (printed, ebooks, audiobooks) combined in one list.
     * 
     * This method applies sorting and displays all books in a single list with their respective types.
     * 
     * @param type The type of books to display (used for navigation purposes).
     * @param sortBy The sorting criteria to apply.
     * @param results The number of books to display.
     */
    public static void displayAllBooks(String type, String sortBy, int results) {
        Navigation.setCurrentPage("resultsAll");
        Navigation.setPreviousPage("showBooks");

        // Get the combined list of all books
        ArrayList<Book> books = Manager.getAllBooks();
    
        // Check if the list is empty and inform the user
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
    
        // Apply sorting
        Sort.sortAllBooks(sortBy);
    
        // Display table header for all books
        System.out.printf("| %-4s | %-25s | %-20s | %-20s | %-8s | %-12s |%n", 
                          "ID", "Title", "Author", "Genre", "Price", "Type");
        System.out.println("+------+---------------------------+----------------------+----------------------+----------+--------------+");
    
        // Loop through and display each book
        for (Book book : books) {
            // Print common details for all types of books
            System.out.printf("| %-4d | %-25s | %-20s | %-20s | $%-7.2f | %-12s |%n",
                    book.getId(), book.getTitle(), book.getAuthor(), book.getGenre(), book.getPrice(), book.getClass().getSimpleName());
        }
        System.out.println("+------+---------------------------+----------------------+----------------------+----------+--------------+");
    
        // Display navigation options
        Navigation.sideMenu();
        System.out.println("(S) Sort By | (R) Remove a Book | (U) Update a Book");
        System.out.println("---------------------------------------------");
        System.out.print("Enter your choice: ");

        String choice = App.scanner.nextLine();
        // Handle the user's choice for sorting, removing, or updating
        if (choice.equalsIgnoreCase("s")) {
            Menu.printSortMenu(type, results);
        }
        else if (choice.equalsIgnoreCase("r")) {
            Menu.printRemoveBookMenu();
        }
        else if (choice.equalsIgnoreCase("u")) {
            Menu.printUpdateBookMenu();
        }

        Navigation.sideMenu(choice);
    }
}
