## 2. Eigene Beispiele:
Zum Sortieren eines String-Arrays kann man die compareTo() Methode verwenden, um
zu entscheiden, ob zwei Elemente gemäß einer lexikographischen Ordnung richtig liegen,
oder noch vertauscht werden müssen:
```Java
if (a[i].compareTo(a[j]) > 0) {
	swap(i, j);
}
```
Bei der linearen Suche nach einem bestimmten Element im Array, kann die Methode
equals() eingesetzt werden:
```Java
String[] a = { "Hans", "Peter", "Klaus" };
String searchString = "Peter";
for (String s : a) {
    if (searchString.equals(s)) {
        System.out.println("Gefunden!");
        break;
    }
}
```
Im folgenden Beispiel wird mit equals() geprüft, ob ein Passwort richtig ist.
```Java
String pw = "qwertz123";
if (!"geheim".equals(pw)) {
    System.out.println("Access denied.");
}
```
Die replaceAll() Methode wird im folgenden Beispiel verwendet, um Umlaute und
Sonderzeichen in HTML-Namen zu übersetzen.
```Java
String s = "Nüsse Ösen Weiß Bär";
s = s.replaceAll("ä", "&auml;").
replaceAll("Ö", "&Ouml;").
replaceAll("ü", "&uuml;").
replaceAll("ß", "&szlig;");
```
Ausgabe: N&uuml;sse &Ouml;sen Wei&szlig; B&auml;r