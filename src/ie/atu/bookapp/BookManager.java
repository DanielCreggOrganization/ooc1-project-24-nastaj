package ie.atu.bookapp;

import java.util.ArrayList;
import java.util.Scanner;

public class BookManager {
    // Because the size of the arrays are not known at the start of the program, they should be getting resized dynamically.
    // ArrayList is perfect for that. It makes the CRUD operations on arrays much easier.
    private static Scanner scanner = new Scanner(System.in);
    private ArrayList<Book> books;
    private static ArrayList <BookPrinted> booksPrinted;
    private static ArrayList<Ebook> ebooks;
    private static ArrayList <Audiobook> audiobooks;

    BookManager() {
        BookManager.booksPrinted = new ArrayList<>();
        BookManager.ebooks = new ArrayList<>();
        BookManager.audiobooks = new ArrayList<>();
    }

    // TODO: Getters and setters
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
            case "1": {
                BookManager.printAddBookMenu();
            }
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
            case "1":
            {
                Navigation.setCurrentPage("printedBook");
                Navigation.setPreviousPage("addBook");

                BookManager.printPrintedBookMenu();
            }

            case "2": {
                Navigation.setCurrentPage("ebook");
                Navigation.setPreviousPage("addBook");

                BookManager.printEbookMenu();
            }

