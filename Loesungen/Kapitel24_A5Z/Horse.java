package Loesungen.Kapitel24_A5Z;

public class Horse extends Mammal implements Movement {
    private boolean horseshoe;

    public Horse(int size, String sound, boolean horseshoe) {
        super(size, sound, "Pferd");
        this.horseshoe = horseshoe;
    }

    public boolean hasHorseshoe() {
        return horseshoe;
    }

    public void setHorseshoe(boolean horseshoe) {
        this.horseshoe = horseshoe;
    }

    @Override
    public void move() {
        System.out.println("Das Pferd gallopiert.");
    }

    public static void main(String[] args) {
        Horse horse = new Horse(200, "wiiiieeeha", true);
        horse.communicate();
        if (horse.hasHorseshoe()) {
            System.out.println("Das Pferd hat Hufeisen.");
        } else {
            System.out.println("Das Pferd hat keine Hufeisen.");
        }
    }
}
