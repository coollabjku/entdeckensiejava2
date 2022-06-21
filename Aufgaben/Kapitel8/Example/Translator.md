Anmerkung:
Das kyrillische Alphabet ist in UTF-8 codiert. Damit es in Eclipse angezeigt werden
kann, muss über Window/Preferences bei Workspace Text file encoding auf UTF-8
umgestellt werden. Buchstaben, die im lateinischen Alphabet keine Entsprechung
haben, sind folgendermaßen codiert:

Display UTF-8 Java Display UTF-8 Java
Ж {'1', 0x416}, ъ {'-', 0x44A},<br>
ж {'2', 0x436}, ь {'_', 0x44C},<br>
Ч {'3', 0x427}, Э {'9', 0x42D},<br>
ч {'4', 0x447}, э {'0', 0x44D},<br>
Ш {'5', 0x428}, Ю {'Q', 0x42E},<br>
ш {'6', 0x448}, ю {'q', 0x44E},<br>
Щ {'7', 0x429}, Я {'X', 0x42F},<br>
щ {'8', 0x449}, я {'x', 0x44F},<br>


Ausgabe:
```
Bitte Satz eingeben:
X u2inaq.
Я ужинаю.
Der Satz wurde erfolgreich umgesetzt.
```
