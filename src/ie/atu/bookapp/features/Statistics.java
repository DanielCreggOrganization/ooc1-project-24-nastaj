package ie.atu.bookapp.features;

import java.util.ArrayList;
import java.util.Comparator;

import ie.atu.bookapp.App;
import ie.atu.bookapp.classes.Audiobook;
import ie.atu.bookapp.classes.Book;
import ie.atu.bookapp.classes.Ebook;
import ie.atu.bookapp.classes.PrintedBook;
import ie.atu.bookapp.nav.Navigation;
import ie.atu.bookapp.utilities.ClearConsole;

public class Statistics {

    /**
     * Displays the statistics menu and handles user input for viewing statistics of different book types.
     */
    public static void printMenu() {
        // Set the current and previous page for navigation
        Navigation.setCurrentPage("stats");
        Navigation.setPreviousPage("main");

        // Clear the console screen
        ClearConsole.clearConsole();

        // Display the menu options
        System.out.println("============ Statistics ============");
        System.out.println("What details do you want to view?");
        System.out.println("(1) All");
        System.out.println("(2) Printed Books");
        System.out.println("(3) Ebooks");
        System.out.println("(4) Audiobooks");

        // Display the side menu for navigation
        Navigation.sideMenu();

        // Prompt the user for a choice
        System.out.print("Enter your choice: ");
        String choice = App.scanner.nextLine();

        // Handle user input to navigate to the appropriate statistics section
        Navigation.sideMenu(choice);
        
        switch(choice) {
            case "1": 
                printStatsAll();
                break;
            case "2": 
                printStatsPrinted();
                break;
            case "3": 
                printStatsEbook();
                break;
            case "4": 
                printStatsAudiobook();
                break;
        }

        // Display the side menu again after displaying the statistics
        Navigation.sideMenu();
        System.out.print("Enter your choice: ");
        choice = App.scanner.nextLine();
        Navigation.sideMenu(choice);
    }

    /**
     * Prints statistics for printed books.
     */
    private static void printStatsPrinted() {
        Navigation.setCurrentPage("statsPrinted");
        Navigation.setPreviousPage("stats");
        ClearConsole.clearConsole();

        StringBuilder sb = new StringBuilder();
        PrintedBook maxPrinted = getPrintedStats("maxPrice");
        PrintedBook minPrinted = getPrintedStats("minPrice");
        PrintedBook longestBook = getPrintedStats("maxPages");
        PrintedBook shortestBook = getPrintedStats("minPages");

        // Print detailed statistics for printed books
        System.out.println("============ Printed Details ============");
        sb.append("Total number of books: ").append(getTotalBooks("Printed Book")).append("\n");
        sb.append("Most expensive book: ").append(maxPrinted.getTitle())
          .append(" by ").append(maxPrinted.getAuthor()).append(" (")
          .append(maxPrinted.getPrice()).append("$)\n");
        sb.append("Least expensive book: ").append(minPrinted.getTitle())
          .append(" by ").append(minPrinted.getAuthor()).append(" (")
          .append(minPrinted.getPrice()).append("$)\n");
        sb.append("Average price of books: ").append(getAveragePrice("Printed Book")).append("$\n");
        sb.append("Longest book: ").append(longestBook.getTitle())
          .append(" by ").append(longestBook.getAuthor()).append(" (")
          .append(longestBook.getPageCount()).append(" pages)\n");
        sb.append("Shortest book: ").append(shortestBook.getTitle())
          .append(" by ").append(shortestBook.getAuthor()).append(" (")
          .append(shortestBook.getPageCount()).append(" pages)\n");

        // Output the statistics
        System.out.println(sb.toString());
    }

