package Aufgaben.Kapitel5.Example;

public class ChristmasTree extends Tree implements Lightable {
    private int treeBalls;
    private int stars;
    private boolean lighted;
    private static int cnt = 0;

    public ChristmasTree(int height, String sort, int balls, int stars) throws Exception {
        super(height, sort);
        if (balls <= 0 || stars <= 0) {
            throw new Exception("Sorry but a christmas tree needs stars and balls");
        }
        this.treeBalls = balls;
        this.stars = stars;
        this.lighted = false;
        cnt++;
    }

    public int getBalls() {
        return treeBalls;
    }

    public void setBalls(int balls) {
        this.treeBalls = balls;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public boolean isLighted() {
        return lighted;
    }

    @Override
    public boolean turnLightsOn() {
        if (lighted) {
            return false;
        } else {
            lighted = true;
            return true;
        }
    }

    @Override
    public boolean turnLightsOff() {
        if (!lighted) {
            return false;
        } else {
            lighted = false;
            return true;
        }
    }

    public static int getChristmasTreeCount() {
        return cnt;
    }

    public String toString() {
        return super.toString() + ", treeBalls: " + treeBalls + ", stars: " + stars + ", lighted: " + lighted;
    }
}