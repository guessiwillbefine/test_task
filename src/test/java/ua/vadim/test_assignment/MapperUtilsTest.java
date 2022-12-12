package ua.vadim.test_assignment;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ua.vadim.test_assignment.util.mapper.MapperUtils;

import java.time.LocalDate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MapperUtilsTest {
    @ParameterizedTest
    @MethodSource("testCases")
    void testValidAgeCalculation(LocalDate birth, int expectedAge){
        assertEquals(expectedAge, MapperUtils.toAge(birth));
    }

    static Stream<Arguments> testCases(){
        return Stream.of(
                Arguments.of(LocalDate.of(2001, 6,30), 21),
                Arguments.of(LocalDate.of(2000, 3,12), 22),
                Arguments.of(LocalDate.of(2006, 9,14), 16),
                Arguments.of(LocalDate.of(2000, 12,12), 22)
        );
    }
}
