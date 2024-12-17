package ie.atu.bookapp;
import java.util.ArrayList;
import java.util.List;

public class Find {

    // Method to find a book by its ID
    public static Book findBookById(String bookId) {
        // Convert the bookId string to an integer
        int id = Integer.parseInt(bookId);
    
        // Search for the book in the printed books list
        for (Book book : Manager.getPrintedBooks()) {
            if (book.getId() == id) return book;
        }
        // Search for the book in the ebooks list
        for (Book book : Manager.getEbooks()) {
            if (book.getId() == id) return book;
        }
        // Search for the book in the audiobooks list
        for (Book book : Manager.getAudiobooks()) {
            if (book.getId() == id) return book;
        }
    
        return null; // Return null if no book is found with the given ID
    }
    
    // Method to find books by their title
    public static List<Book> findBooksByTitle(String title) {
        List<Book> matchingBooks = new ArrayList<>();
    
        // Search for books with the given title in printed books list
        for (Book book : Manager.getPrintedBooks()) {
            if (book.getTitle().equalsIgnoreCase(title)) matchingBooks.add(book);
        }
        // Search for books with the given title in ebooks list
        for (Book book : Manager.getEbooks()) {
            if (book.getTitle().equalsIgnoreCase(title)) matchingBooks.add(book);
        }
        // Search for books with the given title in audiobooks list
        for (Book book : Manager.getAudiobooks()) {
            if (book.getTitle().equalsIgnoreCase(title)) matchingBooks.add(book);
        }
        return matchingBooks; // Return a list of books matching the title
    }

    // Method to allow the user to find a book by title
    public static void findBookByTitle() {
        Navigation.setCurrentPage("findByTitle"); // Set current page in navigation
        Navigation.setPreviousPage("findBook"); // Set previous page in navigation
        ClearConsole.clearConsole(); // Clear the console for a clean display

        // If there are no books, inform the user and show the side menu
        if (Manager.getAllBooks().isEmpty()) {
            System.out.println("No books available.");
            Navigation.sideMenu();
            Navigation.handleChoice();
        }

        while (true) {
            // Prompt the user to enter a book title
            System.out.print("Enter Book Title: ");
            String title = App.scanner.nextLine();

            // Find books with the given title
            List<Book> matchingBooks = findBooksByTitle(title);

            // If books are found, display them
            if (!matchingBooks.isEmpty()) {
                System.out.println("Found result(s):");
                for (int i = 0; i < matchingBooks.size(); i++) {
                    System.out.println(matchingBooks.get(i));
                }

                Navigation.sideMenu(); // Show the side menu
                Navigation.handleChoice(); // Handle the user's menu choice
                return; // Exit the method after displaying the results
            } else {
                // If no books are found, prompt the user to try again or exit
                System.out.println("No books found with the given name.");
                System.out.println("Do you want to try again?");
                System.out.println("--------------");
                System.out.print("Y / N: ");
                String choice = App.scanner.nextLine();
                // If the user chooses not to retry, go back to the previous page
                if (choice.equalsIgnoreCase("n") || choice.equalsIgnoreCase("no")) {
                    Navigation.moveTo(Navigation.getPreviousPage());
                    break; // Exit the loop
                }
            }
        }
    }

    // Method to allow the user to find a book by its ID
    public static void findBookById() {
        Navigation.setCurrentPage("findById"); // Set current page in navigation
        Navigation.setPreviousPage("findBook"); // Set previous page in navigation
        ClearConsole.clearConsole(); // Clear the console for a clean display

        // If there are no books, inform the user and show the side menu
        if (Manager.getAllBooks().isEmpty()) {
            System.out.println("No books available.");
            Navigation.sideMenu();
            Navigation.handleChoice();
        }
        
        while (true) {
            // Prompt the user to enter a book ID
            System.out.print("Enter Book ID: ");
            String bookId = App.scanner.nextLine().trim();

            // Validate that the input is not empty
            if (bookId.isEmpty()) {
                System.out.println("Book ID cannot be empty. Please try again.\n");
                continue; // Restart the loop if input is empty
            }

            // Check if the entered ID is a number
            if (!bookId.matches("\\d+")) {
                System.out.println("Invalid Book ID. Please enter numbers only.\n");
                continue; // Restart the loop if input is not a valid number
            }

            // Find the book by its ID
            Book book = findBookById(bookId);
            if (book != null) {
                // If the book is found, display the result
                System.out.println("Found result");
                System.out.println(book);
                
                Navigation.sideMenu(); // Show the side menu
                Navigation.handleChoice(); // Handle the user's menu choice
                return; // Exit after displaying the result
            } else {
                // If no book is found, prompt the user to try again or exit
                System.out.println("No book found with the given ID.");
                System.out.println("Do you want to try again?");
                System.out.println("--------------");
                System.out.print("Y / N: ");
                String choice = App.scanner.nextLine().trim();

                // Validate user input for retry confirmation
                if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")) {
                    continue; // Retry entering a Book ID
                } else if (choice.equalsIgnoreCase("n") || choice.equalsIgnoreCase("no")) {
                    Navigation.moveTo(Navigation.getPreviousPage()); // Go back to the previous page
                    return; // Exit the method and navigate back
                } else {
                    System.out.println("Invalid choice. Returning to the previous menu.");
                    Navigation.moveTo(Navigation.getPreviousPage()); // Go back to the previous page
                    return; // Exit the method with invalid input handling
                }
            }
        }
    }
}
