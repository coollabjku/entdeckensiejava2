package Aufgaben.Kapitel8.Example;

public class Schedule {
    final static int HourAllocation = 10, ErsteStd = 8, mathe = 0, ite = 1, englisch = 2;

    public static void main(String[] args) {
        String[] Days = { "Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag" };
        String[] Subject = { "Mathematik", "Italienisch", "Englisch" };
        String[][] Plan = new String[Days.length][HourAllocation];

        for (int day = 0; day < Days.length; day++)
            for (int hour = 0; hour < HourAllocation; hour++)
                Plan[day][hour] = "";

        for (int day = 0; day < Days.length; day++) {
            if (day != 2)
                Plan[day][0] = Subject[mathe];
            if ((day % 2) == 1)
                Plan[day][2] = Subject[ite];
            else
                Plan[day][2] = Subject[englisch];
        }

        for (int day = 0; day < Days.length; day++) {
            System.out.println(Days[day] + ":");
            for (int hour = 0; hour < HourAllocation; hour++) {
                if (!(Plan[day][hour]).equals(""))
                    System.out.println(" " + (hour + ErsteStd) + ":" + Plan[day][hour]);
            }
        }
    }
}