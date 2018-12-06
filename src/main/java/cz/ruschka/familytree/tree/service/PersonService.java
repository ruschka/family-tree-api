package cz.ruschka.familytree.tree.service;

import cz.ruschka.familytree.tree.model.Person;

import java.util.Optional;

/**
 * @author Vojtech Ruschka
 */
public interface PersonService {
    Person create(Person person);
    Optional<Person> findById(String id);
}
