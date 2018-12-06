package cz.ruschka.familytree.tree;

import cz.ruschka.familytree.tree.model.Person;
import cz.ruschka.familytree.tree.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * @author Vojtech Ruschka
 */
@ExtendWith(SpringExtension.class)
@DataMongoTest
public class PersonRepositoryTest {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void insertTest() {
        personRepository.insert(new Person("Ruschka"));
        Person result = mongoTemplate.findOne(query(where("name").is("Ruschka")), Person.class);
        assertNotNull(result);
        assertNotNull(result.getId());
        assertEquals("Ruschka", result.getName());
    }
}
