package catalog.stepdefinitions;

public class NotLoggedInException extends AssertionError{

    public NotLoggedInException(String message) {
        super(message);
    }

    public NotLoggedInException(String message, Throwable cause) {
        super(message, cause);
    }
}
