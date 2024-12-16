package ie.atu.bookapp;

public class Display {
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

    private static void displayBooks(String type, String sortBy, int results) {
        // Check the type and display the appropriate list
        System.out.println(type);
        if (type.equals("printed")) {
            if (Manager.printedBooks.isEmpty()) {
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
            if (Manager.ebooks.isEmpty()) {
                System.out.println("No ebooks available.");
                return;
            }

            // Apply sorting
            sortEbooks(sortBy);

            System.out.println("Number of Ebooks in library: " + results);
            System.out.printf("| %-4s | %-25s | %-20s | %-7s | %-6s | %-8s |%n", "ID", "Title", "Author", "Price", "Size", "Format");
            System.out.println("+------+---------------------------+----------------------+---------+--------+----------+");
            for (Ebook ebook : Manager.ebooks) {
                System.out.printf("| %-4d | %-25s | %-20s | $%-6.2f | %-6.1f MB | %-8s |%n",
                        ebook.getId(), ebook.getTitle(), ebook.getAuthor(), ebook.getPrice(), ebook.getFileSize(), ebook.getFormat());
            }
            System.out.println("+------+---------------------------+----------------------+---------+--------+----------+");
    
        } else if (type.equalsIgnoreCase("audiobooks")) {
            if (Manager.audiobooks.isEmpty()) {
                System.out.println("No audiobooks available.");
                return;
            }

            // Apply sorting
            sortAudiobooks(sortBy);

            System.out.println("Number of Audiobooks in library: " + results);
            System.out.printf("| %-4s | %-25s | %-20s | %-7s | %-6s | %-15s |%n", "ID", "Title", "Author", "Price", "Duration", "Narrator");
            System.out.println("+------+---------------------------+----------------------+---------+--------+-----------------+");
            for (Audiobook audiobook : Manager.audiobooks) {
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
        if (Manager.books.isEmpty()) {
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
        for (Book book : Manager.books) {
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
}
