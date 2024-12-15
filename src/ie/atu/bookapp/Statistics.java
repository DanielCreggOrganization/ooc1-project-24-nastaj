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
        int total;
        double mostExpensive;
        double leastExpensive;
        double avgPrice;

        if(type.equals("All")) {
            
        }

        System.out.println("============ " + type + " Details ============");
    }
}
