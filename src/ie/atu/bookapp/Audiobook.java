package ie.atu.bookapp;

public class Audiobook extends Book{
    private int duration; // in hours
    private String narrator;

    // Constructor using super tied to Book class
    Audiobook(String title, String author, String genre, double price, int publicationYear, int duration, String narrator) {
        // From Book class
        super(title, author, genre, price, publicationYear);

        // From Audiobook class
        this.duration = duration;
        this.narrator = narrator;
    }

    public int getDuration() {
        return this.duration;
    }

    public String getNarrator() {
        return this.narrator;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setNarrator(String narrator) {
        this.narrator = narrator;
    }

    @Override
    public String toString() {
        // Use the parent's toString() and add pageCount information
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.append("Duration:        ").append(duration).append("\n");
        sb.append("Narrator:        ").append(narrator).append("\n");
        sb.append("Type:              ").append("Audiobook").append("\n");
        sb.append("====================================");

        return sb.toString();
    }
}
