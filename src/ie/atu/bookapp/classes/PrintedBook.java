package ie.atu.bookapp.classes;

public class PrintedBook extends Book {
    // Additional attribute specific to printed books
    private int pageCount;

    /**
     * Constructor for the PrintedBook class that initializes both
     * the properties of the parent class (Book) and the PrintedBook class itself.
     * 
     * @param title          The title of the book.
     * @param author         The author of the book.
     * @param genre          The genre of the book.
     * @param price          The price of the book.
     * @param publicationYear The publication year of the book.
     * @param pageCount      The number of pages in the printed book.
     */
    public PrintedBook(String title, String author, String genre, double price, int publicationYear, int pageCount) {
        // Initialize the parent class (Book) with its properties using 'super'
        super(title, author, genre, price, publicationYear);

        // Initialize the page count specific to the PrintedBook class
        this.pageCount = pageCount;
    }

    /**
     * Getter for the pageCount attribute.
     * 
     * @return The number of pages in the printed book.
     */
    public int getPageCount() {
        return this.pageCount;
    }

    /**
     * Setter for the pageCount attribute.
     * 
     * @param pageCount The new number of pages to set.
     */
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    /**
     * Overridden toString method to provide a custom string representation of the PrintedBook object.
     * The printed book details include the inherited details from the Book class and the page count.
     * 
     * @return A string representation of the PrintedBook object, including title, author, genre,
     *         price, publication year, page count, and type of book.
     */
    @Override
    public String toString() {
        // Use StringBuilder to construct the string representation for better performance
        StringBuilder sb = new StringBuilder();

        // Append the parent class's (Book) toString() result
        sb.append(super.toString());

        // Append the specific details for the printed book
        sb.append("Page Count:        ").append(pageCount).append("\n");
        sb.append("Type:              ").append("Printed Book").append("\n");
        sb.append("====================================");

        // Return the final string representation of the printed book
        return sb.toString();
    }
}
