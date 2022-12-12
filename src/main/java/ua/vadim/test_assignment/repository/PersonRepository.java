package ua.vadim.test_assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.vadim.test_assignment.model.Person;

/** repository to access data in DB */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
