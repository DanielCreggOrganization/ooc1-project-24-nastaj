package ie.atu.bookapp;

public class Audiobook extends Book{
    private int duration; // in hours
    private String narrator;

    // Constructor using super tied to Book class
    Audiobook(int id, String title, String author, double price, int publicationYear, int duration, String narrator) {
        // From Book class
        super(id, title, author, price, publicationYear);

        // From Audiobook class
        this.duration = duration;
        this.narrator = narrator;
    }

    // TODO: Setters and getters
}
