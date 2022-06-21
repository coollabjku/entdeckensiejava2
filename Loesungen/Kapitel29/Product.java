package Loesungen.Kapitel29;

// Aufgabe 66
public class Product {
    private String name;
    private double price;
    private int amount;
    private int productID;

    public Product(String name, double price, int amount, int productID) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    @Override
    public String toString() {
        return "Produkt [name=" + name + ", preis=" + price + ", produktAnzahl=" + amount + ", produktID=" + productID
                + "]";
    }
}
