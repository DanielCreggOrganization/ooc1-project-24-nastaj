package ie.atu.bookapp.classes;

public abstract class Book {
    // Static counter to generate unique IDs for each book instance
    private static int nextId = 1; // Shared counter for all books
    private int id; // Unique ID for each book
    private String title; // Title of the book
    private String author; // Author of the book
    private String genre; // Genre of the book
    private double price; // Price of the book
    private int publicationYear; // Publication year of the book

    /**
     * Constructor for initializing a Book object with the provided details.
     * It also assigns a unique ID to each book using the static nextId counter.
     *
     * @param title The title of the book.
     * @param author The author of the book.
     * @param genre The genre of the book.
     * @param price The price of the book.
     * @param publicationYear The publication year of the book.
     */
    public Book(String title, String author, String genre, double price, int publicationYear) {
        this.id = nextId++; // Assign and increment the next unique ID
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.price = price;
        this.publicationYear = publicationYear;
    }

    // Getter methods for accessing the properties of the book

    /**
     * Gets the unique ID of the book.
     * 
     * @return The ID of the book.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Gets the title of the book.
     * 
     * @return The title of the book.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Gets the author of the book.
     * 
     * @return The author of the book.
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * Gets the genre of the book.
     * 
     * @return The genre of the book.
     */
    public String getGenre() {
        return this.genre;
    }

    /**
     * Gets the price of the book.
     * 
     * @return The price of the book.
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Gets the publication year of the book.
     * 
     * @return The publication year of the book.
     */
    public int getPublicationYear() {
        return this.publicationYear;
    }

    // Setter methods for modifying the properties of the book

    /**
     * Sets the title of the book.
     * 
     * @param title The new title of the book.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Sets the author of the book.
     * 
     * @param author The new author of the book.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Sets the genre of the book.
     * 
     * @param genre The new genre of the book.
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Sets the price of the book.
     * 
     * @param price The new price of the book.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Provides a string representation of the book's details.
     * This method is overridden to format the output in a readable manner
     * when printing or logging the book object.
     * 
     * @return A string that represents the book's details.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("====================================\n");
        sb.append("            Book Details            \n");
        sb.append("====================================\n");
        sb.append("ID:                ").append(id).append("\n");
        sb.append("Title:             ").append(title).append("\n");
        sb.append("Author:            ").append(author).append("\n");
        sb.append("Genre:             ").append(genre).append("\n");
        sb.append("Price:             $").append(price).append("\n");
        sb.append("Publication Year:  ").append(publicationYear).append("\n");

        return sb.toString(); // Returns the formatted string representation of the book
    }
}
