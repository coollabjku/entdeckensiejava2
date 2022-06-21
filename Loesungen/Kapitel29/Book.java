package Loesungen.Kapitel29;

// Aufgabe 66
public class Book extends Product {
    private String isbn;
    private int pages;
    private String author;

    public Book(String name, double price, int amount, int productID, String isbn, int pages, String author) {
        super(name, price, amount, productID);
        this.isbn = isbn;
        this.pages = pages;
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
