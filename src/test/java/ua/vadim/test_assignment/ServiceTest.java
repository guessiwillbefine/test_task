package ua.vadim.test_assignment;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import ua.vadim.test_assignment.model.Person;
import ua.vadim.test_assignment.repository.PersonRepository;
import ua.vadim.test_assignment.service.PersonService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@AutoConfigureMockMvc
class ServiceTest {
    private final PersonService personService;
    @MockBean
    private PersonRepository personRepository;
    @BeforeTestClass
    public void setUp() {
        Person bale = new Person(1, "christian", "bale", LocalDate.of(1974,1,30));
        Person leto = new Person(2, "jared", "leto", LocalDate.of(1971,12,26));

        Mockito.when(personRepository.findById(bale.getId()))
                .thenReturn(Optional.of(bale));

        Mockito.when(personRepository.findAll())
                .thenReturn(List.of(bale, leto));
    }
    @Autowired
    ServiceTest(PersonService personService) {
        this.personService = personService;
    }

    @Test
    void testExistingPersons() {
        List<Person> persons = personRepository.findAll();
        for (Person p : persons) {
            assertTrue(personService.findById(p.getId()).isPresent());
        }
    }
}
