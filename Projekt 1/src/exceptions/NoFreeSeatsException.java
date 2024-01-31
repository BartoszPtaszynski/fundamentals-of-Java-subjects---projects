package exceptions;

public class NoFreeSeatsException extends Exception{
    public NoFreeSeatsException(String message) {
        super(message);
    }
}
