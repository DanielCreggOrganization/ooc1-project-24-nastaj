package ie.atu.bookapp;

import java.util.ArrayList;
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
}
