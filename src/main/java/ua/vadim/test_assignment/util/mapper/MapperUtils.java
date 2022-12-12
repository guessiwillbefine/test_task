package ua.vadim.test_assignment.util.mapper;

import java.time.LocalDate;

public class MapperUtils {
    private MapperUtils() { /* no use to create instances of utility class*/}

    public static int toAge(LocalDate birth) {
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
