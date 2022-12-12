package ua.vadim.test_assignment.util.exceptions.exceptions;

/**
 * response can be sent when exception handler catches something
 * @param response - message for response
 */
public record ErrorResponse(String response) {
}
