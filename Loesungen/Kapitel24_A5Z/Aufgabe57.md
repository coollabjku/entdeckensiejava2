## 1. Lesen Sie das obige Beispiel für Vererbung durch und schreiben Sie einen „Schwindelzettel“ mit den wesentlichen Informationen zur Vererbung. Was wird auf der Konsole ausgegeben?
Schwindelzettel -
Konsolenausgabe:
Pferd macht wiiiieeeha
Das Pferd hat Hufeisen.

## 2. Was bedeuten die Keywords super() und extends?
super(): Aufruf des Konstruktors der Oberklasse
extends: Dient zur Bildung von Unterklassen
Beispiel:
```Java
class A {
    private int x;

    public A(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }
}

class A1 extends A {
    private int y;

    public A1(int x, int y) {
        super(x);
        this.y = y;
    }

    public int getY() {
        return y;
    }
}

public class Inheritance {
    public static void main(String[] args) {
        A1 o = new A1(3, 2);
        System.out.println(o.getX() + " " + o.getY());
    }
}
```
Mit extends wird festgelegt, dass A1 eine Unterklasse von A ist. Damit kann A1
Eigenschaften und Verhalten von A erben. Das heißt, dass öffentliche (public,
protetected, default) Methoden und Attribute in A von A1 verwendet werden können.
Im Beispiel erbt A1 die Methode getX() von A.
Mit super(x) wird in der Klasse A1 der Konstruktor der Klasse A aufgerufen.

## 3. Welche Methode/Methoden erbt die Subklasse Horse?
Die Subklasse Horse erbt von ihrer Oberklasse Mammal die Methode
```Java 
public void communicate().
```
-## 4. Schreiben Sie eine weitere Subklasse Elephant, die eine Variable weight enthält und diese im Konstruktor setzt. Ebenso sollen die anderen Variablen der Superklasse (size, sound, type) weitergegeben werden. Testen Sie die Klasse wie oben in einer kurzen Main Methode.
```Java
public class Elephant extends Mammal {
    private int weight;

    public Elephant(int size, String sound, int weight) {
        super(size, sound, "Elefant");
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int kg) {
        this.weight = kg;
    }

    public static void main(String[] args) {
        Elephant elephant = new Elephant(200, "töröööööö", 4500);
        elephant.communicate();
        System.out.println("Der Elefant ist " + elephant.getWeight() + " kg schwer.");
    }
}
```
## 5. Schreiben Sie eine weitere Klasse Sheep mit einer Variable color für die Fellfarbe.
```Java
public class Sheep extends Mammal {
    private String color;

    public Sheep(int size, String sound, String color) {
        super(size, sound, "Lamm");
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static void main(String[] args) {
        Sheep lamb = new Sheep(200, "bäääääääähhhh", "schwarz");
        lamb.communicate();
        System.out.println("Auf der Weide ist ein " + lamb.getColor() + " Lamm.");
    }
}
```