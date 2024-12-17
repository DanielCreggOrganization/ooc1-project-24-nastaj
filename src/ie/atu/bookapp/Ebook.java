package ie.atu.bookapp;

public class Ebook extends Book {
    private double fileSize; // The file size of the ebook in MB
    private String format; // The format of the ebook (e.g., EPUB, PDF)

    /**
     * Constructor for creating an Ebook object. 
     * This constructor initializes both the properties inherited from the Book class
     * and the properties specific to Ebook (fileSize and format).
     * 
     * @param title The title of the ebook.
     * @param author The author of the ebook.
     * @param genre The genre of the ebook.
     * @param price The price of the ebook.
     * @param publicationYear The publication year of the ebook.
     * @param fileSize The file size of the ebook in MB.
     * @param format The format of the ebook (e.g., EPUB, PDF).
     */
    public Ebook(String title, String author, String genre, double price, int publicationYear, double fileSize, String format) {
        // Call the constructor of the parent class (Book) to initialize common properties
        super(title, author, genre, price, publicationYear);

        // Initialize the Ebook-specific properties
        this.fileSize = fileSize;
        this.format = format;
    }

    // Getter and setter methods for the Ebook-specific properties

    /**
     * Gets the file size of the ebook in MB.
     * 
     * @return The file size of the ebook.
     */
    public double getFileSize() {
        return this.fileSize;
    }

    /**
     * Gets the format of the ebook (e.g., EPUB, PDF).
     * 
     * @return The format of the ebook.
     */
    public String getFormat() {
        return this.format;
    }

    /**
     * Sets the file size of the ebook in MB.
     * 
     * @param fileSize The new file size for the ebook.
     */
    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * Sets the format of the ebook (e.g., EPUB, PDF).
     * 
     * @param format The new format for the ebook.
     */
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * Provides a string representation of the ebook's details.
     * This method overrides the toString() method from the Book class to 
     * include ebook-specific information (fileSize and format).
     * 
     * @return A formatted string representing the ebook's details.
     */
    @Override
    public String toString() {
        // Use the toString() method from the Book class and add Ebook-specific details
        StringBuilder sb = new StringBuilder();

        // Append the general book information (from Book class)
        sb.append(super.toString());
        // Append Ebook-specific information
        sb.append("File Size:         ").append(fileSize).append(" MB\n");
        sb.append("File Format:       ").append(format).append("\n");
        sb.append("Type:              ").append("Ebook").append("\n");
        sb.append("====================================");

        return sb.toString(); // Return the formatted string representation
    }
}
