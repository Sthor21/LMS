package model;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private boolean isAvailable;
    private String borrower;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
        this.borrower = null;
    }

    // Getters and setters
    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
        this.isAvailable = (borrower == null);
    }

    @Override
    public String toString() {
        return String.format("ISBN: %s, Title: %s, Author: %s, Available: %s",
                isbn, title, author, isAvailable);
    }
}