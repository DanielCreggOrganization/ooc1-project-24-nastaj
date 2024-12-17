package ie.atu.bookapp;

import java.util.ArrayList;
import java.util.Comparator;

public class Statistics {
    public static void printMenu() {
        Navigation.setCurrentPage("stats");
        Navigation.setPreviousPage("main");
        ClearConsole.clearConsole();

        System.out.println();
        System.out.println("============ Statistics ============");
        System.out.println("What details do you want to view?");
        System.out.println("(1) All");
        System.out.println("(2) Printed Books");
        System.out.println("(3) Ebooks");
        System.out.println("(4) Audiobooks");
        Navigation.sideMenu();

        System.out.print("Enter your choice: ");

        String choice = App.scanner.nextLine();

        Navigation.sideMenu(choice);
        
        switch(choice) {
            case "1": 
                Statistics.printStatsAll();
                break;
            case "2": 
                Statistics.printStatsPrinted();
                break;
            case "3": 
                Statistics.printStatsEbook();;
                break;
            case "4": 
                Statistics.printStatsAudiobook();
                break;
        }

        Navigation.sideMenu();
        System.out.print("Enter your choice: ");
        choice = App.scanner.nextLine();
        Navigation.sideMenu(choice);
    }

    private static void printStatsPrinted() {
        Navigation.setCurrentPage("statsPrinted");
        Navigation.setPreviousPage("stats");
        ClearConsole.clearConsole();

        StringBuilder sb = new StringBuilder();
        PrintedBook maxPrinted = getPrintedStats("maxPrice");
        PrintedBook minPrinted = getPrintedStats("minPrice");
        PrintedBook longestBook = getPrintedStats("maxPages");
        PrintedBook shortestBook = getPrintedStats("minPages");

        System.out.println("============ Printed Details ============");
        sb.append("Total number of books: ");
        sb.append(getTotalBooks("Printed Book"));
        sb.append("\n");

        sb.append("Most expensive book: ");
        sb.append(maxPrinted.getTitle());
        sb.append(" by ");
        sb.append(maxPrinted.getAuthor());
        sb.append(" (");
        sb.append(maxPrinted.getPrice());
        sb.append("$)\n");

        sb.append("Least expensive book: ");
        sb.append(minPrinted.getTitle());
        sb.append(" by ");
        sb.append(minPrinted.getAuthor());
        sb.append(" (");
        sb.append(minPrinted.getPrice());
        sb.append("$)\n");

        sb.append("Average price of books: ");
        sb.append(getAveragePrice("Printed Book"));
        sb.append("$\n");

        sb.append("Longest book: ");
        sb.append(longestBook.getTitle());
        sb.append(" by ");
        sb.append(longestBook.getAuthor());
        sb.append(" (");
        sb.append(longestBook.getPageCount());
        sb.append(" pages)\n");

        sb.append("Shortest book: ");
        sb.append(shortestBook.getTitle());
        sb.append(" by ");
        sb.append(shortestBook.getAuthor());
        sb.append(" (");
        sb.append(shortestBook.getPageCount());
        sb.append(" pages)\n");

        System.out.println(sb.toString());
    }

    private static void printStatsEbook() {
        Navigation.setCurrentPage("statsEbook");
        Navigation.setPreviousPage("stats");
        ClearConsole.clearConsole();

        StringBuilder sb = new StringBuilder();
        Ebook maxEbook = getEbookStats("maxPrice");
        Ebook minEbook = getEbookStats("minPrice");
        Ebook largestEbook = getFileSizeStats("max");
        Ebook smallestEbook = getFileSizeStats("min");

        System.out.println("============ Ebook Details ============");
        sb.append("Total number of books: ");
        sb.append(getTotalBooks("Ebook"));
        sb.append("\n");

        sb.append("Most expensive ebook: ");
        sb.append(maxEbook.getTitle());
        sb.append(" by ");
        sb.append(maxEbook.getAuthor());
        sb.append(" (");
        sb.append(maxEbook.getPrice());
        sb.append("$)\n");

        sb.append("Least expensive ebook: ");
        sb.append(minEbook.getTitle());
        sb.append(" by ");
        sb.append(minEbook.getAuthor());
        sb.append(" (");
        sb.append(minEbook.getPrice());
        sb.append("$)\n");

        sb.append("Average price of ebooks: ");
        sb.append(getAveragePrice("Ebook"));
        sb.append("\n");

        sb.append("Largest ebook: ");
        sb.append(largestEbook.getTitle());
        sb.append(" by ");
        sb.append(largestEbook.getAuthor());
        sb.append(" (");
        sb.append(largestEbook.getFileSize());
        sb.append(" MB)\n");

        sb.append("Smallest ebook: ");
        sb.append(smallestEbook.getTitle());
        sb.append(" by ");
        sb.append(smallestEbook.getAuthor());
        sb.append(" (");
        sb.append(smallestEbook.getFileSize());
        sb.append(" MB)\n");

        System.out.println(sb.toString());
    }

