package Loesungen.Kapitel35;

public class Category {
    private String name;
    private int floor;
    private final int computerSpots = 6;
    private Book[] books;

    // Aufgabe 77
    public Category(String name, int floor) {
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Kategorie braucht einen Namen");
        this.name = name;
        this.floor = floor;
        this.books = null;
    }

    public void addBook(Book book) {
        if (books == null) {
            books = new Book[1];
            books[0] = book;
        } else {
            Book[] temp = new Book[books.length + 1];
            for (int i = 0; i < books.length; i++) {
                temp[i] = books[i];
            }
            temp[books.length] = book;
            books = temp;
        }
    }

    public int getBookCount() {
        return books.length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getComputerSpots() {
        return computerSpots;
    }
}