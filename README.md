# OOC1 Project

**Title:** Library Management System (Booklet)

**Name:** Jakub Nasta

**Student ID:** G00424689

## Application Function

The Booklet application is a Library Management System that allows users to manage different types of books, such as printed books, ebooks, and audiobooks. The application provides functionality to sort books by various attributes, view detailed statistics about the books, and perform operations like adding, removing, or updating books.

## Running the Application

To run the application, follow these steps:

1. Ensure Java is Installed  
   Verify your Java installation by running the following command in your terminal:  
   ```bash
   java -version
   ```
   
   If Java is not installed, download and install it from [Oracle's Official Site](https://www.oracle.com/java/technologies/downloads/).
   
3. Clone the GitHub repository using the command:
   ```bash
   git clone <repository-url>
   ```
   
   OR
   
   Download the ZIP file of the project and extract it to your desired location.
   
4. Navigate to the project folder in your terminal.
   
5. Run the application by executing the `Main` class:
    ```bash
    java -cp bin ie.atu.bookapp.Main
    ```
    
6. Follow the on-screen prompts to interact with the application.

## Features Showcase

**Add Book**

![](https://github.com/DanielCreggOrganization/ooc1-project-24-nastaj/blob/main/gifs/add.gif)

**Remove Book**

![](https://github.com/DanielCreggOrganization/ooc1-project-24-nastaj/blob/main/gifs/remove.gif)

**Update Book**

![](https://github.com/DanielCreggOrganization/ooc1-project-24-nastaj/blob/main/gifs/update.gif)

**Find Book**

![](https://github.com/DanielCreggOrganization/ooc1-project-24-nastaj/blob/main/gifs/find.gif)

**Display & Sort Books**

![](https://github.com/DanielCreggOrganization/ooc1-project-24-nastaj/blob/main/gifs/show_sort.gif)

**View Statistics**

![](https://github.com/DanielCreggOrganization/ooc1-project-24-nastaj/blob/main/gifs/stats.gif)

**Quit**

![](https://github.com/DanielCreggOrganization/ooc1-project-24-nastaj/blob/main/gifs/quit.gif)

## Features

- **Book Management:** Add, remove, and update books.
- **Sorting:** Sort books by title, author, price, genre, page count, file size, and duration.
- **Statistics:** View detailed statistics like most expensive books, longest books, average prices, and more.
- **User Interaction:** Console-based menu navigation and clear prompts for user interaction.

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
- **Menu Class:**: Handles printing menus to the console.
- **Statistics Class:** Manages the display of various statistics related to the books in the library.
- **Sort Class:** Provides functionality for sorting books based on various attributes.
- **Feature Classes:** Add, Remove, Find, Sort, etc. classes for their corresponding functionalities.
- **Utility Classess:** ASCII, InputHandler and ClearConsole classes for abstracting code, enhancing reusability and easing the development process.

### **List of Methods**

#### **App Methods**
- **`printMainMenu()`**  
  Displays the main menu and handles user input for navigating the app.

- **`run()`**  
  Starts the application and continuously displays the main menu until the user exits.

---

#### **Manager Methods**
- **`populateBooks()`**  
  Populates the initial list of books.

- **`printMenu()`**  
  Displays a menu for managing books.

---

#### **Book Class Methods**
- **`getTitle()`**, **`getAuthor()`**, **`getPrice()`**, etc.  
  Getter methods for various attributes of the books.

---

#### **Add Methods**
- **`book()`**  
  Prompts the user to enter details for a printed book, confirms the details, and adds it to the list of books if confirmed.  

- **`ebook()`**  
  Prompts the user to enter details for an ebook, confirms the details, and adds it to the list of books if confirmed.  

- **`audiobook()`**  
  Prompts the user to enter details for an audiobook, confirms the details, and adds it to the list of books if confirmed.  

- **`addAnotherBook(String bookType)`**  
  Prompts the user whether they want to add another book of the specified type (printed, ebook, or audiobook).  

---

#### **Display Methods**
- **`showBooks(String type)`**  
  Displays the list of books based on the specified type (printed, ebooks, audiobooks, or all).  

- **`displayBooks(String type, String sortBy, int results)`**  
  Displays books of a specific type (printed, ebooks, audiobooks) with optional sorting applied.  

- **`displayAllBooks(String type, String sortBy, int results)`**  
  Displays all books (printed, ebooks, audiobooks) combined in one list with sorting options.

---

#### **Find Methods**
- **`findBookById(String bookId)`**  
  Finds a book by its ID by searching through printed books, ebooks, and audiobooks. Returns the book if found, or `null` if not.

- **`findBooksByTitle(String title)`**  
  Finds books by their title by searching through printed books, ebooks, and audiobooks. Returns a list of books that match the title.

- **`findBookByTitle()`**  
  Allows the user to find books by their title. Displays the results if found, and handles retry or exit options if no match is found.

- **`findBookById()`**  
  Allows the user to find a book by its ID. Displays the result if found, and handles retry or exit options if no match is found.

---

- **Remove Methods**

- **`removeBookById()`**  
Prompts the user to enter a Book ID for deletion. Validates the input, finds the book, and confirms the deletion before removing it from the system. Handles invalid inputs and allows retrying or exiting.

- **`removeBookByTitle()`**  
Prompts the user to enter a Book Title for deletion. Displays a list of matching books, allows the user to select one, confirms the deletion, and then removes the selected book. Handles invalid inputs and allows retrying or exiting.

- **`confirmAndDelete(Book book)`**  
Displays the details of the book to be deleted for confirmation. Removes the book from its respective category list and the main all-books list upon confirmation. Cancels deletion if the user does not confirm.

---

### **Sort Methods**

- **`sortBooks(ArrayList<T> books, String sortBy)`**  
A private utility method to sort a list of books based on the given criteria. Sorting options include:  
- **`"titleasc"`**: Sorts by title in ascending order.  
- **`"titledesc"`**: Sorts by title in descending order.  
- **`"author"`**: Sorts by author name in ascending order.  
- **`"priceasc"`**: Sorts by price in ascending order.  
- **`"pricedesc"`**: Sorts by price in descending order.  
- **`"genre"`**: Sorts by genre in ascending order.  
- **`"pages"`**: Sorts printed books by page count.  
- **`"filesize"`**: Sorts ebooks by file size.  
- **`"duration"`**: Sorts audiobooks by duration.  
- Default behavior sorts books by their ID.

- **`sortAllBooks(String sortBy)`**  
Sorts the entire collection of books based on the specified criteria.

- **`sortPrintedBooks(String sortBy)`**  
Sorts the list of printed books based on the specified criteria.

- **`sortEbooks(String sortBy)`**  
Sorts the list of ebooks based on the specified criteria.

- **`sortAudiobooks(String sortBy)`**  
Sorts the list of audiobooks based on the specified criteria.

---

#### **Statistics Methods**

- **`printMenu()`**  
  Displays the statistics menu and handles user input for selecting different stats to view. This method allows the user to choose between viewing statistics for all books, printed books, ebooks, or audiobooks, and then navigates to the corresponding section.

- **`printStatsAll()`**  
  Displays overall statistics for all books, including the total number of books, the most and least expensive books, and the average price. The method retrieves this information by calling helper methods and outputs the results to the console.

- **`printStatsPrinted()`**  
  Displays statistics specifically for printed books, including details such as the most expensive book, the least expensive book, the longest and shortest books, and the average price. The method uses helper methods to retrieve relevant data and outputs the results to the console.

- **`printStatsEbook()`**  
  Displays statistics specifically for ebooks, including the most expensive ebook, the least expensive ebook, the largest and smallest file sizes, and the average price. The method calculates and outputs these statistics to the console.

- **`printStatsAudiobook()`**  
  Displays statistics specifically for audiobooks, including the most expensive audiobook, the least expensive audiobook, the longest and shortest audiobooks, and the average price. The method gathers and displays these statistics for audiobooks.

- **`getTotalBooks(String type)`**  
  Returns the total number of books for a given type (Printed Book, Ebook, Audiobook, or All). This method determines the correct book list based on the input type and returns its size.

- **`getAveragePrice(String type)`**  
  Returns the average price of books for a given type (Printed Book, Ebook, Audiobook, or All). The method calculates the average price by streaming through the respective book list and returns the result rounded to two decimal places.

- **`getPrintedStats(String field)`**  
  Returns the book with the specified field for printed books (e.g., max price, min price, max pages, min pages). This method uses streams to sort and return the printed book with the specified attribute.

- **`getEbookStats(String field)`**  
  Returns the book with the specified field for ebooks (e.g., max price, min price, largest file size, smallest file size). The method sorts and retrieves the ebook with the specified attribute using streams.

- **`getAudiobookStats(String field)`**  
  Returns the book with the specified field for audiobooks (e.g., max price, min price, longest, shortest). This method uses streams to find and return the audiobook with the specified attribute.

- **`getBookStats(String field)`**  
  Returns the book with the specified field for all books (e.g., max price, min price). This method is used for fetching the highest or lowest priced book across all book types.

---

## Roadblocks and Unfinished Functionality

While the core functionality of the application is complete, there were a few challenges and areas that could be improved upon:

- **Persistence:** The application does not currently save data after the application is closed. Implementing file-based storage or a database would make the application more robust.
- **Error Handling:** More comprehensive error handling could be implemented, especially for user inputs.
- **Advanced Text Formatting:** Better color-coding for menus and display tables to make the user experience more crisp and easier to read.

If I were to work on this project again, I would focus on implementing data persistence and improving error handling for a smoother user experience.

## Resources

- [Tutorialspoint](https://www.tutorialspoint.com/java/) - Java Tutorials site I found helpful.
- [Oracle Java Documentation](https://docs.oracle.com/javase/8/docs/api/) - Java API documentation for reference.
- [Stack Overflow](https://stackoverflow.com/questions/tagged/java) - A community-driven Q&A site for Java-related questions that I consulted many times throughout the development
- [ChatGPT](https://chatgpt.com) - AI-driven coding assistant
- [W3Schools](https://www.w3schools.com/java) - Many helfpul Java tutorials
- [GeeksforGeeks](https://www.geeksforgeeks.org/java/) - Java tutorials laid out in approachable way. I used it to learn about Java Object methods and ArrayList.
- [ScreenToGif](https://www.screentogif.com/) - App for creating gifs

