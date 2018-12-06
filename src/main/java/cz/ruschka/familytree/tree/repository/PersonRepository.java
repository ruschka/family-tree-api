package cz.ruschka.familytree.tree.repository;

import cz.ruschka.familytree.tree.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Vojtech Ruschka
 */
public interface PersonRepository extends MongoRepository<Person, String> {
}
