package ie.atu.bookapp.features;

import java.util.List;

import ie.atu.bookapp.App;
import ie.atu.bookapp.classes.Audiobook;
import ie.atu.bookapp.classes.Book;
import ie.atu.bookapp.classes.Ebook;
import ie.atu.bookapp.classes.PrintedBook;
import ie.atu.bookapp.nav.Navigation;
import ie.atu.bookapp.utilities.ClearConsole;

public class Remove {

    /**
     * Removes a book by its ID after confirming the deletion.
     * The method repeatedly prompts the user for a valid Book ID until a valid one is provided.
     */
    public static void removeBookById() {
        Navigation.setCurrentPage("removeById");
        Navigation.setPreviousPage("removeBook");
        ClearConsole.clearConsole();

        // Check if there are any books in the system
        if (Manager.getAllBooks().isEmpty()) {
            Navigation.sideMenu();
            Navigation.handleChoice();
        }

        while (true) {
            // Prompt the user to enter a Book ID
            System.out.print("Enter Book ID to remove: ");
            String bookId = App.scanner.nextLine().trim();

            // Validate that the input is not empty
            if (bookId.isEmpty()) {
                System.out.println("Book ID cannot be empty. Please try again.\n");
                continue; // Restart the loop if input is empty
            }

            // Ensure the input contains only numeric characters
            if (!bookId.matches("\\d+")) {
                System.out.println("Invalid Book ID. Please enter numbers only.\n");
                continue; // Restart the loop if the input is not numeric
            }

            // Find the book by ID
            Book book = Find.findBookById(bookId);
            if (book != null) {
                // Proceed to confirm and delete the book
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

    /**
     * Removes a book by its title after confirming the deletion.
     * Displays a list of matching books and allows the user to choose one to delete.
     */
    public static void removeBookByTitle() {
        Navigation.setCurrentPage("removeByTitle");
        Navigation.setPreviousPage("removeBook");
        ClearConsole.clearConsole();

        // Check if there are any books in the system
        if (Manager.getAllBooks().isEmpty()) {
            Navigation.sideMenu();
            Navigation.handleChoice();
        }

        while (true) {
            // Prompt the user to enter a Book Title
            System.out.print("Enter Book Title to Remove: ");
            String title = App.scanner.nextLine();

            // Find books matching the title
            List<Book> matchingBooks = Find.findBooksByTitle(title);

            // If books are found, display them and allow the user to select one
            if (!matchingBooks.isEmpty()) {
                System.out.println("Matching Books:");

                for (int i = 0; i < matchingBooks.size(); i++) {
                    System.out.println((i + 1) + ". " + matchingBooks.get(i));
                }

                System.out.print("Which book do you want to delete?: ");
                String choice = App.scanner.nextLine();
                int index = Integer.parseInt(choice) - 1;

                // Validate the selected book index and delete if valid
                if (index >= 0 && index < matchingBooks.size()) {
                    confirmAndDelete(matchingBooks.get(index));
                    break; // Exit the loop after successful deletion
                } else {
                    System.out.println("Invalid selection.");
                }
            } else {
                // If no books match the title, ask if the user wants to try again
                System.out.println("No books found with the given name.");
                System.out.println("Do you want to try again?");
                System.out.println("--------------");
                System.out.print("Y / N: ");
                String choice = App.scanner.nextLine();
                if (choice.equalsIgnoreCase("n") || choice.equalsIgnoreCase("no")) {
                    Navigation.moveTo(Navigation.getPreviousPage());
                    break; // Exit the loop and return to the previous page
                }
            }
        }
    }

    /**
     * Confirms the deletion of the specified book and removes it from the relevant list.
     * 
     * @param book The book to be deleted.
     */
    public static void confirmAndDelete(Book book) {
        // Display the book details for confirmation
        System.out.println(book + "\n");
        System.out.println("Are you sure you want to delete the following book?\n");
        System.out.print("Y / N: ");

        // Get the user's confirmation for deletion
        String confirmation = App.scanner.nextLine();

        if (confirmation.equalsIgnoreCase("y") || confirmation.equalsIgnoreCase("yes")) {
            // Remove the book from the appropriate list (PrintedBook, Ebook, or Audiobook)
            if (book instanceof PrintedBook) {
                Manager.getPrintedBooks().remove(book);
            } else if (book instanceof Ebook) {
                Manager.getEbooks().remove(book);
            } else if (book instanceof Audiobook) {
                Manager.getAudiobooks().remove(book);
            }
            Manager.getAllBooks().remove(book); // Remove from the all-books list
            System.out.println("Book deleted successfully!");
        } else {
            System.out.println("Book deletion cancelled.");
        }
        Navigation.moveTo(Navigation.getPreviousPage()); // Navigate back to the previous page
    }
}
