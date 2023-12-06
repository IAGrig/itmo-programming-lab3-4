package exceptions;

public class MissingComponentException extends RuntimeException {
    public MissingComponentException(String message) {
        super(message);
    }
}
