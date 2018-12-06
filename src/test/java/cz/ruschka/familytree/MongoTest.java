package cz.ruschka.familytree;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import org.bson.Document;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * @author Vojtech Ruschka
 */
@ExtendWith(SpringExtension.class)
@DataMongoTest
public class MongoTest {

    @Test
    public void test(@Autowired MongoTemplate mongoTemplate) {
        DBObject object = BasicDBObjectBuilder.start().add("testKey", "testValue").get();
        mongoTemplate.insert(object, "testCollection");
        assertEquals(
                "testValue",
                mongoTemplate.findOne(
                        query(where("testKey").is("testValue")),
                        Document.class,
                        "testCollection").get("testKey"));
    }
}
