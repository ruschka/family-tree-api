package cz.ruschka.familytree.tree;

import cz.ruschka.familytree.core.integration.IntegrationTestBase;
import cz.ruschka.familytree.data.PersonDataTestService;
import cz.ruschka.familytree.tree.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

/**
 * @author Vojtech Ruschka
 */
public class PersonControllerIntegrationTest extends IntegrationTestBase {
    @Autowired
    private PersonDataTestService personDataTestService;

    @Test
    public void getByIdTest() {
        Person johnSmith = personDataTestService.insertJohnSmith();
        createRequest().get("/api/v1/person/{id}", johnSmith.getId())
                .then()
                .statusCode(200)
                .body("firstName", equalTo("John"))
                .body("lastName", equalTo("Smith"))
                .body("id", notNullValue());
        createRequest().get("/api/v1/person/{id}", "unknownId")
                .then()
                .statusCode(404);
    }

    @Test
    public void createTest() {
        createRequest()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(
                        "{" +
                                "\"firstName\": \"John\"," +
                                "\"lastName\": \"Smith\"" +
                        "}")
                .put("/api/v1/person/")
                .then()
                .statusCode(200)
                .body("firstName", equalTo("John"))
                .body("lastName", equalTo("Smith"))
                .body("id", notNullValue());
    }
}
