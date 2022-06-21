package Loesungen.Kapitel9_A4;

public class PersonRun {
    public static void main(String[] args) {
        Person p1 = new Person("Vannevar", "Bush");
        Person p2 = new Person("Emma", "Bush");
        p1.setMother(p2);
        System.out.println(p1 + "'s mother: " + p1.getMother());
        System.out.println(p2 + "'s mother: " + p2.getMother());
    }
}
