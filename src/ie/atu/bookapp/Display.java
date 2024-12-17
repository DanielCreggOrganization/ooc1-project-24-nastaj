package ie.atu.bookapp;

import java.util.ArrayList;

public class Display {
    public static void showBooks(String type) {
        Navigation.setCurrentPage("showBooksResults");
        Navigation.setPreviousPage("showBooks");
        ClearConsole.clearConsole();

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

        // Prompt the user to select sorting criteria
        String sortBy = "default";

        // Apply sorting and display based on the selected criteria
        if (!type.equals("all")) {
            displayBooks(type, sortBy, results);
        } else {
            displayAllBooks(type, sortBy, results);
        }
    }

    public static void displayBooks(String type, String sortBy, int results) {
        ArrayList<PrintedBook> printedBooks = Manager.getPrintedBooks();
        ArrayList<Ebook> ebooks = Manager.getEbooks();
        ArrayList<Audiobook> audiobooks = Manager.getAudiobooks();
    
        if (type.equals("printed")) {
            Navigation.setCurrentPage("resultsPrinted");
            Navigation.setPreviousPage("showBooks");

            if (printedBooks.isEmpty()) {
                System.out.println("No printed books available.");
                return;
            }
    
            // Apply sorting
            Sort.sortPrintedBooks(sortBy);
    
            System.out.println("Number of Printed Books in library: " + results + "\n");
            System.out.printf("| %-4s | %-25s | %-20s | %-20s | %-7s | %-6s |%n", 
                              "ID", "Title", "Author", "Genre", "Price", "Pages");
            System.out.println("+------+---------------------------+----------------------+----------------------+---------+--------+");
            for (PrintedBook book : printedBooks) {
                System.out.printf("| %-4d | %-25s | %-20s | %-20s | $%-6.2f | %-6d |%n",
                        book.getId(), book.getTitle(), book.getAuthor(), book.getGenre(), book.getPrice(), book.getPageCount());
            }
            System.out.println("+------+---------------------------+----------------------+----------------------+---------+--------+");
    
        } else if (type.equalsIgnoreCase("ebooks")) {
            Navigation.setCurrentPage("resultsEbook");
            Navigation.setPreviousPage("showBooks");

            if (ebooks.isEmpty()) {
                System.out.println("No ebooks available.");
                return;
            }
    
            // Apply sorting
            Sort.sortEbooks(sortBy);
    
            System.out.println("Number of Ebooks in library: " + results + "\n");
            System.out.printf("| %-4s | %-25s | %-20s | %-20s | %-7s | %-6s | %-8s |%n", 
                              "ID", "Title", "Author", "Genre", "Price", "Size", "Format");
            System.out.println("+------+---------------------------+----------------------+----------------------+---------+--------+----------+");
            for (Ebook ebook : ebooks) {
                System.out.printf("| %-4d | %-25s | %-20s | %-20s | $%-6.2f | %-6.1f MB | %-8s |%n",
                        ebook.getId(), ebook.getTitle(), ebook.getAuthor(), ebook.getGenre(), ebook.getPrice(), ebook.getFileSize(), ebook.getFormat());
            }
            System.out.println("+------+---------------------------+----------------------+----------------------+---------+--------+----------+");
    
        } else if (type.equalsIgnoreCase("audiobooks")) {
            Navigation.setCurrentPage("resultsAudiobook");
            Navigation.setPreviousPage("showBooks");

            if (audiobooks.isEmpty()) {
                System.out.println("No audiobooks available.");
                return;
            }
    
            // Apply sorting
            Sort.sortAudiobooks(sortBy);
    
            System.out.println("Number of Audiobooks in library: " + results + "\n");
            System.out.printf("| %-4s | %-25s | %-20s | %-20s | %-7s | %-6s | %-15s |%n", 
                              "ID", "Title", "Author", "Genre", "Price", "Duration", "Narrator");
            System.out.println("+------+---------------------------+----------------------+----------------------+---------+--------+-----------------+");
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

    public static void displayAllBooks(String type, String sortBy, int results) {
        Navigation.setCurrentPage("resultsAll");
        Navigation.setPreviousPage("showBooks");

        ArrayList<Book> books = Manager.getAllBooks();
    
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
    
        // Apply sorting
        Sort.sortAllBooks(sortBy);
    
        // Table header with appropriate column widths
        System.out.printf("| %-4s | %-25s | %-20s | %-20s | %-8s | %-12s |%n", 
                          "ID", "Title", "Author", "Genre", "Price", "Type");
        System.out.println("+------+---------------------------+----------------------+----------------------+----------+--------------+");
    
        // Loop through all books
        for (Book book : books) {
            // Print common details
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
