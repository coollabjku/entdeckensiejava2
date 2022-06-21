package Aufgaben.Kapitel34;

public class ChristmasTreeRun {
    public static void main(String[] args) {
        try {
            ChristmasTree t1 = new ChristmasTree(3, 4);
            ChristmasTree t2 = new ChristmasTree(-3, -4);
            System.out.println(t1.toString());
            System.out.println(t2.toString());
        } catch (NotEnoughDecorationException e) {
            e.printStackTrace();
        }
    }
}