    private static void printStatsAudiobook() {
        Navigation.setCurrentPage("statsAudiobook");
        Navigation.setPreviousPage("stats");
        ClearConsole.clearConsole();

        StringBuilder sb = new StringBuilder();
        Audiobook maxAudiobook = getAudiobookStats("maxPrice");
        Audiobook minAudiobook = getAudiobookStats("minPrice");
        Audiobook longestAudiobook = getAudiobookStats("longest");
        Audiobook shortestAudiobook = getAudiobookStats("shortest");

        System.out.println("============ Audiobook Details ============");
        sb.append("Total number of books: ");
        sb.append(getTotalBooks("Audiobook"));
        sb.append("\n");

        sb.append("Most expensive audiobook: ");
        sb.append(maxAudiobook.getTitle());
        sb.append(" by ");
        sb.append(maxAudiobook.getAuthor());
        sb.append(" (");
        sb.append(maxAudiobook.getPrice());
        sb.append("$)\n");

        sb.append("Least expensive audiobook: ");
        sb.append(minAudiobook.getTitle());
        sb.append(" by ");
        sb.append(minAudiobook.getAuthor());
        sb.append(" (");
        sb.append(minAudiobook.getPrice());
        sb.append("$)\n");

        sb.append("Average price of audiobooks: ");
        sb.append(getAveragePrice("Audiobook"));
        sb.append("\n");

        sb.append("Longest audiobook: ");
        sb.append(longestAudiobook.getTitle());
        sb.append(" by ");
        sb.append(longestAudiobook.getAuthor());
        sb.append(" (");
        sb.append(longestAudiobook.getPrice());
        sb.append("hrs)\n");

        sb.append("Shortest audiobook: ");
        sb.append(shortestAudiobook.getTitle());
        sb.append(" by ");
        sb.append(shortestAudiobook.getAuthor());
        sb.append(" (");
        sb.append(shortestAudiobook.getPrice());
        sb.append("hrs)\n");

        System.out.println(sb.toString());
    }

    private static void printStatsAll() {
        Navigation.setCurrentPage("statsAll");
        Navigation.setPreviousPage("stats");
        ClearConsole.clearConsole();

        StringBuilder sb = new StringBuilder();
        Book maxPrinted = getBookStats("maxPrice");
        Book minPrinted = getBookStats("minPrice");

        System.out.println("============ Overall Details ============");
        sb.append("Total number of books: ");
        sb.append(getTotalBooks("All"));
        sb.append("\n");

        sb.append("Most expensive book: ");
        sb.append(maxPrinted.getTitle());
        sb.append(" by ");
        sb.append(maxPrinted.getAuthor());
        sb.append(" (");
        sb.append(maxPrinted.getPrice());
        sb.append("$)\n");

        sb.append("Least expensive book: ");
        sb.append(minPrinted.getTitle());
        sb.append(" by ");
        sb.append(minPrinted.getAuthor());
        sb.append(" (");
        sb.append(minPrinted.getPrice());
        sb.append("$)\n");

        sb.append("Average price of books: ");
        sb.append(getAveragePrice("All"));
        sb.append("$\n");

        System.out.println(sb.toString());
    }

