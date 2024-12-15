package ie.atu.bookapp;

public class Statistics {
    public static void printMenu() {
        Navigation.setCurrentPage("stats");
        Navigation.setPreviousPage("main");

        ClearConsole.clearConsole();

        System.out.println();
        System.out.println("============ Statistics ============");
        System.out.println("What details do you want to view?");
        System.out.println("(1) All");
        System.out.println("(2) Printed Books");
        System.out.println("(3) Ebooks");
        System.out.println("(4) Audiobooks");
        Navigation.sideMenu();

        System.out.print("Enter your choice: ");

        String choice = App.scanner.nextLine();

        Navigation.sideMenu(choice);
        
        switch(choice) {
            // TODO: All choices for this menu
            case "1": 
                Statistics.printStats("All");
                break;
            case "2": 
                Statistics.printStats("Printed Book");
                break;
            case "3": 
                Statistics.printStats("Ebook");
                break;
            case "4": 
                Statistics.printStats("Audiobook");
                break;
        }
    }

    private static void printStats(String type) {
        StringBuilder sb = new StringBuilder();
        PrintedBook maxPrinted = BookManager.getPrintedStats("maxPrice");
        PrintedBook minPrinted = BookManager.getPrintedStats("minPrice");

        System.out.println("============ " + type + " Details ============");
        sb.append("Total number of books: ");
        sb.append(BookManager.getTotalBooks("Printed Book"));
        sb.append("\n");

        sb.append("Most expensive book: ");
        sb.append(maxPrinted.getTitle());
        sb.append(" by ");
        sb.append(maxPrinted.getAuthor());
        sb.append(" (");
        sb.append(maxPrinted.getPrice());
        sb.append("$)\n");

        sb.append("Least expensive book: ");
        sb.append(minPrinted.getTitle());
        sb.append(" by ");
        sb.append(minPrinted.getAuthor());
        sb.append(" (");
        sb.append(minPrinted.getPrice());
        sb.append("$)\n");

        System.out.println(sb.toString());
    }
}
