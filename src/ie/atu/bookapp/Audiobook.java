package ie.atu.bookapp;

public class Audiobook extends Book{
    private int duration; // in hours
    private String narrator;

    // Constructor using super tied to Book class
    Audiobook(String title, String author, double price, int publicationYear, int duration, String narrator) {
        // From Book class
        super(title, author, price, publicationYear);

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
}