            case "3": {
                Navigation.setCurrentPage("audiobook");
                Navigation.setPreviousPage("addBook");

                BookManager.printAudiobookMenu();
            }
        }
    }

    public static void printPrintedBookMenu() {
        String title;
        String author;
        double price;
        int publicationYear;
        int pageCount;
        String choice;

        ClearConsole.clearConsole();

        System.out.println("Enter details");
        System.out.println("=================");

        title = BookManager.promptTitle();
        author = BookManager.promptAuthor();
        price = BookManager.promptPrice();
        publicationYear = BookManager.promptPublicationYear();
        pageCount = BookManager.promptPageCount();
        
        System.out.println("==============");
        System.out.println("Is this correct?");
        System.out.println("--------------");
        System.out.print("Y / N: ");
        choice = scanner.nextLine();
        
        if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")) {
            BookPrinted bookPrinted = new BookPrinted(title, author, price, publicationYear, pageCount);
            BookManager.booksPrinted.add(bookPrinted);
        
            ClearConsole.clearConsole();
        
            System.out.println(booksPrinted);
            System.out.println("Book added successfully!");
            System.out.println("Add another book?");
        
            System.out.println("--------------");
            System.out.print("Y / N: ");
            choice = scanner.nextLine();
                    
            if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")) {
                // Prompt the user again
                BookManager.printPrintedBookMenu();
            }
                    
            else if (choice.equalsIgnoreCase("n") || choice.equalsIgnoreCase("no")) {
                Navigation.moveTo(Navigation.getPreviousPage());
            }
        
        }
        else if (choice.equalsIgnoreCase("n") || choice.equalsIgnoreCase("no")) {
            // Prompt the user again
            BookManager.printPrintedBookMenu();
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

        ClearConsole.clearConsole();

        System.out.println("Enter details");
        System.out.println("=================");

        title = BookManager.promptTitle();
        author = BookManager.promptAuthor();
        price = BookManager.promptPrice();
        publicationYear = BookManager.promptPublicationYear();
        fileSize = BookManager.promptFileSize();
        format = BookManager.promptFormat();

        
        System.out.println("==============");
        System.out.println("Is this correct?");
        System.out.println("--------------");
        System.out.print("Y / N: ");
        choice = scanner.nextLine();
        
        if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")) {
            Ebook ebook = new Ebook(title, author, price, publicationYear, fileSize, format);
            BookManager.ebooks.add(ebook);
        
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

        ClearConsole.clearConsole();

        System.out.println("Enter details");
        System.out.println("=================");

        title = BookManager.promptTitle();
        author = BookManager.promptAuthor();
        price = BookManager.promptPrice();
        publicationYear = BookManager.promptPublicationYear();
        duration = BookManager.promptDuration();
        narrator = BookManager.promptNarrator();

        
        System.out.println("==============");
        System.out.println("Is this correct?");
        System.out.println("--------------");
        System.out.print("Y / N: ");
        choice = scanner.nextLine();
        
        if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")) {
            Audiobook audiobook = new Audiobook(title, author, price, publicationYear, duration, narrator);
            BookManager.audiobooks.add(audiobook);
        
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
        
    public static String promptTitle() {
        String title;

        do {
            System.out.print("Title: ");
            title = scanner.nextLine();

            if (title.trim().isEmpty()) {
                System.out.println("Invalid input! Title cannot be empty.");
            }
        } while (title.trim().isEmpty());
            
        return title;
    }

    public static String promptAuthor() {
        String author;

        do {
            System.out.print("Author: ");
            author = scanner.nextLine();

            if (author.trim().isEmpty()) {
                System.out.println("Invalid input! Author cannot be empty.");
            }
            else if (!author.matches(".*[a-zA-Z]+.*")) {
                System.out.println("Invalid input! Author must contain letters.");
            }
        } while (author.trim().isEmpty() || !author.matches(".*[a-zA-Z]+.*"));
            
        return author;
    }

    public static double promptPrice() {
        double price;
    
        while (true) {
            System.out.print("Price: ");
    
            String input = scanner.nextLine(); // Read the input as a string first
    
            if (input.isEmpty()) { // Check if the input is empty
                System.out.println("Invalid input! Price cannot be empty.");
                continue; // Restart the loop
            }
    
            try {
                price = Double.parseDouble(input); // Attempt to parse the input as a double
                if (price >= 0) {
                    return price; // Valid non-negative price
                } else {
                    System.out.println("Invalid input! Price cannot be negative.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid price.");
            }
        }
    }

    public static int promptPublicationYear() {
        int publicationYear;
    
        while (true) {
            System.out.print("Publication Year: ");
    
            String input = scanner.nextLine(); // Read the input as a string first
    
            if (input.isEmpty()) { // Check if the input is empty
                System.out.println("Invalid input! publicationYear cannot be empty.");
                continue; // Restart the loop
            }
    
            try {
                publicationYear = Integer.parseInt(input); // Attempt to parse the input as an integer
                if (publicationYear >= 0) {
                    return publicationYear; // Valid non-negative publication year
                } else {
                    System.out.println("Invalid input! Publication year cannot be negative.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid publication year.");
            }
        }
    }

    public static int promptPageCount() {
        int pageCount;
    
        while (true) {
            System.out.print("Page Count: ");
    
            String input = scanner.nextLine(); // Read the input as a string first
    
            if (input.isEmpty()) { // Check if the input is empty
                System.out.println("Invalid input! Page count cannot be empty.");
                continue; // Restart the loop
            }
    
            try {
                pageCount = Integer.parseInt(input); // Attempt to parse the input as an integer
                if (pageCount >= 0) {
                    return pageCount; // Valid non-negative publication year
                } else {
                    System.out.println("Invalid input! Page count cannot be negative.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid page count.");
            }
        }
    }

    public static double promptFileSize() {
        double fileSize;
    
        while (true) {
            System.out.print("File Size (MB): ");
    
            String input = scanner.nextLine(); // Read the input as a string first
    
            if (input.isEmpty()) { // Check if the input is empty
                System.out.println("Invalid input! File size cannot be empty.");
                continue; // Restart the loop
            }
    
            try {
                fileSize = Double.parseDouble(input); // Attempt to parse the input as a double
                if (fileSize >= 0) {
                    return fileSize; // Valid non-negative file size
                } else {
                    System.out.println("Invalid input! File size cannot be negative.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid file size.");
            }
        }
    }

    public static String promptFormat() {
        String format;

        do {
            System.out.print("File Format: ");
            format = scanner.nextLine();

            if (format.trim().isEmpty()) {
                System.out.println("Invalid input! File format cannot be empty.");
            }
        } while (format.trim().isEmpty());
            
        return format;
    }

    public static int promptDuration() {
        int duration;
    
        while (true) {
            System.out.print("Duration: ");
    
            String input = scanner.nextLine(); // Read the input as a string first
    
            if (input.isEmpty()) { // Check if the input is empty
                System.out.println("Invalid input! Duration cannot be empty.");
                continue; // Restart the loop
            }
    
            try {
                duration = Integer.parseInt(input); // Attempt to parse the input as an integer
                if (duration >= 0) {
                    return duration; // Valid non-negative duration
                } else {
                    System.out.println("Invalid input! Duration cannot be negative.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid duration.");
            }
        }
    }

    public static String promptNarrator() {
        String narrator;

        do {
            System.out.print("Narrator: ");
            narrator = scanner.nextLine();

            if (narrator.trim().isEmpty()) {
                System.out.println("Invalid input! Narrator cannot be empty.");
            }
        } while (narrator.trim().isEmpty());
            
        return narrator;
    }
}
