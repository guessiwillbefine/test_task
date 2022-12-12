package ua.vadim.test_assignment.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PersonDTO {
    private String name;
    private String surname;
    private int age;
}
