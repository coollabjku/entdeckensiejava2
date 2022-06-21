package Aufgaben.Kapitel14.Example;

public class Cat {
    private String name;
    private int age;

    public Cat(String name) {
        this.name = name;
        this.age = setRandomAge();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    private int setRandomAge() {
        return (int) (Math.random() * 100 % 14) + 1;
    }
}
