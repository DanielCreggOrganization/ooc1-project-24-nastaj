package ie.atu.bookapp.classes;

public class Audiobook extends Book {
    private int duration; // Duration of the audiobook in hours
    private String narrator; // The name of the narrator

    /**
     * Constructor for creating an Audiobook object. 
     * This constructor initializes both the properties inherited from the Book class
     * and the properties specific to Audiobook (duration and narrator).
     * 
     * @param title The title of the audiobook.
     * @param author The author of the audiobook.
     * @param genre The genre of the audiobook.
     * @param price The price of the audiobook.
     * @param publicationYear The publication year of the audiobook.
     * @param duration The duration of the audiobook in hours.
     * @param narrator The name of the narrator for the audiobook.
     */
    public Audiobook(String title, String author, String genre, double price, int publicationYear, int duration, String narrator) {
        // Call the constructor of the parent class (Book) to initialize common properties
        super(title, author, genre, price, publicationYear);

        // Initialize the Audiobook-specific properties
        this.duration = duration;
        this.narrator = narrator;
    }

    // Getter and setter methods for the Audiobook-specific properties

    /**
     * Gets the duration of the audiobook in hours.
     * 
     * @return The duration of the audiobook.
     */
    public int getDuration() {
        return this.duration;
    }

    /**
     * Gets the name of the narrator of the audiobook.
     * 
     * @return The name of the narrator.
     */
    public String getNarrator() {
        return this.narrator;
    }

    /**
     * Sets the duration of the audiobook in hours.
     * 
     * @param duration The new duration for the audiobook.
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Sets the name of the narrator of the audiobook.
     * 
     * @param narrator The new name of the narrator.
     */
    public void setNarrator(String narrator) {
        this.narrator = narrator;
    }

    /**
     * Provides a string representation of the audiobook's details.
     * This method overrides the toString() method from the Book class to 
     * include audiobook-specific information (duration and narrator).
     * 
     * @return A formatted string representing the audiobook's details.
     */
    @Override
    public String toString() {
        // Use the toString() method from the Book class and add Audiobook-specific details
        StringBuilder sb = new StringBuilder();

        // Append the general book information (from Book class)
        sb.append(super.toString());
        // Append Audiobook-specific information
        sb.append("Duration:          ").append(duration).append(" hours\n");
        sb.append("Narrator:          ").append(narrator).append("\n");
        sb.append("Type:              ").append("Audiobook").append("\n");
        sb.append("====================================");

        return sb.toString(); // Return the formatted string representation
    }
}
