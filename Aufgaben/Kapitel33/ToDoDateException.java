package Aufgaben.Kapitel33;

/**
 * A ToDoDateException can be thrown by the {@link ToDoDate} constructor.
 *
 * @author ESOP Team 2012
 */
public class ToDoDateException extends RuntimeException {
    public ToDoDateException(String message) {
        super(message);
    }
}
