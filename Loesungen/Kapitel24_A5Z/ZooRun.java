package Loesungen.Kapitel24_A5Z;

public class ZooRun {
    public static void main(String[] args) {
        Cat k1 = new Cat("Gizmo", 4, false);
        Cat k2 = new Cat("Clarence", 3, true);
        Cat k3 = new Cat("Garfield", 6, false);
        Dog h1 = new Dog("Timo", 2);
        Dog h2 = new Dog("Cody", 6);
        Lion l1 = new Lion("Simba", 2);
        Lion l2 = new Lion("Nala", 3);
        Animal[] Animal = { l1, k1, k2, h1, k3, l2, h2 };
        for (Animal t : Animal) {
            if (t instanceof Pet) {
                ((Pet) t).pet();
            } else {
                System.out.println(t.getName() + " ist kein Haustier");
            }
        }
    }
}