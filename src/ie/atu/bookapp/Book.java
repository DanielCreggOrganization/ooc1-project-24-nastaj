package ie.atu.bookapp;

public class Book {
    private String title;
    private String author;
    private double price;
    private int publicationYear;

    // Constructor
    public Book(String title, String author, double price, int publicationYear) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.publicationYear = publicationYear;
    }

    // TODO: Getters and setters

    // Overriding the toString() method to print out the contents of ArrayList in a formatted way
    @Override
    public String toString() {
        return "Book {title='" + title + '\'' +
               ", author='" + author + '\'' +
               ", price=" + price +
               ", publicationYear=" + publicationYear;
    }
}
