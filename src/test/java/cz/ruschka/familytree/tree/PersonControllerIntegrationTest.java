package cz.ruschka.familytree.tree;

import cz.ruschka.familytree.tree.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.data.mongodb.core.MongoTemplate;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author Vojtech Ruschka
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureDataMongo
public class PersonControllerIntegrationTest {
    @Autowired
    private MongoTemplate mongoTemplate;

    @LocalServerPort
    private int port;

    @Test
    public void getByIdTest() {
        String id = mongoTemplate.insert(Person.class).one(new Person("Ruschka")).getId();
        given().port(port).get("/api/v1/person/" + id)
                .then()
                .statusCode(200)
                .body("name", equalTo("Ruschka"));
    }
}
