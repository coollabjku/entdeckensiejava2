package Loesungen.Kapitel14;

public class LaptopRun {
    public static void main(String[] args) {
        Laptop l1 = new Laptop("hp");
        l1.browse1(10);
        System.out.println(l1.getBattery());
        l1.charge();
        l1.browse1(3);
        System.out.println(l1.getBattery());
    }
}