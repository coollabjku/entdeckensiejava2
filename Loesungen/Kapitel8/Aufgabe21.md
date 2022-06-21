## 3. Überlegungen zur anderen / besseren / effektiveren Gestaltung des Programms
* Programme bestehen in der Regel aus einem Eingabeteil, einem Ausgabeteil und
einem Teil, in dem die Daten verarbeitet werden. Diese Struktur kann auf den Code
abgebildet werden, indem man eigene Methoden für das Einlesen und die Ausgabe
der Daten schreibt. Solche Methoden könnten printTable() oder readData()
heißen. In der Methode printTable() könnte man den Kopf und den
Tabelleninhalt ausgeben. Das Bilden solcher Funktionsblöcke verbessert die
Lesbarkeit des Programms und dient der Dokumentation.
* Im Eingabeteil ist eine regelbasierte Belegung des Wochenplans implementiert. In
der Praxis wird eine solche Belegung häufig nicht anwendbar sein. Alternativ dazu
könnte die Eingabe der Daten mit Hilfe einer Datei umgesetzt werden oder man
könnte im Code das Array tageweise mit den Fächern belegen.
* Bei der Datenausgabe wird im Programm der Tabulator zum Ausrichten der Spalten
eingesetzt. Aufgrund der unterschiedlichen Länge der Strings entspricht der
optische Eindruck nicht unbedingt den Erwartungen. Die Ausgabe könnte mit der
Methode printf() optimiert werden.
* Die Namen der einzelnen Fächer werden in einem String-Array gespeichert. Zum
Indizieren werden Konstanten (mathe, ite, ...) verwendet. Durch den indirekten
Zugriff auf String-Elemente des Arrays über diese Konstanten entsteht einerseits
zusätzliche Komplexität. Andererseits kann beispielsweise die Kurzform des
Namens eines Fachs auf die vollständige Fachbezeichnung abgebildet werden.
(int eng = 2; Fach[eng] → „Englisch“). Dadurch dass nicht immer der
vollständige Namen des Fachs eingegeben werden muss, können Schreibfehler
vermieden werden und man hat die Zusicherung, dass ein bestimmter
Unterrichtsgegenstand immer mit dem selben Namen bezeichnet wird. Die Effizienz
bei der Benutzung des Programms und die Konsistenz können durch solche
Programmgestaltungen gesteigert werden.

Die oben erwähnte Indirektion kann umgangen werden, indem die einzelnen Fächer
in String- Konstanten abgelegt werden. Eine weitere recht konventionelle und damit
lesbare Lösung wäre die Verwendung von Enumerationen.

## 4. Versuche einen komfortableren und übersichtlicheren Wochenplan zu programmieren
Version 1
```Java
public class Stundenplan {
    final static int STUNDEN = 10, ERSTE_STUNDE = 8;
    final static String[] TAGE = { "Montag", "Dienstag", "Mittwoch", "Donnnerstag", "Freitag" };
    static final String FACH_EN = "Englisch";
    static final String FACH_MA = "Mathematik";
    static final String FACH_IT = "Italienisch";

    public static void main(String[] args) {
        String[][] plan = new String[TAGE.length][STUNDEN];
        for (int i = 0; i < plan.length; i++) {
            plan[i][3] = FACH_MA;
        }
        plan[0][0] = FACH_EN;
        plan[0][1] = FACH_IT;
        plan[0][2] = FACH_MA;
        plan[1][0] = FACH_EN;
        plan[1][1] = FACH_MA;
        plan[1][4] = FACH_IT;
        plan[2][0] = FACH_IT;
        plan[2][2] = FACH_EN;
        // Tabellenkopf
        System.out.print("Stunde | ");
        for (String tag : TAGE)
            System.out.printf("%-15s | ", tag);
        System.out.println("\n");
        // Tabelleninhalt
        for (int stunde = 0; stunde < STUNDEN; stunde++) {
            System.out.printf("%02d | ", stunde + ERSTE_STUNDE);
            for (int day = 0; day < TAGE.length; day++) {
                String fach = plan[day][stunde];
                System.out.printf("%-15s | ", fach == null ? "---" : fach);
            }
            System.out.println();
        }
    }
}
```
Version 2
```Java
public class Stundenplan {
    final static int STUNDEN = 10, ERSTE_STUNDE = 8;
    final static String[] TAGE = { "Montag", "Dienstag", "Mittwoch", "Donnnerstag", "Freitag" };

    enum Fach {
        MA("Mathematik"), EN("Englisch"), IT("Italienisch");

        private String name;

        Fach(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {
        Fach[][] plan = new Fach[TAGE.length][STUNDEN];
        for (int i = 0; i < plan.length; i++) {
            plan[i][3] = Fach.MA;
        }
        plan[0][0] = Fach.EN;
        plan[0][1] = Fach.IT;
        plan[0][2] = Fach.MA;
        plan[1][0] = Fach.EN;
        plan[1][1] = Fach.MA;
        plan[1][4] = Fach.IT;
        plan[2][0] = Fach.IT;
        plan[2][2] = Fach.EN;
        // Tabellenkopf
        System.out.print("Stunde | ");
        for (String tag : TAGE)
            System.out.printf("%-15s | ", tag);
        System.out.println("\n");
        // Tabelleninhalt
        for (int stunde = 0; stunde < STUNDEN; stunde++) {
            System.out.printf("%02d | ", stunde + ERSTE_STUNDE);
            for (int day = 0; day < TAGE.length; day++) {
                String fach = plan[day][stunde] == null ? "---" : plan[day][stunde].getName();
                System.out.printf("%-15s | ", fach);
            }
            System.out.println();
        }
    }
}
```
In der ersten Version wird die oben erwähnte Indirektion umgangen, indem die einzelnen
Fächer in String-Konstanten (FACH_MA, FACH_EN, ...) abgelegt werden. Erfolgt die
Belegung des plan-Arrays nur über diese Konstanten ist Konsistenz in Bezug auf die
Namensgebung der Fächer gewährleistet.

Für Interessierte:

In der zweiten Version werden die Fächer in einem Aufzählungstyp (enum) gespeichert.
Diese Datenstruktur wird verwendet, um konstante Daten die inhaltlich
zusammengehören, zu speichern. Das plan-Array ist nicht mehr vom Typ String sondern
besitzt den Typ der Enumeration (Fach). Damit ist sicher gestellt, dass im Stundenplan nur
in der Enumeration vereinbarte Strings ausgegeben werden können.