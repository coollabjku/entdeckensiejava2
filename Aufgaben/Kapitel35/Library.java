package Aufgaben.Kapitel35;

public class Library {
    public static void main(String[] args) {
        Book b1 = new Book("The Art of Programming", "0321751043", "Donald E. Knuth", 3168);
        Book b2 = new Book("Algorithms", "032157351X", "Robert Sedgewick", 976);
        Book b3 = new Book("Head First Java", "0596009208", "Kathy Sierra", 720);
        Book b4 = new Book("Compilerbau", "978-3-486-25294-1", "Alfred V. Aho, Ravi Sethi, Jeffrey D. Ullman ", 568);
        // Aufgabe 77
        // TODO: Edit this code to handle the thrown exception here
        Category k1 = new Category("Informatik", 1);
        k1.addBook(b1);
        System.out.println("Momentan vorhandene Bücher: " + k1.getBookCount());
        k1.addBook(b2);
        System.out.println("Momentan vorhandene Bücher: " + k1.getBookCount());
        k1.addBook(b3);
        System.out.println("Momentan vorhandene Bücher: " + k1.getBookCount());
        k1.addBook(b4);
        System.out.println("Momentan vorhandene Bücher: " + k1.getBookCount());
    }
}
