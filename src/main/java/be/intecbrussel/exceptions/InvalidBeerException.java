package be.intecbrussel.exceptions;

public class InvalidBeerException extends Exception {

    public InvalidBeerException() {
    }

    public InvalidBeerException(String message) {
        super(message);
    }
}
