
package service;

import java.io.*;
import java.util.*;
import model.Book;

public class Library {
    private Map<String, Book> books;
    private List<String> transactions;
    private static final String TRANSACTION_FILE = "transactions.txt";
    private static final String BOOKS_FILE = "books.txt";

    public Library() {
        System.out.println("hi");
        books = new HashMap<>();
        transactions = new ArrayList<>();
        loadBooks();
    }

    public void addBook(String isbn, String title, String author) {
        Book book = new Book(isbn, title, author);
        books.put(isbn, book);
        logTransaction(String.format("Added book: %s", book));
        saveBooks();
    }

    public boolean borrowBook(String isbn, String borrower) {
        Book book = books.get(isbn);
        if (book != null && book.isAvailable()) {
            book.setBorrower(borrower);
            logTransaction(String.format("Book borrowed: %s by %s", book.getTitle(),
                    borrower));
            saveBooks();
            return true;
        }
        return false;
    }

    public boolean returnBook(String isbn) {
        Book book = books.get(isbn);
        if (book != null && !book.isAvailable()) {
            String borrower = book.getBorrower();
            book.setBorrower(null);
            logTransaction(String.format("Book returned: %s by %s", book.getTitle(),
                    borrower));
            saveBooks();
            return true;
        }
        return false;
    }

    public List<Book> searchBooks(String keyword) {
        keyword = keyword.toLowerCase();
        List<Book> results = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getTitle().toLowerCase().contains(keyword) ||
                    book.getAuthor().toLowerCase().contains(keyword) ||
                    book.getIsbn().toLowerCase().contains(keyword)) {
                results.add(book);
            }
        }
        return results;
    }

    private void logTransaction(String transaction) {
        String timestamp = new java.util.Date().toString();
        String logEntry = String.format("[%s] %s", timestamp, transaction);
        transactions.add(logEntry);

        try (PrintWriter writer = new PrintWriter(new FileWriter(TRANSACTION_FILE,
                true))) {
            writer.println(logEntry);
        } catch (IOException e) {
            System.err.println("Error logging transaction: " + e.getMessage());
        }
    }

    private void saveBooks() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(BOOKS_FILE))) {
            for (Book book : books.values()) {
                writer.printf("%s,%s,%s,%s,%s%n",
                        book.getIsbn(),
                        book.getTitle(),
                        book.getAuthor(),
                        book.isAvailable(),
                        book.getBorrower());
            }
        } catch (IOException e) {
            System.err.println("Error saving books: " + e.getMessage());
        }
    }

    private void loadBooks() {
        try (BufferedReader reader = new BufferedReader(new FileReader(BOOKS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 5) {
                    Book book = new Book(parts[0], parts[1], parts[2]);
                    if (!Boolean.parseBoolean(parts[3])) {
                        book.setBorrower(parts[4]);
                    }
                    books.put(book.getIsbn(), book);
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading books: " + e.getMessage());
        }
    }
}