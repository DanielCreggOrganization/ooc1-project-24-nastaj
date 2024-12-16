package ie.atu.bookapp;

public class Add {
    public static void book() {
        String title;
        String author;
        double price;
        int publicationYear;
        int pageCount;
        String choice;

        Navigation.setCurrentPage("book");
        Navigation.setPreviousPage("addBook");
        ClearConsole.clearConsole();

        System.out.println("Printed Book");
        System.out.println("=================");
        System.out.println("Enter details");
        System.out.println("--------------");

        title = InputHandler.promptString("Title");
        author = InputHandler.promptString("Author");
        price = InputHandler.promptDouble("Price");
        publicationYear = InputHandler.promptInt("Publication Year");
        pageCount = InputHandler.promptInt("Page Count");
        
        System.out.println("==============");
        System.out.println("Is this correct?");
        System.out.println("--------------");
        System.out.print("Y / N: ");

        choice = App.scanner.nextLine();
        
        if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")) {
            PrintedBook PrintedBook = new PrintedBook(title, author, price, publicationYear, pageCount);
            Manager.printedBooks.add(PrintedBook);
            Manager.books.add(PrintedBook);
        
            ClearConsole.clearConsole();

            System.out.println("Book added successfully!");
            System.out.println("Add another book?");
        
            System.out.println("--------------");
            System.out.print("Y / N: ");
            choice = App.scanner.nextLine();
                    
            if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")) {
                // Prompt the user again
                Manager.printBookMenu();
            }
                    
            else if (choice.equalsIgnoreCase("n") || choice.equalsIgnoreCase("no")) {
                Navigation.moveTo(Navigation.getPreviousPage());
            }
        
        }
        else if (choice.equalsIgnoreCase("n") || choice.equalsIgnoreCase("no")) {
            // Prompt the user again
            Manager.printBookMenu();
        }
    }

    public static void ebook() {
        String title;
        String author;
        double price;
        int publicationYear;
        String choice;
        double fileSize;
        String format;

        Navigation.setCurrentPage("ebook");
        Navigation.setPreviousPage("addBook");
        ClearConsole.clearConsole();

        System.out.println("Ebook");
        System.out.println("=================");
        System.out.println("Enter details");
        System.out.println("--------------");

        title = InputHandler.promptString("Title");
        author = InputHandler.promptString("Author");
        price = InputHandler.promptDouble("Price");
        publicationYear = InputHandler.promptInt("Publication Year");
        fileSize = InputHandler.promptDouble("File Size (MB)");
        format = InputHandler.promptString("File Format (i.e EPUB)");;

        System.out.println("==============");
        System.out.println("Is this correct?");
        System.out.println("--------------");
        System.out.print("Y / N: ");
        choice = App.scanner.nextLine();
        
        if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")) {
            Ebook ebook = new Ebook(title, author, price, publicationYear, fileSize, format);
            Manager.ebooks.add(ebook);
            Manager.books.add(ebook);
        
            ClearConsole.clearConsole();
        
            System.out.println("Ebook added successfully!");
            System.out.println("Add another ebook?");
        
            System.out.println("--------------");
            System.out.print("Y / N: ");
            choice = App.scanner.nextLine();
                    
            if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")) {
                // Prompt the user again
                Manager.printEbookMenu();
            }
                    
            else if (choice.equalsIgnoreCase("n") || choice.equalsIgnoreCase("no")) {
                Navigation.moveTo(Navigation.getPreviousPage());
            }
        
        }
        else if (choice.equalsIgnoreCase("n") || choice.equalsIgnoreCase("no")) {
            // Prompt the user again
            Manager.printEbookMenu();
        }
    }

    public static void audiobook() {
        String title;
        String author;
        double price;
        int publicationYear;
        String choice;
        int duration;
        String narrator;

        Navigation.setCurrentPage("audiobook");
        Navigation.setPreviousPage("addBook");
        ClearConsole.clearConsole();

        System.out.println("Audiobook");
        System.out.println("=================");
        System.out.println("Enter details");
        System.out.println("--------------");

        title = InputHandler.promptString("Title");
        author = InputHandler.promptString("Author");
        price = InputHandler.promptDouble("Price");
        publicationYear = InputHandler.promptInt("Publication Year");
        duration = InputHandler.promptInt("Duration");
        narrator = InputHandler.promptString("Narrator");

        
        System.out.println("==============");
        System.out.println("Is this correct?");
        System.out.println("--------------");
        System.out.print("Y / N: ");
        choice = App.scanner.nextLine();
        
        if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")) {
            Audiobook audiobook = new Audiobook(title, author, price, publicationYear, duration, narrator);
            Manager.audiobooks.add(audiobook);
            Manager.books.add(audiobook);
        
            ClearConsole.clearConsole();
        
            System.out.println("Audiobook added successfully!");
            System.out.println("Add another audiobook?");
        
            System.out.println("--------------");
            System.out.print("Y / N: ");
            choice = App.scanner.nextLine();
                    
            if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")) {
                // Prompt the user again
                Manager.printAudiobookMenu();
            }
                    
            else if (choice.equalsIgnoreCase("n") || choice.equalsIgnoreCase("no")) {
                Navigation.moveTo(Navigation.getPreviousPage());
            }
        
        }
        else if (choice.equalsIgnoreCase("n") || choice.equalsIgnoreCase("no")) {
            // Prompt the user again
            Manager.printEbookMenu();
        }
    }
}
