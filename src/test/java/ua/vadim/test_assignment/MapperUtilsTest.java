package ua.vadim.test_assignment;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ua.vadim.test_assignment.model.Person;
import ua.vadim.test_assignment.model.dto.PersonDTO;
import ua.vadim.test_assignment.util.mapper.PersonMapper;

import java.time.LocalDate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MapperUtilsTest {
    @ParameterizedTest
    @MethodSource("testCases")
    void mappingShouldBeCorrect(Person person, int expectedAge) {
        PersonDTO dto = PersonMapper.INSTANCE.map(person);
        assertEquals(person.getName(), dto.getName());
        assertEquals(person.getSurname(), dto.getSurname());
        assertTrue(dto.getAge() > 0);
        assertEquals(expectedAge, PersonMapper.toAge(person.getBirth()));
    }

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new Person(1L, "test1", "test1", LocalDate.of(2001, 6, 30)), 21),
                Arguments.of(new Person(1L, "test2", "test2", LocalDate.of(2000, 3, 12)), 22),
                Arguments.of(new Person(1L, "test3", "test3", LocalDate.of(2006, 9, 14)), 16),
                Arguments.of(new Person(1L, "test4", "test4", LocalDate.of(2000, 12, 12)), 22)
        );
    }
}
