package ie.atu.bookapp;

public class BookPrinted extends Book{
    private int pageCount;

    // Constructor using super tied to Book class
    public BookPrinted(String title, String author, double price, int publicationYear, int pageCount) {
        // From Book class
        super(title, author, price, publicationYear);

        // From BookPrinted class
        this.pageCount = pageCount;
    }

}
