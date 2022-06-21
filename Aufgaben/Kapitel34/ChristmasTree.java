package Aufgaben.Kapitel34;

public class ChristmasTree {
    private int treeBalls;
    private int stars;
    private boolean lighted;

    public ChristmasTree(int balls, int stars) throws NotEnoughDecorationException {
        if (balls <= 0 || stars <= 0) {
            throw new NotEnoughDecorationException(balls, stars);
        }
        this.treeBalls = balls;
        this.stars = stars;
        this.lighted = false;
    }

    public String toString() {
        return "ChristmasTree, treeBalls: " + treeBalls + ", stars: " + stars + ", lighted: " + lighted;
    }
}
