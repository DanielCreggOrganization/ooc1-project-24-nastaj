package ie.atu.bookapp.features;

import java.util.ArrayList;

import ie.atu.bookapp.classes.Audiobook;
import ie.atu.bookapp.classes.Book;
import ie.atu.bookapp.classes.Ebook;
import ie.atu.bookapp.classes.PrintedBook;
import ie.atu.bookapp.nav.Menu;
import ie.atu.bookapp.nav.Navigation;
import ie.atu.bookapp.utilities.ClearConsole;

/**
 * The Manager class handles book management, including adding, updating, removing, and displaying books.
 * It contains the main logic for managing different types of books in the system.
 */
public class Manager {

    // ArrayLists to store different types of books: printed books, ebooks, and audiobooks.
    // Because the size of the arrays are not known at the start of the program, they should be getting resized dynamically.
    // ArrayList is perfect for that. It makes the CRUD operations on arrays much easier.
    private static ArrayList<Book> books;
    private static ArrayList<PrintedBook> printedBooks;
    private static ArrayList<Ebook> ebooks;
    private static ArrayList<Audiobook> audiobooks;

    /**
     * Constructor initializes the ArrayLists for managing different types of books.
     */
    public Manager() {
        Manager.books = new ArrayList<>();
        Manager.printedBooks = new ArrayList<>();
        Manager.ebooks = new ArrayList<>();
        Manager.audiobooks = new ArrayList<>();
    }

    /**
     * Displays the book management menu with options to add, update, remove, find, or show books.
     */
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

        // Handle user input choice and navigate to the corresponding menu
        String choice = Navigation.handleChoice();
        
        switch(choice) {
            case "1": 
                Menu.printAddBookMenu();
                break;
            case "2": 
                Menu.printUpdateBookMenu();
                break;
            case "3": 
                Menu.printRemoveBookMenu();
                break;
            case "4": 
                Menu.printFindBookMenu();
                break;
            case "5": 
                Menu.printShowBooksMenu();
                break;
            default:
                printMenu(); // Invalid input, re-display the menu
        }
    }

    /**
     * Returns the list of printed books.
     * @return ArrayList of PrintedBook objects
     */
    public static ArrayList<PrintedBook> getPrintedBooks() {
        return Manager.printedBooks;
    }
    
    /**
     * Returns the list of ebooks.
     * @return ArrayList of Ebook objects
     */
    public static ArrayList<Ebook> getEbooks() {
        return Manager.ebooks;
    }

    /**
     * Returns the list of audiobooks.
     * @return ArrayList of Audiobook objects
     */
    public static ArrayList<Audiobook> getAudiobooks() {
        return Manager.audiobooks;
    }

    /**
     * Returns the complete list of all types of books (printed, ebook, audiobook).
     * @return ArrayList of all Book objects
     */
    public static ArrayList<Book> getAllBooks() {
        return Manager.books;
    }

    /**
     * Populates the books lists with some sample data for testing.
     * This method adds predefined books to the printed books, ebooks, and audiobooks lists,
     * and then adds them to the general 'books' list.
     */
    public static void populateBooks() {
        // Adding printedBooks (Physical Books)
        printedBooks.add(new PrintedBook("The Odyssey", "Homer", "Epic Poetry", 17.99, 800, 450));
        printedBooks.add(new PrintedBook("Brave New World", "Aldous Huxley", "Dystopian", 19.99, 1932, 268));
        printedBooks.add(new PrintedBook("The Brothers Karamazov", "Fyodor Dostoevsky", "Philosophical Fiction", 22.99, 1880, 350));
    
        // Adding Ebooks
        ebooks.add(new Ebook("Sapiens", "Yuval Noah Harari", "Non-Fiction", 9.99, 2011, 5.5, "EPUB"));
        ebooks.add(new Ebook("Effective Java", "Joshua Bloch", "Programming", 8.99, 2018, 3.2, "PDF"));
        ebooks.add(new Ebook("Becoming", "Michelle Obama", "Autobiography", 12.99, 2018, 6.8, "EPUB"));
        ebooks.add(new Ebook("Educated", "Tara Westover", "Memoir", 10.99, 2018, 4.5, "PDF"));
        ebooks.add(new Ebook("The Silent Patient", "Alex Michaelides", "Psychological Thriller", 6.99, 2019, 2.8, "EPUB"));
    
        // Adding Audiobooks
        audiobooks.add(new Audiobook("The Night Circus", "Erin Morgenstern", "Fantasy", 25.99, 2011, 12, "Jim Dale"));
        audiobooks.add(new Audiobook("Dune", "Frank Herbert", "Science Fiction", 29.99, 1965, 21, "Simon Vance"));
        audiobooks.add(new Audiobook("The Goldfinch", "Donna Tartt", "Literary Fiction", 24.99, 2013, 32, "David Pittu"));
        audiobooks.add(new Audiobook("Becoming", "Michelle Obama", "Autobiography", 24.99, 2018, 19, "Michelle Obama"));
        audiobooks.add(new Audiobook("The Alchemist", "Paulo Coelho", "Philosophical Fiction", 14.99, 1988, 7, "Jeremy Irons"));
    
        // Adding all books to the general 'books' ArrayList
        books.addAll(printedBooks); // Add all printedBooks to books
        books.addAll(ebooks);       // Add all ebooks to books
        books.addAll(audiobooks);   // Add all audiobooks to books
    }
}