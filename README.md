# Library Management System (LMS)

This is a simple Library Management System (LMS) implemented in Java. The system allows you to manage books, track transactions such as borrowing and returning books, and store the data in text files. It provides basic features like searching books, adding new books, and tracking who borrowed a book.

## Features

- Add new books with ISBN, title, and author.
- Borrow and return books.
- Search books by title, author, or ISBN.
- Logs each transaction (e.g., adding a book, borrowing a book) in a text file.
- Saves book details in a text file to maintain data persistence.

## Installation

To run this project, follow the steps below:

### Prerequisites

- Java 11 or higher.
- Git (for cloning the repository).
- A text editor or IDE (such as Visual Studio Code or IntelliJ IDEA).

### Steps

1. **Clone the repository:**

   ```bash
   git clone https://github.com/YourUsername/LMS.git
2. **Navigate to the project directory**\
   cd LMS
3. **Compile all the files:**
    note:"compile the files from the root directory inorder to avoid package import fault"
    Command "javac service/Library.java"
            "javac model/Book.java"
            "javac main.java"
4. **Run the main file:**
   Command "java main"

**Usage**
Add a new book:
You can add a new book to the system by providing its ISBN, title, and author. The book will be added to the system and saved in the books.txt file.

Borrow a book:
Search for a book by its title, author, or ISBN. If the book is available, you can borrow it by entering the borrower's name. The transaction will be logged, and the availability status of the book will be updated.

Return a book:
If you have borrowed a book, you can return it by providing the ISBN of the book. The system will update the availability status of the book.

Search for a book:
You can search for a book using a keyword (title, author, or ISBN) and get a list of books that match the search criteria.

Contribution
Contributions are welcome! If you'd like to contribute, please fork the repository, create a new branch, make your changes, and submit a pull request.


**file structure**
LMS(parent directory)|-> model -> Book.java
                         service ->Library.java
                         Main.java
