package cz.ruschka.familytree.core.integration;

import cz.ruschka.familytree.core.mongo.MongoTestBase;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

/**
 * @author Vojtech Ruschka
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class IntegrationTestBase extends MongoTestBase {

    @LocalServerPort
    private int port;

    protected RequestSpecification createRequest() {
        return RestAssured.given().port(port);
    }
}
