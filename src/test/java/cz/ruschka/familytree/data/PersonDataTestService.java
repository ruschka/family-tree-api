package cz.ruschka.familytree.data;

import cz.ruschka.familytree.tree.model.Person;
import cz.ruschka.familytree.tree.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Vojtech Ruschka
 */
@Service
public class PersonDataTestService {
    @Autowired
    private PersonRepository personRepository;

    public Person insertJohnSmith() {
        return personRepository.insert(
                new Person("John", null, "Smith"));
    }
}
