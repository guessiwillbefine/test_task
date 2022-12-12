package ua.vadim.test_assignment.util.exceptions.exceptions;

public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException(String message) {
        super(message);
    }
}
