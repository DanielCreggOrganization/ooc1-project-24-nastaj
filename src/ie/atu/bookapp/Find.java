package ie.atu.bookapp;
import java.util.ArrayList;
import java.util.List;

public class Find {
    public static Book findBookById(String bookId) {
        // Convert bookId string to int
        int id = Integer.parseInt(bookId);
    
        // Search in all categories for a book with the given ID
        for (Book book : Manager.getPrintedBooks()) {
            if (book.getId() == id) return book;
        }
        for (Book book : Manager.getEbooks()) {
            if (book.getId() == id) return book;
        }
        for (Book book : Manager.getAudiobooks()) {
            if (book.getId() == id) return book;
        }
    
        return null; // No book found
    }
    
    public static List<Book> findBooksByTitle(String title) {
        List<Book> matchingBooks = new ArrayList<>();
    
        // Search in all categories for books with the given name
        for (Book book : Manager.getPrintedBooks()) {
            if (book.getTitle().equalsIgnoreCase(title)) matchingBooks.add(book);
        }
        for (Book book : Manager.getEbooks()) {
            if (book.getTitle().equalsIgnoreCase(title)) matchingBooks.add(book);
        }
        for (Book book : Manager.getAudiobooks()) {
            if (book.getTitle().equalsIgnoreCase(title)) matchingBooks.add(book);
        }
        return matchingBooks;
    }

    public static void findBookByTitle() {
        Navigation.setCurrentPage("findByTitle");
        Navigation.setPreviousPage("findBook");
        ClearConsole.clearConsole();

        if (Manager.getAllBooks().isEmpty()) {
            System.out.println("No books available.");
            Navigation.sideMenu();
            Navigation.handleChoice();
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
                Navigation.handleChoice();

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

    public static void findBookById() {
        Navigation.setCurrentPage("findById");
        Navigation.setPreviousPage("findBook");
        ClearConsole.clearConsole();

        if (Manager.getAllBooks().isEmpty()) {
            System.out.println("No books available.");
            Navigation.sideMenu();
            Navigation.handleChoice();
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
                    Navigation.handleChoice();

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
}