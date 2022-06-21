package Loesungen.Kapitel9_A4;

public class StopWatchRun {
    public static void main(String[] args) {
        StopWatch st = new StopWatch();
        st.start();
        long result = 0;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            result += i;
            if (i % 100000000 == 0) {
                System.out.println("i=" + i);
            }
        }
        System.out.println("result=" + result);
        System.out.println(st.elapsedTime());
    }
}