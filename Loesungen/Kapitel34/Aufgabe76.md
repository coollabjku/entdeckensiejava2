## 1. Lesen Sie das obige Beispiel für Exceptions durch und schreiben Sie einen „Schwindelzettel“ mit den wesentlichen Informationen zu Exceptions. Was wird auf der Konsole ausgegeben?
```Java
NotEnoughDecorationException: -3 balls are not enough and -4 stars are not enough
at ChristmasTree.<init>(ChristmasTree.java:10)
at MainChristmasTree.main(MainChristmasTree.java:7)
``` 
## 2. Was bedeuten die Keywords throw, throws, try, catch und finally?
*throw*: wird verwendet, um eine Exception auszulösen. Dabei kann es sich um eine
bereits vorhandene oder eine mit new erzeugte Exception handeln.
<br>
*throws*: gibt an, welche Exceptions eine Methode werfen kann. 
<br>
*try*: Kennzeichnet einen Block als try-Block. Tritt in diesem Block eine Exception auf,
und passt eine catch-Klausel zum Typ der Exception, wird die Ausführung des
Programms im entsprechenden catch-Block fortgesetzt. Wird die im try-Block
ausgelöste Excpetion im catch-Block nicht abgefangen, wird die Exception an die
aufrufende Methode weitergereicht.
<br>
*catch*: Die catch-Klausel wird verwendet, um die im try-Block ausgelösten
Exceptions abzufangen. Im catch-Block wird die Fehlerbehandlung implementiert.
Beispielsweise wird eine Fehlermeldung auf die Konsole geschrieben, es wird die
Möglichkeit einer wiederholten Benutzereingabe implementiert, Informationen zur
späteren Analyse in ein Log-File geschrieben, ... 
<br>
*finally*: Unabhängig davon, ob ein Fehler auftritt oder nicht, werden nach Abarbeitung
des try-catch Konstrukts die Instruktionen im finally Block abgearbeitet.

## 3. Was bewirkt die Methode printStackTrace(), was ist ein Stacktrace?
Bei jedem Methodenaufruf werden notwendige Informationen wie Parameter, lokale
Variablen, Rückgabewerte, Rücksprungadresse, ... auf einem Stack abgelegt. Dieser
Stack kann verwendet werden, um im Fehlerfall die Aufrufkaskade einer Methode zu
ermitteln. Mit der Methode printStacktrace() wird die Aufrufkaskade und die
Fehlerursache auf die Konsole geschrieben.
Im folgenden Beispiel wird in der main-Methode die Methode c() aufgerufen. c() ruft
die Methode b() auf, die ihrerseits die Methode a() aufruft. In der Methode a() tritt ein
Fehler auf. Das hat zur Folge, dass die Exception bis zur main-Methode durchgereicht
wird. Genau dieser Sachverhalt wird im Stacktrace dargestellt.
```Java
public class ExceptionTest {

    void a() {
        int x = 1 / 0;
    }

    void b() {
        a();
    }

    void c() {
        b();
    }

    public static void main(String[] args) {
        try {
            new ExceptionTest().c();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

```Java
Stacktrace:
java.lang.ArithmeticException: / by zero
ExceptionTest.a(ExceptionTest.java:4)
ExceptionTest.b(ExceptionTest.java:8)
ExceptionTest.c(ExceptionTest.java:12)
ExceptionTest.main(ExceptionTest.java:17)
```

## 4. Was ändert sich auf der Konsole, wenn Sie e.printStackTrace() mit System.err.println(e.getMessage()) ersetzen?
Es wird nur der String, der in der Methode getMessage() der Klasse
NotEnoughDecorationException erzeugt wird, ausgegeben, nicht aber der
Stacktrace:
```
-3 balls are not enough and -4 stars are not enough
```
## 5. Könnte man die Exception auch mittels IllegalArgumentException catch-Block abfangen und wenn ja/nein, warum/warum nicht?
Ja das geht, weil NotEnoughDecorationException von IllegalArgumentException abgeleitet ist.

## 6. Ergänzen Sie den try-catch Block mit einem finally-Block, der auf der Konsole "Programm wurde beendet" ausgeben soll.
```Java
public static void main(String[] args) {
    try {
        ...
    } catch (NotEnoughDecorationException e) {
        e.printStackTrace();
    } finally {
        System.out.println("Programm wurde beendet");
    }
}
```