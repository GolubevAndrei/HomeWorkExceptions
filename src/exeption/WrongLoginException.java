package exeption;

public class WrongLoginException extends RuntimeException {
    public WrongLoginException(String massage) {
        super(massage);
    }
}
