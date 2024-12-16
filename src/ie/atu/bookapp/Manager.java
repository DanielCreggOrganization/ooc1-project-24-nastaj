package ie.atu.bookapp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Manager {
    // Because the size of the arrays are not known at the start of the program, they should be getting resized dynamically.
    // ArrayList is perfect for that. It makes the CRUD operations on arrays much easier.
    private static ArrayList<Book> books;
    private static ArrayList <PrintedBook> printedBooks;
    private static ArrayList<Ebook> ebooks;
    private static ArrayList <Audiobook> audiobooks;

    Manager() {
        Manager.books = new ArrayList<>();
        Manager.printedBooks = new ArrayList<>();
        Manager.ebooks = new ArrayList<>();
        Manager.audiobooks = new ArrayList<>();
    }

    public static void printMenu() {
        Navigation.setCurrentPage("manager");
        Navigation.setPreviousPage("main");
        ClearConsole.clearConsole();

        System.out.println();
        System.out.println("============ Book Manager ============");
        System.out.println("(1) Add a Book");
        System.out.println("(2) Update a Book");
        System.out.println("(3) Remove a Book");
        System.out.println("(4) Find a Book");
        System.out.println("(5) Show Books");
        Navigation.sideMenu();

        String choice = Navigation.handleChoice();
        
        switch(choice) {
            // TODO: All choices for this menu
            case "1": 
                Manager.printAddBookMenu();
                break;
            case "2": 
                Manager.printUpdateBookMenu();
                break;
            case "3": 
                Manager.printRemoveBookMenu();
                break;
            case "4": 
                Manager.printFindBookMenu();
                break;
            case "5": 
                Manager.printShowBooksMenu();
                break;
        }
    }

    public static void populateBooks() {
        // Adding printedBooks (Physical Books)
        printedBooks.add(new PrintedBook("The Odyssey", "Homer", 17.99, 800, 450));
        printedBooks.add(new PrintedBook("Brave New World", "Aldous Huxley", 19.99, 1932, 268));
        printedBooks.add(new PrintedBook("The Brothers Karamazov", "Fyodor Dostoevsky", 22.99, 1880, 350));

        // Adding Ebooks
        ebooks.add(new Ebook("Sapiens", "Yuval Noah Harari", 9.99, 2011, 5.5, "EPUB"));
        ebooks.add(new Ebook("Effective Java", "Joshua Bloch", 8.99, 2018, 3.2, "PDF"));
        ebooks.add(new Ebook("Becoming", "Michelle Obama", 12.99, 2018, 6.8, "EPUB"));
        ebooks.add(new Ebook("Educated", "Tara Westover", 10.99, 2018, 4.5, "PDF"));
        ebooks.add(new Ebook("The Silent Patient", "Alex Michaelides", 6.99, 2019, 2.8, "EPUB"));

        // Adding Audiobooks
        audiobooks.add(new Audiobook("The Night Circus", "Erin Morgenstern", 25.99, 2011, 12, "Jim Dale"));
        audiobooks.add(new Audiobook("Dune", "Frank Herbert", 29.99, 1965, 21, "Simon Vance"));
        audiobooks.add(new Audiobook("The Goldfinch", "Donna Tartt", 24.99, 2013, 32, "David Pittu"));
        audiobooks.add(new Audiobook("Becoming", "Michelle Obama", 24.99, 2018, 19, "Michelle Obama"));
        audiobooks.add(new Audiobook("The Alchemist", "Paulo Coelho", 14.99, 1988, 7, "Jeremy Irons"));

         // Adding all books to the general 'books' ArrayList
         books.addAll(printedBooks);  // Add all printedBooks to books
         books.addAll(ebooks);        // Add all ebooks to books
         books.addAll(audiobooks);    // Add all audiobooks to books
    }

    public static ArrayList<PrintedBook> getPrintedBooks() {
        return Manager.printedBooks;
    }
    
    public static ArrayList<Ebook> getEbooks() {
        return Manager.ebooks;
    }

    public static ArrayList<Audiobook> getAudiobooks() {
        return Manager.audiobooks;
    } 

    public static ArrayList<Book> getAllBooks() {
        return Manager.books;
    }
}
