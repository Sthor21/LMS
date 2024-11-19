
import java.util.Scanner;
import java.util.List;
import model.Book;
import service.Library;

public class main {
    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    borrowBook();
                    break;
                case 3:
                    returnBook();
                    break;
                case 4:
                    searchBooks();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n=== Library Management System ===");
        System.out.println("1. Add Book");
        System.out.println("2. Borrow Book");
        System.out.println("3. Return Book");
        System.out.println("4. Search Books");
        System.out.println("5. Exit");
    }

    private static void addBook() {
        System.out.println("\n=== Add New Book ===");
        String isbn = getInput("Enter ISBN: ");
        String title = getInput("Enter Title: ");
        String author = getInput("Enter Author: ");

        library.addBook(isbn, title, author);
        System.out.println("Book added successfully!");
    }

    private static void borrowBook() {
        System.out.println("\n=== Borrow Book ===");
        String isbn = getInput("Enter ISBN: ");
        String borrower = getInput("Enter Borrower Name: ");

        if (library.borrowBook(isbn, borrower)) {
            System.out.println("Book borrowed successfully!");
        } else {
            System.out.println("Book not available or not found.");
        }
    }

    private static void returnBook() {
        System.out.println("\n=== Return Book ===");
        String isbn = getInput("Enter ISBN: ");

        if (library.returnBook(isbn)) {
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("Book return failed. Check ISBN or if book is already returned.");
        }
    }

    private static void searchBooks() {
        System.out.println("\n=== Search Books ===");
        String keyword = getInput("Enter search keyword: ");
        List<Book> results = library.searchBooks(keyword);

        if (results.isEmpty()) {
            System.out.println("No books found.");
        } else {
            System.out.println("\nSearch Results:");
            for (Book book : results) {
                System.out.println(book);
            }
        }
    }

    private static String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}