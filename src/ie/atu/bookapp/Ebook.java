package ie.atu.bookapp;

public class Ebook extends Book {
    private double fileSize; // in MB
    private String format; // e.g. EPUB, PDF

    // Constructor using super tied to Book class
    Ebook(String title, String author, double price, int publicationYear, double fileSize, String format) {
        // From Book class
        super(title, author, price, publicationYear);

        // From Ebook class
        this.fileSize = fileSize;
        this.format = format;
    }

    // TODO: Setters and getters
}
