package ie.atu.bookapp;

import java.util.ArrayList;
import java.util.Comparator;

public class Sort {

    /**
     * Sorts the provided list of books based on the specified sorting criteria.
     * 
     * @param books   The list of books to be sorted.
     * @param sortBy  The sorting criteria (e.g., title, author, price).
     *                Possible values include: "titleasc", "titledesc", "author", "priceasc", "pricedesc",
     *                "genre", "pages", "filesize", "duration", or the default which sorts by Book ID.
     */
    private static <T extends Book> void sortBooks(ArrayList<T> books, String sortBy) {
        // Switch statement to determine sorting behavior based on 'sortBy' value
        switch (sortBy.toLowerCase()) {
            case "titleasc":
                // Sort books by title in ascending order
                books.sort(Comparator.comparing(Book::getTitle));
                break;

            case "titledesc":
                // Sort books by title in descending order
                books.sort(Comparator.comparing(Book::getTitle).reversed());
                break;

            case "author":
                // Sort books by author in ascending order
                books.sort(Comparator.comparing(Book::getAuthor));
                break;

            case "priceasc":
                // Sort books by price in ascending order
                books.sort(Comparator.comparingDouble(Book::getPrice));
                break;

            case "pricedesc":
                // Sort books by price in descending order
                books.sort(Comparator.comparingDouble(Book::getPrice).reversed());
                break;

            case "genre":
                // Sort books by genre in ascending order
                books.sort(Comparator.comparing(Book::getGenre));
                break;

            case "pages":
                // If books are of type PrintedBook, sort by page count
                if (books.get(0) instanceof PrintedBook) {
                    books.sort(Comparator.comparingInt(b -> ((PrintedBook) b).getPageCount()));
                }
                break;

            case "filesize":
                // If books are of type Ebook, sort by file size
                if (books.get(0) instanceof Ebook) {
                    books.sort(Comparator.comparingDouble(b -> ((Ebook) b).getFileSize()));
                }
                break;

            case "duration":
                // If books are of type Audiobook, sort by duration
                if (books.get(0) instanceof Audiobook) {
                    books.sort(Comparator.comparingInt(b -> ((Audiobook) b).getDuration()));
                }
                break;

            default:
                // Default sorting: Sort by Book ID in ascending order
                books.sort(Comparator.comparingInt(Book::getId));
        }
    }

    /**
     * Sorts all books based on the specified sorting criteria.
     * 
     * @param sortBy The sorting criteria to apply to the list of all books.
     */
    public static void sortAllBooks(String sortBy) {
        // Sort all books using the specified criteria
        sortBooks(Manager.getAllBooks(), sortBy);
    }

    /**
     * Sorts only the printed books based on the specified sorting criteria.
     * 
     * @param sortBy The sorting criteria to apply to the list of printed books.
     */
    public static void sortPrintedBooks(String sortBy) {
        // Sort printed books using the specified criteria
        sortBooks(Manager.getPrintedBooks(), sortBy);
    }

    /**
     * Sorts only the ebooks based on the specified sorting criteria.
     * 
     * @param sortBy The sorting criteria to apply to the list of ebooks.
     */
    public static void sortEbooks(String sortBy) {
        // Sort ebooks using the specified criteria
        sortBooks(Manager.getEbooks(), sortBy);
    }

    /**
     * Sorts only the audiobooks based on the specified sorting criteria.
     * 
     * @param sortBy The sorting criteria to apply to the list of audiobooks.
     */
    public static void sortAudiobooks(String sortBy) {
        // Sort audiobooks using the specified criteria
        sortBooks(Manager.getAudiobooks(), sortBy);
    }
}
