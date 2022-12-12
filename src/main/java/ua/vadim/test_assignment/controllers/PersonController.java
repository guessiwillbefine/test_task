package ua.vadim.test_assignment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.vadim.test_assignment.model.Person;
import ua.vadim.test_assignment.model.dto.PersonDTO;
import ua.vadim.test_assignment.service.PersonService;
import ua.vadim.test_assignment.util.exceptions.exceptions.ErrorResponse;
import ua.vadim.test_assignment.util.exceptions.exceptions.PersonNotFoundException;
import ua.vadim.test_assignment.util.mapper.PersonMapper;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class PersonController {
    private final PersonService userService;
    @Autowired
    public PersonController(PersonService userService) {
        this.userService = userService;
    }

    /**
     * @param id - id of user
     * @return personDTO if user was found with 200ok status, or else throws PersonNotFoundException
     */
    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<PersonDTO> findById(@PathVariable long id) {
        Optional<Person> optionalPerson = userService.findById(id);
        if (optionalPerson.isPresent()) {
            PersonDTO dto = PersonMapper.INSTANCE.map(optionalPerson.get());
            return ResponseEntity.ok(dto);
        }
        throw new PersonNotFoundException(String.format("Person with id[%d] does not exist", id));
    }

    /**
     * handles PersonNotFoundException, so user will receive a response with 404 status
     */
    @ExceptionHandler(PersonNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ErrorResponse exceptionHandler(PersonNotFoundException exception) {
        return new ErrorResponse(exception.getMessage());
    }
}
