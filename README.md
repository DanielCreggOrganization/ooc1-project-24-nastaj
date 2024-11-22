[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=17272459)
# OOC1 Project

**Title:** Library Management System (Booklet)
**Name:** Jakub Nasta 
**Student ID:** G00424689  

## Application Function

Discuss what the application does.

## Running the Application

Provide step by step instructions on how to run your applicaiton. Are there any prerequisite softwares required?

```list
List the instructions step by step
    1. Go to the Main class and press execute
    2. Do something else
            :
            :
```

## Minimum Project Requirements

Describe how you have met all minimum project requirements below:

* The repository contains, at minimum, two commits per week (Note: There should be many commits per day coding).
* The project, including code and documentation, is fully contained in the provided GitHub Classroom repository.
* Methods = Add Item, Remove Item, Update Item, Find total items, Search Items and Quit.
* The code MUST compile.
* The application code must be formatted in a consistent and standard way.
* The code must contain comments. One comment per class, method and variable at minimum.
* The documentation and commentary must be free of a grammar and speling mistakes.

## Project Requirements above and beyond

Discuss any application features or design elements that show you went above and beyond basic requirements.

## Application Architecture

Discuss in detail how the application is structured. List all classes and describe their purpose. List all methods and describe what they do.

## Roadblocks and Unfinished Functionality

What did you not get finished? Discuss the issues you faced when creating your application Provide possible solutions to these issues. What would you have done differently if you had to do this project again?

## Resources

Provide links to resources used:

* [Tutorialspoint](https://www.tutorialspoint.com/java/) - Java Tutorials site I found helpful

## Features
* Main Menu - Main.java
    - ASCII art
    - Title (Booklet)
    - Manage Library
    - View Statistics
    - Exit

* Book Manager - BookManager.java
    - Add a Book
        - Book/Ebook/Audiobook?
            * Prompt for data
                - Log data back to user (Is everything correct?)
                    - Y: Book/Ebook/Audiobook added successfully!
                    - N: Go back to prompting   

    - Remove a Book
        - By ID/Name?
            - List specified book (Are you sure?)
                - Y: Book deleted successfully.
                - N: Go back to prompting for ID/Name

    - Show All Books
        - Books?
        - Audiobooks?
        - Ebooks?
        - Show All?

        - Default sort alphabetically
        - Filter by Name/Author/Price/Genre/Number of Pages/Publication Year
        - Return number of books in collection

* Statistics - Statistics.java
    - Total Number of Books
    - Most Expensive Book
    - Least Expensive Book
    - Average Book Price
    - Books Published After a Specific Year
    - Back to Main Menu

## External Libraries
https://github.com/lalyos/jfiglet