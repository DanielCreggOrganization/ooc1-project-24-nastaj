package ie.atu.bookapp;

public class Add {

    /**
     * Prompts the user to enter details for a printed book, confirms the details,
     * and adds it to the list of books if confirmed.
     */
    public static void book() {
        // Prompt the user for printed book details
        String title = InputHandler.promptString("Title");
        String author = InputHandler.promptString("Author");
        String genre = InputHandler.promptString("Genre");
        double price = InputHandler.promptDouble("Price");
        int publicationYear = InputHandler.promptInt("Publication Year");
        int pageCount = InputHandler.promptInt("Page Count");
        String choice;

        // Set the current navigation context
        Navigation.setCurrentPage("book");
        Navigation.setPreviousPage("addBook");
        ClearConsole.clearConsole();

        System.out.println("Printed Book");
        System.out.println("=================");
        System.out.println("Enter details");
        System.out.println("--------------");

        // Ask for confirmation from the user
        System.out.println("==============");
        System.out.println("Is this correct?");
        System.out.println("--------------");
        System.out.print("Y / N: ");
        choice = App.scanner.nextLine();

        // If the user confirms the details, add the book to the list
        if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")) {
            PrintedBook printedBook = new PrintedBook(title, author, genre, price, publicationYear, pageCount);
            Manager.getPrintedBooks().add(printedBook); // Add to the printed books list
            Manager.getAllBooks().add(printedBook); // Add to the overall books list
            addAnotherBook("printed"); // Prompt to add another book
        } else {
            Add.book(); // Retry if details are not confirmed
        }
    }

    /**
     * Prompts the user to enter details for an ebook, confirms the details,
     * and adds it to the list of books if confirmed.
     */
    public static void ebook() {
        // Prompt the user for ebook details
        String title = InputHandler.promptString("Title");
        String author = InputHandler.promptString("Author");
        String genre = InputHandler.promptString("Genre");
        double price = InputHandler.promptDouble("Price");
        int publicationYear = InputHandler.promptInt("Publication Year");
        double fileSize = InputHandler.promptDouble("File Size (MB)");
        String format = InputHandler.promptString("File Format (i.e EPUB)");
        String choice;

        // Set the current navigation context
        Navigation.setCurrentPage("ebook");
        Navigation.setPreviousPage("addBook");
        ClearConsole.clearConsole();

        System.out.println("Ebook");
        System.out.println("=================");
        System.out.println("Enter details");
        System.out.println("--------------");

        // Ask for confirmation from the user
        System.out.println("==============");
        System.out.println("Is this correct?");
        System.out.println("--------------");
        System.out.print("Y / N: ");
        choice = App.scanner.nextLine();

        // If the user confirms the details, add the ebook to the list
        if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")) {
            Ebook ebook = new Ebook(title, author, genre, price, publicationYear, fileSize, format);
            Manager.getEbooks().add(ebook); // Add to the ebooks list
            Manager.getAllBooks().add(ebook); // Add to the overall books list
            addAnotherBook("ebook"); // Prompt to add another ebook
        } else {
            Add.ebook(); // Retry if details are not confirmed
        }
    }

    /**
     * Prompts the user to enter details for an audiobook, confirms the details,
     * and adds it to the list of books if confirmed.
     */
    public static void audiobook() {
        // Prompt the user for audiobook details
        String title = InputHandler.promptString("Title");
        String author = InputHandler.promptString("Author");
        String genre = InputHandler.promptString("Genre");
        double price = InputHandler.promptDouble("Price");
        int publicationYear = InputHandler.promptInt("Publication Year");
        int duration = InputHandler.promptInt("Duration");
        String narrator = InputHandler.promptString("Narrator");
        String choice;

        // Set the current navigation context
        Navigation.setCurrentPage("audiobook");
        Navigation.setPreviousPage("addBook");
        ClearConsole.clearConsole();

        System.out.println("Audiobook");
        System.out.println("=================");
        System.out.println("Enter details");
        System.out.println("--------------");

        // Ask for confirmation from the user
        System.out.println("==============");
        System.out.println("Is this correct?");
        System.out.println("--------------");
        System.out.print("Y / N: ");
        choice = App.scanner.nextLine();

        // If the user confirms the details, add the audiobook to the list
        if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")) {
            Audiobook audiobook = new Audiobook(title, author, genre, price, publicationYear, duration, narrator);
            Manager.getAudiobooks().add(audiobook); // Add to the audiobooks list
            Manager.getAllBooks().add(audiobook); // Add to the overall books list
            addAnotherBook("audiobook"); // Prompt to add another audiobook
        } else {
            Add.audiobook(); // Retry if details are not confirmed
        }
    }

    /**
     * Prompts the user whether they want to add another book of the specified type (printed, ebook, or audiobook).
     * @param bookType The type of book being added (printed, ebook, audiobook).
     */
    private static void addAnotherBook(String bookType) {
        String choice;
        
        // Ask the user if they want to add another book
        System.out.println("Book added successfully!");
        System.out.println("Add another " + bookType + "?");
        System.out.println("--------------");
        System.out.print("Y / N: ");
        choice = App.scanner.nextLine();

        // If the user chooses yes, prompt the user to add another book of the same type
        if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")) {
            switch (bookType) {
                case "printed":
                    Add.book(); // Recurse to add another printed book
                    break;
                case "ebook":
                    Add.ebook(); // Recurse to add another ebook
                    break;
                case "audiobook":
                    Add.audiobook(); // Recurse to add another audiobook
                    break;
                default:
                    break;
            }
        } else {
            Navigation.moveTo(Navigation.getPreviousPage()); // Navigate back to the previous page if no more books are to be added
        }
    }
}