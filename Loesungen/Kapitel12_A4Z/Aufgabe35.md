## 1. Methode prüft das Ende eines Strings
```Java
public static void main(String[] args) {
    String string = "JAVA.ProgrammersBase.NET";
    String search = "NET";

    System.out.println(string.endsWith(search));
}
```
## 2. Methode liefert ein Zeichen eines Strings
```Java
public static void main(String[] args) {
    String string = "0123456789";
    
    System.out.println(string.charAt(6));
}
```
## 3. Methode liefert eine Zeichensequenz eines Strings
```Java
public static void main(String[] args) {
    String string = "0123456789";

    System.out.println(string.substring(2,7));
}
```
## 4. Methode prüft, ob ein String mit einer speziellen Zeichenkette beginnt
```Java
public static void main(String[] args) {
    String string = "JAVA.ProgrammersBase.NET";
    String search = "NET";

    System.out.println(string.startsWith(search ));
    System.out.println(string.startsWith(search,21));
}
```