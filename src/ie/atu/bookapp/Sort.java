package ie.atu.bookapp;

import java.util.ArrayList;
import java.util.Comparator;

public class Sort {
    private static <T extends Book> void sortBooks(ArrayList<T> books, String sortBy) {
        switch (sortBy.toLowerCase()) {
            case "titleasc":
                books.sort(Comparator.comparing(Book::getTitle));
                break;

            case "titledesc":
                books.sort(Comparator.comparing(Book::getTitle).reversed());
                break;

            case "author":
                books.sort(Comparator.comparing(Book::getAuthor));
                break;

            case "priceasc":
                books.sort(Comparator.comparingDouble(Book::getPrice));
                break;

            case "pricedesc":
                books.sort(Comparator.comparingDouble(Book::getPrice).reversed());
                break;

            case "pages":
                if (books.get(0) instanceof PrintedBook) {
                    books.sort(Comparator.comparingInt(b -> ((PrintedBook) b).getPageCount()));
                }
                break;

            case "filesize":
                if (books.get(0) instanceof Ebook) {
                    books.sort(Comparator.comparingDouble(b -> ((Ebook) b).getFileSize()));
                }
                break;

            case "duration":
                if (books.get(0) instanceof Audiobook) {
                    books.sort(Comparator.comparingInt(b -> ((Audiobook) b).getDuration()));
                }
                break;

            default:
                books.sort(Comparator.comparingInt(Book::getId));
        }
    }
    
    public static void sortAllBooks(String sortBy) {
        sortBooks(Manager.getAllBooks(), sortBy);
    }
    
    public static void sortPrintedBooks(String sortBy) {
        sortBooks(Manager.getPrintedBooks(), sortBy);
    }
    
    public static void sortEbooks(String sortBy) {
        sortBooks(Manager.getEbooks(), sortBy);
    }
    
    public static void sortAudiobooks(String sortBy) {
        sortBooks(Manager.getAudiobooks(), sortBy);
    }
}
