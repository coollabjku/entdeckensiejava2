package Aufgaben.Kapitel20;

public class BasicCounterRun {
    public static void main(String[] args) {
        BasicCounter a = new BasicCounter();
        BasicCounter b = new BasicCounter();
        System.out.println("a=" + a.getValue());
        System.out.println("b=" + b.getValue());
        a.count();
        System.out.println("a=" + a.getValue());
        System.out.println("b=" + b.getValue());
        a.reset();
        System.out.println("a=" + a.getValue());
    }
}
