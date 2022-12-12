package ua.vadim.test_assignment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import ua.vadim.test_assignment.repository.PersonRepository;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@AutoConfigureMockMvc
class RepoTest {
    private final PersonRepository repository;

    @Autowired
    RepoTest(PersonRepository repository) {
        this.repository = repository;
    }

    @Test
    void testGetAllUsers(){
        assertTrue(repository.findAll().size() > 0);
    }
    @Test
    void getOneExistingUserTest(){
        assertTrue(repository.findById(1L).isPresent());
    }
    @Test

    void nonExistingIdShouldReturnEmptyOptional(){
        assertTrue(repository.findById(-1L).isEmpty());
    }
}
