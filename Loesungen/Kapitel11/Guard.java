package Loesungen.Kapitel11;

// Aufgabe 31
public class Guard {
    private int age;
    private boolean sick;

    public Guard(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public boolean isSick() {
        return sick;
    }

    public void updateHealthStatus() {
        sick = Math.random() < 0.15;
    }

    @Override
    public String toString() {
        return "[" + age + "," + sick + "]";
    }
}