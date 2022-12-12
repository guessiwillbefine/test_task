package ua.vadim.test_assignment.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ua.vadim.test_assignment.model.Person;
import ua.vadim.test_assignment.model.dto.PersonDTO;

import java.time.LocalDate;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "age",
            expression = "java(PersonMapper.toAge(person.getBirth()))")
    PersonDTO map(Person person);
    static int toAge(LocalDate birth) {
        int age = LocalDate.now().getYear() - birth.getYear();
        int currentMonth = LocalDate.now().getMonthValue();
        int currentDay = LocalDate.now().getDayOfMonth();
        int birthMonth = birth.getMonthValue();
        int birthDay = birth.getDayOfMonth();

        if ((currentMonth - birthMonth > 0) ||
                (currentMonth - birthMonth == 0 && currentDay - birthDay >= 0)) {
            return age;
        }
        return age + 1;
    }
}
