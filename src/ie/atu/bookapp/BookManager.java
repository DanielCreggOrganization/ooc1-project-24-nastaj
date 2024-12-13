package ie.atu.bookapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookManager {
    // Because the size of the arrays are not known at the start of the program, they should be getting resized dynamically.
    // ArrayList is perfect for that. It makes the CRUD operations on arrays much easier.
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Book> books;
    private static ArrayList <BookPrinted> booksPrinted;
    private static ArrayList<Ebook> ebooks;
    private static ArrayList <Audiobook> audiobooks;

    BookManager() {
        BookManager.books = new ArrayList<>();
        BookManager.booksPrinted = new ArrayList<>();
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

        String choice = BookManager.scanner.nextLine();

        Navigation.sideMenu(choice);
        
        switch(choice) {
            // TODO: All choices for this menu
            case "1": BookManager.printAddBookMenu();
            case "2": BookManager.printRemoveBookMenu();
        }
    }

    public static void printAddBookMenu() {
        Navigation.setCurrentPage("addBook");
        Navigation.setPreviousPage("manager");
        ClearConsole.clearConsole();

        System.out.println("What do you want to add?");
        System.out.println("(1) Printed Book");
        System.out.println("(2) Ebook");
        System.out.println("(3) Audiobook");
        Navigation.sideMenu();

        System.out.print("Enter your choice: ");

        String choice = scanner.nextLine();

        Navigation.sideMenu(choice);

        switch(choice) {
            // TODO: All choices for this menu
            case "1": BookManager.printBookMenu();
            case "2": BookManager.printEbookMenu();
            case "3": BookManager.printAudiobookMenu();
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

        System.out.println("Enter details");
        System.out.println("=================");

        title = InputHandler.promptString("Title");
        author = InputHandler.promptString("Author");
        price = InputHandler.promptDouble("Price");
        publicationYear = InputHandler.promptInt("Publication Year");
        pageCount = InputHandler.promptInt("Page Count");
        
        System.out.println("==============");
        System.out.println("Is this correct?");
        System.out.println("--------------");
        System.out.print("Y / N: ");

        choice = scanner.nextLine();
        
        if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")) {
            BookPrinted bookPrinted = new BookPrinted(title, author, price, publicationYear, pageCount);
            BookManager.booksPrinted.add(bookPrinted);
            BookManager.books.add(bookPrinted);
        
            ClearConsole.clearConsole();
        
            System.out.println(booksPrinted);
            System.out.println("Book added successfully!");
            System.out.println("Add another book?");
        
            System.out.println("--------------");
            System.out.print("Y / N: ");
            choice = scanner.nextLine();
                    
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

        System.out.println("Enter details");
        System.out.println("=================");

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
        choice = scanner.nextLine();
        
        if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")) {
            Ebook ebook = new Ebook(title, author, price, publicationYear, fileSize, format);
            BookManager.ebooks.add(ebook);
            BookManager.books.add(ebook);
        
            ClearConsole.clearConsole();
        
            System.out.println(ebooks);
            System.out.println("Ebook added successfully!");
            System.out.println("Add another ebook?");
        
            System.out.println("--------------");
            System.out.print("Y / N: ");
            choice = scanner.nextLine();
                    
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

        System.out.println("Enter details");
        System.out.println("=================");

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
        choice = scanner.nextLine();
        
        if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")) {
            Audiobook audiobook = new Audiobook(title, author, price, publicationYear, duration, narrator);
            BookManager.audiobooks.add(audiobook);
            BookManager.books.add(audiobook);
        
            ClearConsole.clearConsole();
        
            System.out.println(ebooks);
            System.out.println("Audiobook added successfully!");
            System.out.println("Add another audiobook?");
        
            System.out.println("--------------");
            System.out.print("Y / N: ");
            choice = scanner.nextLine();
                    
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

        String choice = scanner.nextLine();
        
        Navigation.sideMenu(choice);
        switch (choice) {
            case "1":
                removeBookById();
                break;
            case "2":
                removeBookByTitle();
                break;
            default:
                BookManager.printRemoveBookMenu();
        }
}

    private static void removeBookById() {
        Navigation.setCurrentPage("removeById");
        Navigation.setPreviousPage("removeBook");
        ClearConsole.clearConsole();

        BookManager.displayBooks();

        while (true) {
            System.out.print("Enter Book ID to remove: ");
            String bookId = scanner.nextLine().trim();

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
                System.out.print("Do you want to try again? (Y/N): ");
                String choice = scanner.nextLine().trim();

                // Validate user input for retry confirmation
                if (choice.equalsIgnoreCase("Y")) {
                    continue; // Retry entering a Book ID
                } else if (choice.equalsIgnoreCase("N")) {
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

        while (true) {
            System.out.print("Enter Book Title to Remove: ");
            String title = scanner.nextLine();

            List<Book> matchingBooks = findBooksByTitle(title);

            if (!matchingBooks.isEmpty()) {
                System.out.println("Matching Books:");

                for (int i = 0; i < matchingBooks.size(); i++) {
                    System.out.println((i + 1) + ". " + matchingBooks.get(i));
                }

                System.out.print("Which book do you want to delete?: ");

                String choice = scanner.nextLine();
                int index = Integer.parseInt(choice) - 1;

                if (index >= 0 && index < matchingBooks.size()) {
                    confirmAndDelete(matchingBooks.get(index));
                    break;
                } else {
                    System.out.println("Invalid selection.");
                }
            } else {
                System.out.println("No books found with the given name.");
                System.out.print("Do you want to try again? (Y/N): ");
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("N")) {
                    Navigation.moveTo(Navigation.getPreviousPage());
                    break;
                }
            }
        }
    }

    private static void confirmAndDelete(Book book) {
        System.out.println("Are you sure you want to delete the following book?");
        System.out.println(book);
        System.out.print("Y/N: ");

        String confirmation = scanner.nextLine();

        if (confirmation.equalsIgnoreCase("Y")) {
            // Remove the book from the appropriate list
            if (book instanceof BookPrinted) {
                booksPrinted.remove(book);
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
        for (Book book : booksPrinted) {
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
        for (Book book : booksPrinted) {
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

    private static void displayBooks() {
        if (BookManager.books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        System.out.printf("| %-4s | %-25s | %-20s | %-7s |%n", "ID", "Title", "Author", "Price");
        System.out.println("+------+---------------------------+----------------------+---------+");
        for (Book book : books) {
            System.out.printf("| %-4d | %-25s | %-20s | $%-6.2f |%n",
                    book.getId(), book.getTitle(), book.getAuthor(), book.getPrice());
        }
        System.out.println("+------+---------------------------+----------------------+---------+");
    }
}
