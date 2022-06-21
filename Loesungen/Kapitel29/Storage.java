package Loesungen.Kapitel29;

//Aufgabe 66
public class Storage {

    private Product[] products;
    private String location;

    public Storage(String location) {
        this.location = location;
        this.products = null;
    }

    public void addProdukt(Product p) {
        if (this.products == null) {
            this.products = new Product[] { p };
        } else {
            Product[] tmp = new Product[this.products.length + 1];
            for (int i = 0; i < this.products.length; i++) {
                tmp[i] = this.products[i];
            }
            tmp[tmp.length - 1] = p;
            this.products = tmp;
        }
    }

    public int getInventory() {
        int sum = 0;
        for (Product p : this.products) {
            sum += p.getAmount();
        }
        return sum;
    }

    public double calculateInventoryValue() {
        double inventoryValue = 0;
        for (Product p : this.products) {
            inventoryValue += p.getPrice() * p.getAmount();
        }
        return inventoryValue;
    }

    public Product[] getProducts() {
        return this.products;
    }

    public String getInventoryRegister() {
        String result = "Lager: " + this.location + "\n";
        for (Product p : this.products) {
            result = result + p.toString() + "\n";
        }
        return result;
    }
}