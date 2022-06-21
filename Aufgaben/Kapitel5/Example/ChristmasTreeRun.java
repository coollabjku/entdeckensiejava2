package Aufgaben.Kapitel5.Example;

public class ChristmasTreeRun {
    public static void main(String[] args) {
        try {
            Tree t1 = new Tree(160, "Fichte");
            Tree t2 = new Tree(170, "Foehre");
            ChristmasTree ct1 = new ChristmasTree(190, "Blaufichte", 20, 10);
            System.out.println(t1);
            System.out.println(t2);
            System.out.println(ct1);
            ct1.turnLightsOn();
            System.out.println(ct1);
            System.out.println("There are already " + Tree.getTreeCount() + " trees.");
            ChristmasTree ct2 = new ChristmasTree(210, "Tanne", 0, 23);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}