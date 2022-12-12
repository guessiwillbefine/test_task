package ua.vadim.test_assignment.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ua.vadim.test_assignment.model.Person;
import ua.vadim.test_assignment.model.dto.PersonDTO;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "age",
            expression = "java(MapperUtils.toAge(person.getBirth()))")
    PersonDTO map(Person person);
}
