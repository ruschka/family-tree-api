package cz.ruschka.familytree.tree.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cz.ruschka.familytree.tree.model.Person;
import cz.ruschka.familytree.tree.repository.PersonRepository;

import java.util.Optional;

/**
 * @author Vojtech Ruschka
 */
@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person create(Person person) {
        return personRepository.insert(person);
    }

    @Override
    public Optional<Person> findById(String id) {
        return personRepository.findById(id);
    }
}
