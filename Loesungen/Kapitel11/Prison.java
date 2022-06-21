package Loesungen.Kapitel11;

// Aufgabe 32
public class Prison {
    private Guard[] guards;

    public Prison(Guard[] guards) {
        this.guards = guards;
    }

    public void nextDay() {
        for (Guard g : guards) {
            g.updateHealthStatus();
        }
    }

    public boolean isSafe() {
        int activeGuards = 0;
        int activeOldGuards = 0;
        for (Guard g : guards) {
            if (!g.isSick()) {
                activeGuards++;
                if (g.getAge() > 40) {
                    activeOldGuards++;
                }
            }
        }
        return activeGuards >= 15 && activeOldGuards >= 2;
    }
}