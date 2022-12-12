package ua.vadim.test_assignment.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.vadim.test_assignment.model.Person;
import ua.vadim.test_assignment.repository.PersonRepository;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository repository;
    private final Logger logger;

    @Autowired
    public PersonService(PersonRepository repository) {
        this.repository = repository;
        this.logger = LoggerFactory.getLogger(PersonService.class);
    }

    /**
     *
     * @param id - id of user need to be found
     * @return Person data covered with Optional
     */
    @Transactional(readOnly = true)
    public Optional<Person> findById(long id) {
        if (logger.isDebugEnabled()) {
            logger.debug(String.format("attempt to find user with id[%d]", id));
        }
        return repository.findById(id);
    }
}
