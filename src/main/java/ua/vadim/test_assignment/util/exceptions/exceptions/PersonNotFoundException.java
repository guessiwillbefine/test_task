package ua.vadim.test_assignment.util.exceptions.exceptions;

/**
 * exception that can be thrown if Person was not found in database
 */
public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException(String message) {
        super(message);
    }
}
