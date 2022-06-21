## 1.Lesen Sie das obige Beispiel für Interfaces durch und schreiben Sie einen „Schwindelzettel“ mit den wesentlichen Informationen zu Interfaces.

## 2. Was wird auf der Konsole ausgegeben?
Ausgabe: Der Fisch Dora schwimmt im Meer.

## 3. Was bedeuten die Keywords interface und implements?
Mit dem Schlüsselwort interface wird eine Schnittstelle definiert. Eine von diesem
Interface abgeleitete, nicht abstrakte Klasse muss alle im Interface deklarierten
Methoden implementieren. In einer abgeleiteten abstrakten Klasse können die
Methoden implementiert werden oder als abstrakt deklariert werden.
Mit dem Schlüsselwort implements wird angegeben, welche Interfaces zu einer
Klasse gehören.

## 4. Wodurch unterscheidet sich eine normale Klasse von einem Interface?
In einem Interface gibt es nur Konstanten und nicht-implementierte Methoden. Alle
Methoden sind implizit public und abstract.
In einer normalen, nicht abstrakten Klasse sind alle Methoden implementiert, es gibt
nicht nur Konstanten, sondern auch Variablen und die Sichtbarkeit von Variablen
und Methoden muss nicht public sein.

## 5. Was passiert, wenn eine Klasse ein Interface implementiert?
Wenn eine Klasse ein Interface implementiert, müssen alle Methoden, die im
Interface deklariert sind, implementiert oder als abstract deklariert werden. 

## 6. Schreiben Sie eine Klasse Vogel, die ebenfalls das Interface Movement implementiert. Die Klasse Bird soll wie Fish eine Variable name besitzen und diese im Konstruktor initialisieren. Die Methode move() soll z.B. auf der Konsole ausgeben: "Der Vogel Tweety fliegt durch die Luefte." Testen Sie ihre Implementierung in einer kurzen Main Methode.
```Java
public interface Movement {
    public void move();
}

public class Fish implements Movement {
    private String name;

    public Fish(String name) {
        this.name = name;
    }

    public void move() {
        System.out.println("Der Fisch " + this.getName() + " schwimmt im Meer.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Fish fisch1 = new Fish("Dora");
        fisch1.move();
    }
}

public class Bird {
    private String name;

    public Bird(String name) {
        this.name = name;
    }

    public void move() {
        System.out.println("Der Vogel " + this.getName() + " fliegt durch die Luefte.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Bird vogel1 = new Bird("Tweety");
        vogel1.move();
    }
}
```
## 7. Implementieren Sie das Interface Fortbewegung in die Klassen von Aufgabe 9 (Klasse Horse, Elephant und Sheep).
```Java
public class Elephant extends Mammal implements Movement {
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

    @Override
    public void move() {
        System.out.println("Der Elefant trampelt.");
    }

    public static void main(String[] args) {
        Elephant elephant = new Elephant(200, "töröööööö", 4500);
        elephant.communicate();
        System.out.println("Der Elefant ist " + elephant.getWeight() + " kg schwer.");
    }
}
```
Analog sind die Klassen Horse und Sheep zu implementieren.