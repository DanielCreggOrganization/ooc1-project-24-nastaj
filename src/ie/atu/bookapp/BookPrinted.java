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

    public int getPageCount() {
        return this.pageCount;
    }

    // Overriding the toString() method
    @Override
    public String toString() {
        // Use the parent's toString() and add pageCount information
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.append("Page Count:        ").append(pageCount).append("\n");
        sb.append("Type:              ").append("Printed Book").append("\n");
        sb.append("====================================");

        return sb.toString();
    }
}
