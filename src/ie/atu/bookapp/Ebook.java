package ie.atu.bookapp;

public class Ebook extends Book {
    private double fileSize; // in MB
    private String format; // e.g. EPUB, PDF

    // Constructor using super tied to Book class
    public Ebook(String title, String author, double price, int publicationYear, double fileSize, String format) {
        // From Book class
        super(title, author, price, publicationYear);

        // From Ebook class
        this.fileSize = fileSize;
        this.format = format;
    }

    // TODO: Setters and getters
    public double getFileSize() {
        return this.fileSize;
    }

    public String getFormat() {
        return this.format;
    }

    // Overriding the toString() method
    @Override
    public String toString() {
        // Use the parent's toString() and add fileSize and format information
        return "Ebook " + super.toString() + ", fileSize=" + fileSize + '\'' + ", format=" + format + "}";
    }
}