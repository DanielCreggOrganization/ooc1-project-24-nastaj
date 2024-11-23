package ie.atu.bookapp;

import java.util.ArrayList;

public class BookManager {
    // Because the size of the arrays are not known at the start of the program, they should be getting resized dynamically.
    // ArrayList is perfect for that. It makes the CRUD operations on arrays much easier.
    private ArrayList<Book> books;
    private ArrayList <BookPrinted> booksPrinted;
    private ArrayList<Ebook> ebooks;
    private ArrayList <Audiobook> audiobooks;

    // TODO: Getters and setters
}
