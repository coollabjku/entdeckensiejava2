package Loesungen.Kapitel27;

public class ComputerRun {
    public static void main(String[] args) {
        Tablet t1 = new Tablet("192.168.0.1", 700, 256, true);
        Tablet t2 = new Tablet("192.168.0.2", 1200, 512, false);
        Laptop l1 = new Laptop("192.168.0.3", 3200, 4096, 14);
        Laptop l2 = new Laptop("192.168.0.4", 2800, 2048, 14);
        Computer c1 = new Computer("192.168.0.5", 3600, 4096);
        Computer[] network = { t1, l1, l2, c1, t2 };
        for (Computer c : network) {
            System.out.println("Network has device " + c.getIpAddress());
            if (c instanceof Chargeable) {
                ((Chargeable) c).charge(60);
                System.out.println("Mobile device " + c.getIpAddress() + " is now fully charged");

            }
        }
    }
}