    public static int getTotalBooks(String type) {
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

    public static double getAveragePrice(String type) {
        double average = 0;

        if(type.equals("Printed Book")) {
            average = Manager.getPrintedBooks().stream()
            .mapToDouble(Book::getPrice) // Map each book to its price
            .average()                  // Calculate the average
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

        // Round to two decimal places
        return Math.round(average * 100.0) / 100.0;
    }

    public static PrintedBook getPrintedStats(String field) {
        ArrayList<PrintedBook> printedBooks = Manager.getPrintedBooks();

        if(field.equals("maxPrice")) {
            PrintedBook mostExpensive = printedBooks.stream()
            .max(Comparator.comparingDouble(PrintedBook::getPrice))
            .orElse(null); // orElse(null) returns null if the list is empty
            
            return mostExpensive; // Return the book
        }
        else if(field.equals("minPrice")) {
            PrintedBook leastExpensive = printedBooks.stream()
            .min(Comparator.comparingDouble(PrintedBook::getPrice))
            .orElse(null);
            
            return leastExpensive;
        }
        else if(field.equals("maxPages")) {
            PrintedBook longestBook =  printedBooks.stream()
            .max(Comparator.comparingInt(PrintedBook::getPageCount))
            .orElse(null);

            return longestBook;
        }
        else {
            PrintedBook shortestBook =  printedBooks.stream()
            .min(Comparator.comparingInt(PrintedBook::getPageCount))
            .orElse(null);

            return shortestBook;
        }
    }
    
    public static Ebook getEbookStats(String field) {
        ArrayList<Ebook> ebooks = Manager.getEbooks();

        if(field.equals("maxPrice")) {
            Ebook mostExpensive = ebooks.stream()
            .max(Comparator.comparingDouble(Ebook::getPrice))
            .orElse(null); // orElse(null) returns null if the list is empty
            
            return mostExpensive; // Return the book
        }
        else {
            Ebook leastExpensivePrinted = ebooks.stream()
            .min(Comparator.comparingDouble(Ebook::getPrice))
            .orElse(null); // orElse(null) returns null if the list is empty
            
            return leastExpensivePrinted; // Return the book
        }
    }

    public static Audiobook getAudiobookStats(String field) {
        ArrayList<Audiobook> audiobooks = Manager.getAudiobooks();

        if(field.equals("maxPrice")) {
            Audiobook mostExpensive = audiobooks.stream()
            .max(Comparator.comparingDouble(Audiobook::getPrice))
            .orElse(null); // orElse(null) returns null if the list is empty
            
            return mostExpensive; // Return the book
        }
        else if(field.equals("minPrice")) {
            Audiobook leastExpensivePrinted = audiobooks.stream()
            .min(Comparator.comparingDouble(Audiobook::getPrice))
            .orElse(null); // orElse(null) returns null if the list is empty
            
            return leastExpensivePrinted; // Return the book
        }
        else if(field.equals("longest")){
            Audiobook longestAudiobook = audiobooks.stream()
            .max(Comparator.comparingInt(Audiobook::getDuration))
            .orElse(null);
            
            return longestAudiobook;
        }
        else {
            Audiobook shortestAudiobook = audiobooks.stream()
            .min(Comparator.comparingInt(Audiobook::getDuration))
            .orElse(null);
            
            return shortestAudiobook;
        }
    }

    public static Book getBookStats(String field) {
        ArrayList<Book> Books = Manager.getAllBooks();

        if(field.equals("maxPrice")) {
            Book mostExpensive = Books.stream()
            .max(Comparator.comparingDouble(Book::getPrice))
            .orElse(null); // orElse(null) returns null if the list is empty
            
            return mostExpensive; // Return the book
        }
        else {
            Book leastExpensivePrinted = Books.stream()
            .min(Comparator.comparingDouble(Book::getPrice))
            .orElse(null); // orElse(null) returns null if the list is empty
            
            return leastExpensivePrinted; // Return the book
        }
    }

    public static Ebook getFileSizeStats(String field) {
        ArrayList<Ebook> ebooks = Manager.getEbooks();

        if(field.equals("max")) {
            Ebook largestFile = ebooks.stream()
            .max(Comparator.comparingDouble(Ebook::getFileSize))
            .orElse(null); // orElse(null) returns null if the list is empty
            
            return largestFile;
        }
        else {
            Ebook smallestFile = ebooks.stream()
            .min(Comparator.comparingDouble(Ebook::getFileSize))
            .orElse(null); // orElse(null) returns null if the list is empty
            
            return smallestFile;
        }
    }
}
