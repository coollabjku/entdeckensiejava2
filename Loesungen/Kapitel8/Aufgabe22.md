## 2 Erklären Sie, was das Programm leistet.
Im Programm sind Verb-Listen in einem String-Array abgelegt. Das erste Wort eines
Listeneintrags ist ein deutschsprachiges Infinitiv. Das zweite Wort ist die Übersetzung
dieses Infinitivs ins Italienische. Die folgenden 6 Worte des Listeneintrags beschreiben die
italienischen konjugierten Verbformen im Präsens.

Ziel ist es, zu einem deutschsprachigen Infinitiv eine bestimmte italienische Verbform
abzufragen. Nach Eingabe des deutschsprachigen Infinitivs und eines Index, der für die
Person und den Numerus steht, wird das entsprechende konjugierte italienische Verb
ausgegeben.

Wird der Index 0 eingegeben, wird der gesamte Listeneintrag des jeweiligen Verbs
angezeigt.

Ist das eingegebene Wort nicht im Array enthalten wird nichts ausgegeben.

## 3 Das Programm funktioniert zwar, es ist aber nicht optimal. Wie könnten Sie es ausbauen bzw. verbessern? Beachten Sie dazu die Fragen der Anmerkung 1.
Die Benutzung des Programms kann verbessert werden, indem mehr als ein Wort
abgefragt werden kann, ohne das Programm jedes mal neu starten zu müssen.
Dieses Ziel wird erreicht, indem man den Benutzerdialog in einer Schleife
abarbeitet.
* Ein weiterer Punkt zur Steigerung der Anwendungsfreundlichkeit des Programms ist
die Fehlerbehandlung. Dazu gehört, dass der Anwender oder die Anwenderin bei
fehlerhaften Eingaben über die Art des Fehlers informiert wird und die Möglichkeit
einer Fehlerbehebung hat. Auch dieses Ziel kann durch die Führung des
Benutzerdialogs in einer Schleife erreicht werden.
* Statt eines Index, der für Person und Numerus steht, könnte man über die Konsole
ein Kürzel für Person und Numerus eingeben. Dadurch würde die Bedienung der
Anwendung intuitiver. (s1 für Singular 1. Person, p2, ...)

* In der Methode konjugierer() gibt es eine Verzweigung mit folgender Struktur:
```Java
if(c1 && c2) {
    A1
}
else if(c1) {
    A2
}
```
c1 ... Wort gefunden

c2 ... Zeige alle Konjunktionen

Die Bedingung c1 ist in beiden Bedingungen enthalten, kann also herausgezogen
werden:
```Java
if(c1) {
    if(c2) {
        A1
    }
    else {
        A2
    }
}
```
Die 2. Umsetzung der logischen Struktur gibt den Sachverhalt unmittelbarer wieder.
Erst wenn man die Zusicherung hat, dass ein Wort vorhanden ist, wird entschieden
wie die weitere Vorgehensweise ist.
* Zum Speichern der Wörter könnte man statt des Arrays eine Map verwenden. Das
Suchen von Schlüsseln ist bei einer Map wesentlich effizienter.