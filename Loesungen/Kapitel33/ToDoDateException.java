package Loesungen.Kapitel33;

/**
 * A ToDoDateException can be thrown by the {@link ToDoDateV2} constructor.
 *
 * @author ESOP Team 2012
 */
public class ToDoDateException extends RuntimeException {
    public ToDoDateException(String message) {
        super(message);
    }
}
