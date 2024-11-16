package test.codingPart.programs.basicJava.exceptionHandling;

public class MyCustomException extends Exception {

    // Constructor without message
    public MyCustomException() {
    }

    // Constructor that accepts a message
    public MyCustomException(String message) {
        super(message);
    }

    // Constructor that accepts a message and a cause
    public MyCustomException(String message, Throwable cause) {
        super(message, cause);
    }
}
