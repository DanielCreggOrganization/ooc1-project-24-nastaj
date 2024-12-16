package ie.atu.bookapp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BookManager {
    // Because the size of the arrays are not known at the start of the program, they should be getting resized dynamically.
    // ArrayList is perfect for that. It makes the CRUD operations on arrays much easier.
    private static ArrayList<Book> books;
    private static ArrayList <PrintedBook> printedBooks;
    private static ArrayList<Ebook> ebooks;
    private static ArrayList <Audiobook> audiobooks;

    BookManager() {
        BookManager.books = new ArrayList<>();
        BookManager.printedBooks = new ArrayList<>();
        BookManager.ebooks = new ArrayList<>();
        BookManager.audiobooks = new ArrayList<>();
    }

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

        String choice = App.scanner.nextLine();

        Navigation.sideMenu(choice);
        
        switch(choice) {
            // TODO: All choices for this menu
            case "1": 
                BookManager.printAddBookMenu();
                break;
            case "2": 
                BookManager.printRemoveBookMenu();
                break;
            case "3": 
                BookManager.printFindBookMenu();
                break;
            case "4": 
                BookManager.printShowBooksMenu();
                break;
        }
    }

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

        System.out.print("Enter your choice: ");

        String choice = App.scanner.nextLine();

        Navigation.sideMenu(choice);

        switch(choice) {
            // TODO: All choices for this menu
            case "1": 
                BookManager.showBooks("printed");
                break;
            case "2": 
                BookManager.showBooks("ebooks");
                break;
            case "3": 
                BookManager.showBooks("audiobooks");
                break;
            case "4": 
                BookManager.showBooks("all");
                break;
        }
    }

    private static void showBooks(String type) {
        Navigation.setCurrentPage("showBooksResults");
        Navigation.setPreviousPage("showBooks");
        ClearConsole.clearConsole();

        int results = 0;
        switch(type) {
            case "printed":
                results = printedBooks.size();
                break; 
            case "ebooks":
                results = ebooks.size();
                break;
            case "audiobooks":
                results = audiobooks.size();
                break;
            case "all":
                results = books.size();
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
    
    public static void printSortMenu(String type, int results) {
        Navigation.setCurrentPage("sortMenu");
        Navigation.setPreviousPage("showBooks");
        ClearConsole.clearConsole();

        System.out.println("Sort " + type + " books by:");
        System.out.println("(1) Title (A-Z)");
        System.out.println("(2) Title (Z-A)");
        System.out.println("(3) Author");
        System.out.println("(4) Price (Ascending)");
        System.out.println("(5) Price (Descending)");

        if (type.equals("printed")) {
            System.out.println("(6) Page Count");
        } else if (type.equals("ebooks")) {
            System.out.println("(6) File Size");
        } else if (type.equals("audiobooks")) {
            System.out.println("(6) Duration");
        }
        
        System.out.println("(0) Default (No Sorting)");

        System.out.print("Enter your choice: ");

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
                sortBy = "priceasc";
                break;

            case "5": 
                sortBy = "pricedesc";
                break;

            case "6":
                if (type.equals("printed")) sortBy = "pages";
                if (type.equals("ebooks")) sortBy = "filesize";
                if (type.equals("audiobooks")) sortBy = "duration";
                break;

            default: sortBy = "default";
        }

        if (!type.equals("all")) {
            displayBooks(type, sortBy, results);
        }
        else {
            displayAllBooks(type, sortBy, results);
        }
    }

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

        System.out.print("Enter your choice: ");

        String choice = App.scanner.nextLine();

        Navigation.sideMenu(choice);

        switch(choice) {
            // TODO: All choices for this menu
            case "1": 
                BookManager.printBookMenu();
                break;
            case "2": 
                BookManager.printEbookMenu();
                break;
            case "3": 
                BookManager.printAudiobookMenu();
                break;
        }
    }

    public static void printBookMenu() {
        String title;
        String author;
        double price;
        int publicationYear;
        int pageCount;
        String choice;

        Navigation.setCurrentPage("book");
        Navigation.setPreviousPage("addBook");
        ClearConsole.clearConsole();

        System.out.println("Printed Book");
        System.out.println("=================");
        System.out.println("Enter details");
        System.out.println("--------------");

        title = InputHandler.promptString("Title");
        author = InputHandler.promptString("Author");
        price = InputHandler.promptDouble("Price");
        publicationYear = InputHandler.promptInt("Publication Year");
        pageCount = InputHandler.promptInt("Page Count");
        
        System.out.println("==============");
        System.out.println("Is this correct?");
        System.out.println("--------------");
        System.out.print("Y / N: ");

        choice = App.scanner.nextLine();
        
        if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")) {
            PrintedBook PrintedBook = new PrintedBook(title, author, price, publicationYear, pageCount);
            BookManager.printedBooks.add(PrintedBook);
            BookManager.books.add(PrintedBook);
        
            ClearConsole.clearConsole();

            System.out.println("Book added successfully!");
            System.out.println("Add another book?");
        
            System.out.println("--------------");
            System.out.print("Y / N: ");
            choice = App.scanner.nextLine();
                    
            if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")) {
                // Prompt the user again
                BookManager.printBookMenu();
            }
                    
            else if (choice.equalsIgnoreCase("n") || choice.equalsIgnoreCase("no")) {
                Navigation.moveTo(Navigation.getPreviousPage());
            }
        
        }
        else if (choice.equalsIgnoreCase("n") || choice.equalsIgnoreCase("no")) {
            // Prompt the user again
            BookManager.printBookMenu();
        }
    }

    public static void printEbookMenu() {
        String title;
        String author;
        double price;
        int publicationYear;
        String choice;
        double fileSize;
        String format;

        Navigation.setCurrentPage("ebook");
        Navigation.setPreviousPage("addBook");
        ClearConsole.clearConsole();

        System.out.println("Ebook");
        System.out.println("=================");
        System.out.println("Enter details");
        System.out.println("--------------");

        title = InputHandler.promptString("Title");
        author = InputHandler.promptString("Author");
        price = InputHandler.promptDouble("Price");
        publicationYear = InputHandler.promptInt("Publication Year");
        fileSize = InputHandler.promptDouble("File Size (MB)");
        format = InputHandler.promptString("File Format (i.e EPUB)");;

        System.out.println("==============");
        System.out.println("Is this correct?");
        System.out.println("--------------");
        System.out.print("Y / N: ");
        choice = App.scanner.nextLine();
        
        if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")) {
            Ebook ebook = new Ebook(title, author, price, publicationYear, fileSize, format);
            BookManager.ebooks.add(ebook);
            BookManager.books.add(ebook);
        
            ClearConsole.clearConsole();
        
            System.out.println("Ebook added successfully!");
            System.out.println("Add another ebook?");
        
            System.out.println("--------------");
            System.out.print("Y / N: ");
            choice = App.scanner.nextLine();
                    
            if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")) {
                // Prompt the user again
                BookManager.printEbookMenu();
            }
                    
            else if (choice.equalsIgnoreCase("n") || choice.equalsIgnoreCase("no")) {
                Navigation.moveTo(Navigation.getPreviousPage());
            }
        
        }
        else if (choice.equalsIgnoreCase("n") || choice.equalsIgnoreCase("no")) {
            // Prompt the user again
            BookManager.printEbookMenu();
        }
    }

    public static void printAudiobookMenu() {
        String title;
        String author;
        double price;
        int publicationYear;
        String choice;
        int duration;
        String narrator;

        Navigation.setCurrentPage("audiobook");
        Navigation.setPreviousPage("addBook");
        ClearConsole.clearConsole();

        System.out.println("Audiobook");
        System.out.println("=================");
        System.out.println("Enter details");
        System.out.println("--------------");

        title = InputHandler.promptString("Title");
        author = InputHandler.promptString("Author");
        price = InputHandler.promptDouble("Price");
        publicationYear = InputHandler.promptInt("Publication Year");
        duration = InputHandler.promptInt("Duration");
        narrator = InputHandler.promptString("Narrator");

        
        System.out.println("==============");
        System.out.println("Is this correct?");
        System.out.println("--------------");
        System.out.print("Y / N: ");
        choice = App.scanner.nextLine();
        
        if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")) {
            Audiobook audiobook = new Audiobook(title, author, price, publicationYear, duration, narrator);
            BookManager.audiobooks.add(audiobook);
            BookManager.books.add(audiobook);
        
            ClearConsole.clearConsole();
        
            System.out.println("Audiobook added successfully!");
            System.out.println("Add another audiobook?");
        
            System.out.println("--------------");
            System.out.print("Y / N: ");
            choice = App.scanner.nextLine();
                    
            if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")) {
                // Prompt the user again
                BookManager.printAudiobookMenu();
            }
                    
            else if (choice.equalsIgnoreCase("n") || choice.equalsIgnoreCase("no")) {
                Navigation.moveTo(Navigation.getPreviousPage());
            }
        
        }
        else if (choice.equalsIgnoreCase("n") || choice.equalsIgnoreCase("no")) {
            // Prompt the user again
            BookManager.printEbookMenu();
        }
    }

    // REMOVING BOOKS
    public static void printRemoveBookMenu() {
        Navigation.setCurrentPage("removeBook");
        Navigation.setPreviousPage("manager");
        ClearConsole.clearConsole();

        System.out.println("Remove a Book");
        System.out.println("=================");
        System.out.println("Remove a book by:");
        System.out.println("(1) ID");
        System.out.println("(2) Title");
        Navigation.sideMenu();

        System.out.print("Enter your choice: ");

        String choice = App.scanner.nextLine();
        
        Navigation.sideMenu(choice);
        switch (choice) {
            case "1":
                BookManager.removeBookById();
                break;
            case "2":
                BookManager.removeBookByTitle();
                break;
            default:
                BookManager.printRemoveBookMenu();
        }
}

    private static void removeBookById() {
        Navigation.setCurrentPage("removeById");
        Navigation.setPreviousPage("removeBook");
        ClearConsole.clearConsole();

        if (BookManager.books.isEmpty()) {
            Navigation.sideMenu();
            System.out.print("Enter your choice: ");
            String choice = App.scanner.nextLine();
            Navigation.sideMenu(choice);
        }

        while (true) {
            System.out.print("Enter Book ID to remove: ");
            String bookId = App.scanner.nextLine().trim();

            // Validate that the input is not empty
            if (bookId.isEmpty()) {
                System.out.println("Book ID cannot be empty. Please try again.\n");
                continue; // Restart the loop
            }

            if (!bookId.matches("\\d+")) { // Checks if the input is numeric
                System.out.println("Invalid Book ID. Please enter numbers only.\n");
                continue; // Restart the loop
            }

            Book book = findBookById(bookId);
            if (book != null) {
                confirmAndDelete(book);
                return; // Exit the method after successful deletion
            } else {
                System.out.println("No book found with the given ID.");
                System.out.println("Do you want to try again?");
                System.out.println("--------------");
                System.out.print("Y / N: ");
                String choice = App.scanner.nextLine().trim();

                // Validate user input for retry confirmation
                if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")) {
                    continue; // Retry entering a Book ID
                } else if (choice.equalsIgnoreCase("n") || choice.equalsIgnoreCase("no")) {
                    Navigation.moveTo(Navigation.getPreviousPage());
                    return; // Exit the method and navigate back
                } else {
                    System.out.println("Invalid choice. Returning to the previous menu.");
                    Navigation.moveTo(Navigation.getPreviousPage());
                    return; // Exit the method with invalid input handling
                }
            }
        }
    }

    private static void removeBookByTitle() {
        Navigation.setCurrentPage("removeByTitle");
        Navigation.setPreviousPage("removeBook");
        ClearConsole.clearConsole();

        if (BookManager.books.isEmpty()) {
            Navigation.sideMenu();
            System.out.print("Enter your choice: ");
            String choice = App.scanner.nextLine();
            Navigation.sideMenu(choice);
        }

        while (true) {
            System.out.print("Enter Book Title to Remove: ");
            String title = App.scanner.nextLine();

            List<Book> matchingBooks = findBooksByTitle(title);

            if (!matchingBooks.isEmpty()) {
                System.out.println("Matching Books:");

                for (int i = 0; i < matchingBooks.size(); i++) {
                    System.out.println((i + 1) + ". " + matchingBooks.get(i));
                }

                System.out.print("Which book do you want to delete?: ");

                String choice = App.scanner.nextLine();
                int index = Integer.parseInt(choice) - 1;

                if (index >= 0 && index < matchingBooks.size()) {
                    confirmAndDelete(matchingBooks.get(index));
                    break;
                } else {
                    System.out.println("Invalid selection.");
                }
            } else {
                System.out.println("No books found with the given name.");
                System.out.println("Do you want to try again?");
                System.out.println("--------------");
                System.out.print("Y / N: ");
                String choice = App.scanner.nextLine();
                if (choice.equalsIgnoreCase("n") || choice.equalsIgnoreCase("no")) {
                    Navigation.moveTo(Navigation.getPreviousPage());
                    break;
                }
            }
        }
    }

    private static void confirmAndDelete(Book book) {
        System.out.println(book + "\n");
        System.out.println("Are you sure you want to delete the following book?\n");
        System.out.print("Y / N: ");

        String confirmation = App.scanner.nextLine();

        if (confirmation.equalsIgnoreCase("y") || confirmation.equalsIgnoreCase("yes")) {
            // Remove the book from the appropriate list
            if (book instanceof PrintedBook) {
                printedBooks.remove(book);
            } else if (book instanceof Ebook) {
                ebooks.remove(book);
            } else if (book instanceof Audiobook) {
                audiobooks.remove(book);
            }
            books.remove(book);
            System.out.println("Book deleted successfully!");
        } else {
            System.out.println("Book deletion cancelled.");
        }
        Navigation.moveTo(Navigation.getPreviousPage());
    }

    // Utility Methods
    private static Book findBookById(String bookId) {
        // Convert bookId string to int
        int id = Integer.parseInt(bookId);

        // Search in all categories for a book with the given ID
        for (Book book : printedBooks) {
            if (book.getId() == id) return book;
        }
        for (Book book : ebooks) {
            if (book.getId() == id) return book;
        }
        for (Book book : audiobooks) {
            if (book.getId() == id) return book;
        }

        return null; // No book found
    }

    private static List<Book> findBooksByTitle(String title) {
        List<Book> matchingBooks = new ArrayList<>();

        // Search in all categories for books with the given name
        for (Book book : printedBooks) {
            if (book.getTitle().equalsIgnoreCase(title)) matchingBooks.add(book);
        }
        for (Book book : ebooks) {
            if (book.getTitle().equalsIgnoreCase(title)) matchingBooks.add(book);
        }
        for (Book book : audiobooks) {
            if (book.getTitle().equalsIgnoreCase(title)) matchingBooks.add(book);
        }
        return matchingBooks;
    }

    private static void displayBooks(String type, String sortBy, int results) {
        // Check the type and display the appropriate list
        System.out.println(type);
        if (type.equals("printed")) {
            if (BookManager.printedBooks.isEmpty()) {
                System.out.println("No printed books available.");
                return;
            }

            // Apply sorting
            sortPrintedBooks(sortBy);
            
            System.out.println("Number of Printed Books in library: " + results);
            System.out.printf("| %-4s | %-25s | %-20s | %-7s | %-6s |%n", "ID", "Title", "Author", "Price", "Page Count");
            System.out.println("+------+---------------------------+----------------------+---------+--------+");
            for (PrintedBook book : printedBooks) {
                System.out.printf("| %-4d | %-25s | %-20s | $%-6.2f | %-6d |%n",
                        book.getId(), book.getTitle(), book.getAuthor(), book.getPrice(), book.getPageCount());
            }
            System.out.println("+------+---------------------------+----------------------+---------+--------+");
    
        } else if (type.equalsIgnoreCase("ebooks")) {
            if (BookManager.ebooks.isEmpty()) {
                System.out.println("No ebooks available.");
                return;
            }

            // Apply sorting
            sortEbooks(sortBy);

            System.out.println("Number of Ebooks in library: " + results);
            System.out.printf("| %-4s | %-25s | %-20s | %-7s | %-6s | %-8s |%n", "ID", "Title", "Author", "Price", "Size", "Format");
            System.out.println("+------+---------------------------+----------------------+---------+--------+----------+");
            for (Ebook ebook : BookManager.ebooks) {
                System.out.printf("| %-4d | %-25s | %-20s | $%-6.2f | %-6.1f MB | %-8s |%n",
                        ebook.getId(), ebook.getTitle(), ebook.getAuthor(), ebook.getPrice(), ebook.getFileSize(), ebook.getFormat());
            }
            System.out.println("+------+---------------------------+----------------------+---------+--------+----------+");
    
        } else if (type.equalsIgnoreCase("audiobooks")) {
            if (BookManager.audiobooks.isEmpty()) {
                System.out.println("No audiobooks available.");
                return;
            }

            // Apply sorting
            sortAudiobooks(sortBy);

            System.out.println("Number of Audiobooks in library: " + results);
            System.out.printf("| %-4s | %-25s | %-20s | %-7s | %-6s | %-15s |%n", "ID", "Title", "Author", "Price", "Duration", "Narrator");
            System.out.println("+------+---------------------------+----------------------+---------+--------+-----------------+");
            for (Audiobook audiobook : BookManager.audiobooks) {
                System.out.printf("| %-4d | %-25s | %-20s | $%-6.2f | %-1dh | %-15s |%n",
                        audiobook.getId(), audiobook.getTitle(), audiobook.getAuthor(), audiobook.getPrice(), audiobook.getDuration(), audiobook.getNarrator());
            }
            System.out.println("+------+---------------------------+----------------------+---------+--------+-----------------+");
        }

        Navigation.sideMenu();
        System.out.println("(S) Sort By");
        System.out.println("---------------------------------------------");
        System.out.print("Enter your choice: ");
        String choice = App.scanner.nextLine();
        if (choice.equalsIgnoreCase("s")) {
            printSortMenu(type, results);
        }
        Navigation.sideMenu(choice);
    }

    private static void displayAllBooks(String type, String sortBy, int results) {
        if (BookManager.books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        // Apply sorting
        System.out.println(sortBy);
        sortAllBooks(sortBy);
    
        // Table header with appropriate column widths
        System.out.printf("| %-4s | %-25s | %-20s | %-8s | %-12s | %-22s |%n", "ID", "Title", "Author", "Price", "Type", "Extra Info");
        System.out.println("+------+---------------------------+----------------------+----------+--------------+---------------------------+");
    
        // Loop through all books
        for (Book book : BookManager.books) {
            // Print common details
            System.out.printf("| %-4d | %-25s | %-20s | $%-7.2f | %-12s | ",
                    book.getId(), book.getTitle(), book.getAuthor(), book.getPrice(), book.getClass().getSimpleName());
    
            // Print specific details based on type of book
            if (book instanceof PrintedBook) {
                PrintedBook printedBook = (PrintedBook) book;
                System.out.printf("%-22d Pages%n", printedBook.getPageCount());
            } else if (book instanceof Ebook) {
                Ebook ebook = (Ebook) book;
                System.out.printf("%-10.2f MB | %-10s%n", ebook.getFileSize(), ebook.getFormat());
            } else if (book instanceof Audiobook) {
                Audiobook audiobook = (Audiobook) book;
                System.out.printf("%-10d hrs | Narrator: %-10s%n", audiobook.getDuration(), audiobook.getNarrator());
            }
        }
        System.out.println("+------+---------------------------+----------------------+----------+--------------+---------------------------+");

        Navigation.sideMenu();
        System.out.println("---------------------------------------------");
        System.out.println("(S) Sort By");
        System.out.print("Enter your choice: ");
        String choice = App.scanner.nextLine();
        if (choice.equalsIgnoreCase("s")) {
            printSortMenu(type, results);
        }
        Navigation.sideMenu(choice);
    }

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

        System.out.print("Enter your choice: ");

        String choice = App.scanner.nextLine();
        
        Navigation.sideMenu(choice);
        switch (choice) {
            case "1":
                BookManager.findBookById();
                break;
            case "2":
                BookManager.findBookByTitle();
                break;
            default:
                BookManager.printFindBookMenu();
        }
    }

    private static void findBookByTitle() {
        Navigation.setCurrentPage("findByTitle");
        Navigation.setPreviousPage("findBook");
        ClearConsole.clearConsole();

        if (BookManager.books.isEmpty()) {
            System.out.println("No books available.");
            Navigation.sideMenu();
            System.out.print("Enter your choice: ");
            String choice = App.scanner.nextLine();
            Navigation.sideMenu(choice);
        }

        while (true) {
            System.out.print("Enter Book Title: ");
            String title = App.scanner.nextLine();

            List<Book> matchingBooks = findBooksByTitle(title);

            if (!matchingBooks.isEmpty()) {
                System.out.println("Found result(s):");

                for (int i = 0; i < matchingBooks.size(); i++) {
                    System.out.println(matchingBooks.get(i));
                }

                Navigation.sideMenu();
                System.out.print("Enter your choice: ");
                String choice = App.scanner.nextLine();
                Navigation.sideMenu(choice);
                return;
            } else {
                System.out.println("No books found with the given name.");
                System.out.println("Do you want to try again?");
                System.out.println("--------------");
                System.out.print("Y / N: ");
                String choice = App.scanner.nextLine();
                if (choice.equalsIgnoreCase("n") || choice.equalsIgnoreCase("no")) {
                    Navigation.moveTo(Navigation.getPreviousPage());
                    break;
                }
            }
        }
    }

    private static void findBookById() {
        Navigation.setCurrentPage("findById");
        Navigation.setPreviousPage("findBook");
        ClearConsole.clearConsole();

        if (BookManager.books.isEmpty()) {
            System.out.println("No books available.");
            Navigation.sideMenu();
            System.out.print("Enter your choice: ");
            String choice = App.scanner.nextLine();
            Navigation.sideMenu(choice);
        }
        
            while (true) {
                System.out.print("Enter Book ID: ");
                String bookId = App.scanner.nextLine().trim();
    
                // Validate that the input is not empty
                if (bookId.isEmpty()) {
                    System.out.println("Book ID cannot be empty. Please try again.\n");
                    continue; // Restart the loop
                }
    
                if (!bookId.matches("\\d+")) { // Checks if the input is numeric
                    System.out.println("Invalid Book ID. Please enter numbers only.\n");
                    continue; // Restart the loop
                }
    
                Book book = findBookById(bookId);
                if (book != null) {
                    System.out.println("Found result");
                    System.out.println(book);
                    
                    Navigation.sideMenu();
                    System.out.print("Enter your choice: ");
                    String choice = App.scanner.nextLine();
                    Navigation.sideMenu(choice);
                    return; // Exit the method after successful find
                } else {
                    System.out.println("No book found with the given ID.");
                    System.out.println("Do you want to try again?");
                    System.out.println("--------------");
                    System.out.print("Y / N: ");
                    String choice = App.scanner.nextLine().trim();
    
                    // Validate user input for retry confirmation
                    if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")) {
                        continue; // Retry entering a Book ID
                    } else if (choice.equalsIgnoreCase("n") || choice.equalsIgnoreCase("no")) {
                        Navigation.moveTo(Navigation.getPreviousPage());
                        return; // Exit the method and navigate back
                    } else {
                        System.out.println("Invalid choice. Returning to the previous menu.");
                        Navigation.moveTo(Navigation.getPreviousPage());
                        return; // Exit the method with invalid input handling
                    }
                }
        }
    }

    public static void populateBooks() {
        // Adding printedBooks (Physical Books)
        printedBooks.add(new PrintedBook("The Odyssey", "Homer", 17.99, 800, 450));
        printedBooks.add(new PrintedBook("Brave New World", "Aldous Huxley", 19.99, 1932, 268));
        printedBooks.add(new PrintedBook("The Brothers Karamazov", "Fyodor Dostoevsky", 22.99, 1880, 350));

        // Adding Ebooks
        ebooks.add(new Ebook("Sapiens", "Yuval Noah Harari", 9.99, 2011, 5.5, "EPUB"));
        ebooks.add(new Ebook("Effective Java", "Joshua Bloch", 8.99, 2018, 3.2, "PDF"));
        ebooks.add(new Ebook("Becoming", "Michelle Obama", 12.99, 2018, 6.8, "EPUB"));
        ebooks.add(new Ebook("Educated", "Tara Westover", 10.99, 2018, 4.5, "PDF"));
        ebooks.add(new Ebook("The Silent Patient", "Alex Michaelides", 6.99, 2019, 2.8, "EPUB"));

        // Adding Audiobooks
        audiobooks.add(new Audiobook("The Night Circus", "Erin Morgenstern", 25.99, 2011, 12, "Jim Dale"));
        audiobooks.add(new Audiobook("Dune", "Frank Herbert", 29.99, 1965, 21, "Simon Vance"));
        audiobooks.add(new Audiobook("The Goldfinch", "Donna Tartt", 24.99, 2013, 32, "David Pittu"));
        audiobooks.add(new Audiobook("Becoming", "Michelle Obama", 24.99, 2018, 19, "Michelle Obama"));
        audiobooks.add(new Audiobook("The Alchemist", "Paulo Coelho", 14.99, 1988, 7, "Jeremy Irons"));

         // Adding all books to the general 'books' ArrayList
         books.addAll(printedBooks);  // Add all printedBooks to books
         books.addAll(ebooks);        // Add all ebooks to books
         books.addAll(audiobooks);    // Add all audiobooks to books
    }

    private static <T extends Book> void sortBooks(ArrayList<T> books, String sortBy) {
        switch (sortBy.toLowerCase()) {
            case "titleasc":
                books.sort(Comparator.comparing(Book::getTitle));
                break;

            case "titledesc":
                books.sort(Comparator.comparing(Book::getTitle).reversed());
                break;

            case "author":
                books.sort(Comparator.comparing(Book::getAuthor));
                break;

            case "priceasc":
                books.sort(Comparator.comparingDouble(Book::getPrice));
                break;

            case "pricedesc":
                books.sort(Comparator.comparingDouble(Book::getPrice).reversed());
                break;

            case "pages":
                if (books.get(0) instanceof PrintedBook) {
                    books.sort(Comparator.comparingInt(b -> ((PrintedBook) b).getPageCount()));
                }
                break;

            case "filesize":
                if (books.get(0) instanceof Ebook) {
                    books.sort(Comparator.comparingDouble(b -> ((Ebook) b).getFileSize()));
                }
                break;

            case "duration":
                if (books.get(0) instanceof Audiobook) {
                    books.sort(Comparator.comparingInt(b -> ((Audiobook) b).getDuration()));
                }
                break;

            default:
                books.sort(Comparator.comparingInt(Book::getId));
        }
    }
    
    public static void sortAllBooks(String sortBy) {
        sortBooks(BookManager.books, sortBy);
    }
    
    public static void sortPrintedBooks(String sortBy) {
        sortBooks(BookManager.printedBooks, sortBy);
    }
    
    public static void sortEbooks(String sortBy) {
        sortBooks(BookManager.ebooks, sortBy);
    }
    
    public static void sortAudiobooks(String sortBy) {
        sortBooks(BookManager.audiobooks, sortBy);
    }

    public static ArrayList<PrintedBook> getPrintedBooks() {
        return BookManager.printedBooks;
    }
    
    public static ArrayList<Ebook> getEbooks() {
        return BookManager.ebooks;
    }

    public static ArrayList<Audiobook> getAudiobooks() {
        return BookManager.audiobooks;
    } 

    public static ArrayList<Book> getAllBooks() {
        return BookManager.books;
    } 

}
