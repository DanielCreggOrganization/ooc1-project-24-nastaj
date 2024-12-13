package ie.atu.bookapp;

public abstract class Book {
    private static int nextId = 1; // Shared counter for all books
    private int id;
    private String title;
    private String author;
    private double price;
    private int publicationYear;

    // Constructor
    public Book(String title, String author, double price, int publicationYear) {
        this.id = nextId++;
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

    public String getAuthor() {
        return this.author;
    }

    public double getPrice() {
        return this.price;
    }

    public int getPublicationYear() {
        return this.publicationYear;
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
