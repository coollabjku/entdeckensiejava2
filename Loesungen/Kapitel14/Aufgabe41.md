## 1. Markieren Sie die Konstruktoren? Welche Parameter bekommen sie, welche Variablen setzen sie? Welche Methoden haben die Klassen Katze und Hund? Was leisten sie?
Beide Konstruktoren haben einen String-Parameter name und setzen das in Zeile 2
deklarierte Feld name. Zusätzlich wird im Konstruktor der Klasse Katze das Feld
alter mit einem Zufallswert belegt.
Beide Klassen besitzen die Methode getName(), die den Wert des Feldes name
zurückgibt. Die Klasse Hund besitzt außerdem die Methode gibLaut(), mit der der
Wert des statischen Feldes laut („wuff“) ausgelesen werden kann.
Um in der Klasse Katze den Wert des Feldes alter abzufragen, kann auf die
öffentliche Methode getAlter() zugegriffen werden. Zudem stellt diese Klasse die
private Methode setZufallsalter() zur Verfügung. Mit dieser Methode kann eine
zufällig Ganzzahl zwischen 1 und 14 generiert und an den Aufrufer übergeben
werden. Diese private Methode wird genau einmal beim Erzeugen eines Objekts im
Konstruktor aufgerufen.

## 2. Gibt es in der Klasse Hund eine „versteckte“ get-Methode (die den selben Zweck wie eineget-Methode erfüllt, aber kein get im Namen aufweist)?
Eine get-Methode wird verwendet, um eine einzelne Eigenschaft eines Objekts
abzufragen. Die Methode gibLaut() der Klasse Hund gibt den Wert des Feldes
laut zurück. Ist also eine "versteckte" get-Methode.

## 3. Wozu gibt es die Methode setZufallsalter() in der Klasse Katze? Wie funktioniert sie? Warum ist es sinnvoll, diese Methode auf „private“ zu setzen?
Mit der Methode setZufallsalter() in der Klasse Katze wird eine zufällige
Ganzzahl zwischen 1 und 14 erzeugt. Zu diesem Zweck wird die Methode
Math.random() eingesetzt. Diese Methode liefert eine Zahl vom Typ double
zwischen 0.0 (inklusive) und 1.0 (exklusive). Multipliziert man diese Zahl mit 100
bekommt man einen Wert aus dem halboffenen Intervall [0, 100[. Durch Anwendung
der Modulo-Operation erzeugt man daraus einen Wert aus dem Intervall [0, 14[. Um
letztendlich eine Ganzzahl zwischen 1 und 14 zu bekommen wird dieser Wert auf
int gecastet und mit 1 addiert.

*Beachte:*
Die so berechneten Zufallszahlen sind nicht gleich verteilt. Die Werte 1 und 2 treten
mit der Wahrscheinlichkeit von 8/100 auf. Die Werte von 3 bis 14 treten mit einer
Wahrscheinlichkeit von 7/100 auf. Bei einer Gleichverteilung kommt jeder Wert mit
einer Wahrscheinlichkeit von 1/14 = 0.0714 vor.
Möchte man eine Gleichverteilung erreichen, könnte man folgende Berechnung
verwenden:
(int)(Math.random() * 14) + 1.
Die Methode setZufallsalter() ist private, weil sie nur innerhalb der Klasse vom
Konstruktor verwendet werden soll. Sie wird genau ein Mal beim Erzeugen eines
Objekts zum Setzen des Alters verwendet. Es ist sinnvoll für diese Methode keine
öffentliche Schnittstelle anzubieten, da ein Aufruf von außerhalb keine sinnvolle
Funktionalität zur Verfügung stellt. Ein Aufruf dieser Methode von außerhalb des
Objekts bewirkt keine Veränderung am Objekt, was im Widerspruch zum Namen
der Methode steht.

## 4. Welche Methoden der Klasse Hund und der Klasse Katze werden in der main-Methode verwendet? Wozu werden diese Methoden verwendet?
In der main-Methode werden alle öffentlichen Methoden der Klassen Hund und
Katze verwendet. Dies dient zum Erzeugen der Objekte und zum Abfragen ihrer
Eigenschaften.

## 5. Was wird auf der Konsole ausgegeben?
Der Hund Timo macht wuff.
Die Katze Garfield ist 11 Jahre alt.