    /**
     * Prints statistics for ebooks.
     */
    private static void printStatsEbook() {
        Navigation.setCurrentPage("statsEbook");
        Navigation.setPreviousPage("stats");
        ClearConsole.clearConsole();

        StringBuilder sb = new StringBuilder();
        Ebook maxEbook = getEbookStats("maxPrice");
        Ebook minEbook = getEbookStats("minPrice");
        Ebook largestEbook = getEbookStats("maxSize");
        Ebook smallestEbook = getEbookStats("minSize");

        // Print detailed statistics for ebooks
        System.out.println("============ Ebook Details ============");
        sb.append("Total number of books: ").append(getTotalBooks("Ebook")).append("\n");
        sb.append("Most expensive ebook: ").append(maxEbook.getTitle())
          .append(" by ").append(maxEbook.getAuthor()).append(" (")
          .append(maxEbook.getPrice()).append("$)\n");
        sb.append("Least expensive ebook: ").append(minEbook.getTitle())
          .append(" by ").append(minEbook.getAuthor()).append(" (")
          .append(minEbook.getPrice()).append("$)\n");
        sb.append("Average price of ebooks: ").append(getAveragePrice("Ebook")).append("\n");
        sb.append("Largest ebook: ").append(largestEbook.getTitle())
          .append(" by ").append(largestEbook.getAuthor()).append(" (")
          .append(largestEbook.getFileSize()).append(" MB)\n");
        sb.append("Smallest ebook: ").append(smallestEbook.getTitle())
          .append(" by ").append(smallestEbook.getAuthor()).append(" (")
          .append(smallestEbook.getFileSize()).append(" MB)\n");

        // Output the statistics
        System.out.println(sb.toString());
    }

    /**
     * Prints statistics for audiobooks.
     */
    private static void printStatsAudiobook() {
        Navigation.setCurrentPage("statsAudiobook");
        Navigation.setPreviousPage("stats");
        ClearConsole.clearConsole();

        StringBuilder sb = new StringBuilder();
        Audiobook maxAudiobook = getAudiobookStats("maxPrice");
        Audiobook minAudiobook = getAudiobookStats("minPrice");
        Audiobook longestAudiobook = getAudiobookStats("longest");
        Audiobook shortestAudiobook = getAudiobookStats("shortest");

        // Print detailed statistics for audiobooks
        System.out.println("============ Audiobook Details ============");
        sb.append("Total number of books: ").append(getTotalBooks("Audiobook")).append("\n");
        sb.append("Most expensive audiobook: ").append(maxAudiobook.getTitle())
          .append(" by ").append(maxAudiobook.getAuthor()).append(" (")
          .append(maxAudiobook.getPrice()).append("$)\n");
        sb.append("Least expensive audiobook: ").append(minAudiobook.getTitle())
          .append(" by ").append(minAudiobook.getAuthor()).append(" (")
          .append(minAudiobook.getPrice()).append("$)\n");
        sb.append("Average price of audiobooks: ").append(getAveragePrice("Audiobook")).append("\n");
        sb.append("Longest audiobook: ").append(longestAudiobook.getTitle())
          .append(" by ").append(longestAudiobook.getAuthor()).append(" (")
          .append(longestAudiobook.getPrice()).append("hrs)\n");
        sb.append("Shortest audiobook: ").append(shortestAudiobook.getTitle())
          .append(" by ").append(shortestAudiobook.getAuthor()).append(" (")
          .append(shortestAudiobook.getPrice()).append("hrs)\n");

        // Output the statistics
        System.out.println(sb.toString());
    }

    /**
     * Prints overall statistics for all books.
     */
    private static void printStatsAll() {
        Navigation.setCurrentPage("statsAll");
        Navigation.setPreviousPage("stats");
        ClearConsole.clearConsole();

        StringBuilder sb = new StringBuilder();
        Book maxPrinted = getBookStats("maxPrice");
        Book minPrinted = getBookStats("minPrice");

        // Print overall statistics for all books
        System.out.println("============ Overall Details ============");
        sb.append("Total number of books: ").append(getTotalBooks("All")).append("\n");
        sb.append("Most expensive book: ").append(maxPrinted.getTitle())
          .append(" by ").append(maxPrinted.getAuthor()).append(" (")
          .append(maxPrinted.getPrice()).append("$)\n");
        sb.append("Least expensive book: ").append(minPrinted.getTitle())
          .append(" by ").append(minPrinted.getAuthor()).append(" (")
          .append(minPrinted.getPrice()).append("$)\n");
        sb.append("Average price of books: ").append(getAveragePrice("All")).append("$\n");

        // Output the statistics
        System.out.println(sb.toString());
    }

    /**
     * Returns the total number of books for a given type (Printed Book, Ebook, Audiobook, or All).
     */
    public static int getTotalBooks(String type) {
        // Return the size of the corresponding book list
        if(type.equals("Printed Book")) {
            return Manager.getPrintedBooks().size();
        }
        else if(type.equals("Ebook")) {
            return Manager.getEbooks().size();
        }
        else if(type.equals("Audiobook")) {
            return Manager.getAudiobooks().size();
        }
        else {
            return Manager.getAllBooks().size();
        }
    }

