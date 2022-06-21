package Loesungen.Kapitel11;

// Aufgabe 33
public class PrisonSimulator {
    public static void main(String[] args) {
        Guard[] guards = new Guard[25];
        for (int i = 0; i < guards.length; i++) {
            int age = 18 + (int) (Math.random() * 38);
            guards[i] = new Guard(age);
        }
        Prison p = new Prison(guards);
        final int N = 50;
        int firstDayOfBreak = Integer.MAX_VALUE;
        int safeIterations = 0;
        for (int n = 0; n < N; n++) {
            boolean safe = true;
            for (int day = 0; day < 1000; day++) {
                p.nextDay();
                if (!p.isSafe()) {
                    safe = false;

                    if (day < firstDayOfBreak) {
                        firstDayOfBreak = day;
                    }
                }
            }
            if (safe) {
                safeIterations++;
            }
        }
        System.out.printf("The earliest jail break happened after " + "%d days\r\n", firstDayOfBreak);
        System.out.printf("The prison was safe %d out of " + "%d times.\r\n", safeIterations, N);
    }
}