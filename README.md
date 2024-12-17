# OOC1 Project

**Title:** Library Management System (Booklet)

**Name:** Jakub Nasta

**Student ID:** G00424689@atu.ie

## Application Function

The Booklet application is a Library Management System that allows users to manage different types of books, such as printed books, ebooks, and audiobooks. The application provides functionality to sort books by various attributes, view detailed statistics about the books, and perform operations like adding, removing, or updating books.

## Running the Application

To run the application, follow these steps:

1. Ensure that you have Java installed on your system. You can download and install it from [Oracle's official site](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
2. Clone or download the project from the GitHub repository.
3. Navigate to the project folder in your terminal.
4. Compile the project using the following command:
    ```bash
    javac *.java
    ```
5. Run the application by executing the `App` class:
    ```bash
    java ie.atu.bookapp.App
    ```
6. Follow the on-screen prompts to interact with the application.

## Main Methods

* Methods implemented:
* Add Item
* Remove Item
* Update Item
* Find total items
* Search Items
* Quit

## Advanced Methods

In addition to the minimum requirements, the application has the following features:

* **Statistics functionality:** Users can view detailed statistics about books, including average prices, most expensive books, longest books, and more, for different categories of books (printed, ebook, audiobook).
* **Book Sorting:** Users can sort books by title, price, author, genre, page count, file size, and duration for audiobooks.
* **Menu Navigation and Clear Console:** Easy navigation through a console-based menu with clear options for managing books and viewing statistics.

## Application Architecture

The application is structured as follows:

- **App Class:** Manages the main flow of the application. It initializes the manager, handles user input, and displays the main menu.
- **Manager Class:** Responsible for managing all book-related data and operations, such as adding, removing, and searching for books.
- **Book Class (and subclasses):** Represents the basic book model with attributes like title, author, price, genre, etc. The subclasses (PrintedBook, Ebook, and Audiobook) extend the Book class and add specific features.
- **Navigation Class:** Handles page navigation and side menu interactions for a smoother user experience.
- **Statistics Class:** Manages the display of various statistics related to the books in the library.
- **Sort Class:** Provides functionality for sorting books based on various attributes.

### List of Methods

- **App Methods:**
  - `printMainMenu()`: Displays the main menu and handles user input for navigating the app.
  - `run()`: Starts the application and continuously displays the main menu until the user exits.

- **Manager Methods:**
  - `populateBooks()`: Populates the initial list of books.
  - `printMenu()`: Displays a menu for managing books.

- **Book Class Methods:**
  - `getTitle()`, `getAuthor()`, `getPrice()`, etc.: Getter methods for various attributes of the books.

- **Statistics Methods:**
  - `printMenu()`: Displays the statistics menu and handles user input for selecting different stats to view.
  - `printStatsAll()`, `printStatsPrinted()`, etc.: Displays various statistics for all books, printed books, ebooks, and audiobooks.
  - `getTotalBooks()`, `getAveragePrice()`: Calculates and returns the total number of books and average price for a given book type.

- **Sort Methods:**
  - `sortBooks()`: Sorts books based on different criteria such as title, price, genre, etc.

## Roadblocks and Unfinished Functionality

While the core functionality of the application is complete, there were a few challenges and areas that could be improved upon:

- **Persistence:** The application does not currently save data after the application is closed. Implementing file-based storage or a database would make the application more robust.
- **Error Handling:** More comprehensive error handling could be implemented, especially for user inputs.
- **Advanced Text Formatting:** Better color-coding for menus and display tables to make the user experience more crisp and easier to read.

If I were to work on this project again, I would focus on implementing data persistence and improving error handling for a smoother user experience.

## Resources

- [Tutorialspoint](https://www.tutorialspoint.com/java/) - Java Tutorials site I found helpful.
- [Oracle Java Documentation](https://docs.oracle.com/javase/8/docs/api/) - Java API documentation for reference.

## Features

- **Book Management:** Add, remove, and update books.
- **Sorting:** Sort books by title, author, price, genre, page count, file size, and duration.
- **Statistics:** View detailed statistics like most expensive books, longest books, average prices, and more.
- **User Interaction:** Console-based menu navigation and clear prompts for user interaction.

