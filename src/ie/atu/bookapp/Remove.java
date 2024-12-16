package ie.atu.bookapp;

import java.util.List;

public class Remove {
    private static void removeBookById() {
        Navigation.setCurrentPage("removeById");
        Navigation.setPreviousPage("removeBook");
        ClearConsole.clearConsole();

        if (Manager.books.isEmpty()) {
            Navigation.sideMenu();
            Navigation.handleChoice();
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

        if (Manager.books.isEmpty()) {
            Navigation.sideMenu();
            Navigation.handleChoice();
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


}