    /**
     * Returns the average price of books for a given type.
     */
    public static double getAveragePrice(String type) {
        double average = 0;

        // Calculate the average price for the corresponding book list
        if(type.equals("Printed Book")) {
            average = Manager.getPrintedBooks().stream()
            .mapToDouble(Book::getPrice)
            .average()
            .orElse(0.0);     
        }
        else if (type.equals("Ebook")) {
            average = Manager.getEbooks().stream().mapToDouble(Book::getPrice).average().orElse(0.0);  
        }
        else if (type.equals("Audiobook")) {
            average = Manager.getAudiobooks().stream().mapToDouble(Book::getPrice).average().orElse(0.0);  
        }
        else {
            average = Manager.getAllBooks().stream().mapToDouble(Book::getPrice).average().orElse(0.0); 
        }

        // Return the rounded average price
        return Math.round(average * 100.0) / 100.0;
    }

    /**
     * Returns the book with the specified field for printed books (e.g., max price, min price, max pages, min pages).
     */
    public static PrintedBook getPrintedStats(String field) {
        ArrayList<PrintedBook> printedBooks = Manager.getPrintedBooks();

        if(field.equals("maxPrice")) {
            return printedBooks.stream()
                    .max(Comparator.comparingDouble(PrintedBook::getPrice))
                    .orElse(null); 
        }
        else if(field.equals("minPrice")) {
            return printedBooks.stream()
                    .min(Comparator.comparingDouble(PrintedBook::getPrice))
                    .orElse(null);
        }
        else if(field.equals("maxPages")) {
            return printedBooks.stream()
                    .max(Comparator.comparingInt(PrintedBook::getPageCount))
                    .orElse(null);
        }
        else if(field.equals("minPages")) {
            return printedBooks.stream()
                    .min(Comparator.comparingInt(PrintedBook::getPageCount))
                    .orElse(null);
        }
        return null;
    }

    /**
     * Returns the book with the specified field for ebooks (e.g., max price, min price, largest file size, smallest file size).
     */
    public static Ebook getEbookStats(String field) {
        ArrayList<Ebook> ebooks = Manager.getEbooks();

        if(field.equals("maxPrice")) {
            return ebooks.stream()
                    .max(Comparator.comparingDouble(Ebook::getPrice))
                    .orElse(null); 
        }
        else if(field.equals("minPrice")) {
            return ebooks.stream()
                    .min(Comparator.comparingDouble(Ebook::getPrice))
                    .orElse(null);
        }
        else if(field.equals("maxSize")) {
            return ebooks.stream()
                    .max(Comparator.comparingDouble(Ebook::getFileSize))
                    .orElse(null);
        }
        else if(field.equals("minSize")) {
            return ebooks.stream()
                    .min(Comparator.comparingDouble(Ebook::getFileSize))
                    .orElse(null);
        }
        return null;
    }

    /**
     * Returns the book with the specified field for audiobooks (e.g., max price, min price, longest, shortest).
     */
    public static Audiobook getAudiobookStats(String field) {
        ArrayList<Audiobook> audiobooks = Manager.getAudiobooks();

        if(field.equals("maxPrice")) {
            return audiobooks.stream()
                    .max(Comparator.comparingDouble(Audiobook::getPrice))
                    .orElse(null); 
        }
        else if(field.equals("minPrice")) {
            return audiobooks.stream()
                    .min(Comparator.comparingDouble(Audiobook::getPrice))
                    .orElse(null);
        }
        else if(field.equals("longest")) {
            return audiobooks.stream()
                    .max(Comparator.comparingDouble(Audiobook::getDuration))
                    .orElse(null);
        }
        else if(field.equals("shortest")) {
            return audiobooks.stream()
                    .min(Comparator.comparingDouble(Audiobook::getDuration))
                    .orElse(null);
        }
        return null;
    }

    /**
     * Returns the book with the specified field for all books (e.g., max price, min price).
     */
    public static Book getBookStats(String field) {
        ArrayList<Book> allBooks = Manager.getAllBooks();

        if(field.equals("maxPrice")) {
            return allBooks.stream()
                    .max(Comparator.comparingDouble(Book::getPrice))
                    .orElse(null); 
        }
        else if(field.equals("minPrice")) {
            return allBooks.stream()
                    .min(Comparator.comparingDouble(Book::getPrice))
                    .orElse(null);
        }
        return null;
    }
}
