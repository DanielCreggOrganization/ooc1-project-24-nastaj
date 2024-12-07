package ie.atu.bookapp;

public abstract class Book {
    private int id;
    private String title;
    private String author;
    private double price;
    private int publicationYear;

    // Constructor
    public Book(int id, String title, String author, double price, int publicationYear) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.publicationYear = publicationYear;
    }

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    // Overriding the toString() method to print out the contents of ArrayList in a formatted way
    @Override
    public String toString() {
        return "{id='" + id + '\'' +
               ", title='" + title + '\'' +
               ", author='" + author + '\'' +
               ", price=" + price +
               ", publicationYear=" + publicationYear;
    }
}
