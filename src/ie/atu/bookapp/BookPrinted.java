package ie.atu.bookapp;

public class BookPrinted extends Book{
    private int pageCount;

    // Constructor using super tied to Book class
    public BookPrinted(int id, String title, String author, double price, int publicationYear, int pageCount) {
        // From Book class
        super(id, title, author, price, publicationYear);

        // From BookPrinted class
        this.pageCount = pageCount;
    }

    // Overriding the toString() method
    @Override
    public String toString() {
        // Use the parent's toString() and add pageCount information
        return "Book " + super.toString() + ", pageCount=" + pageCount + "}";
    }
}
