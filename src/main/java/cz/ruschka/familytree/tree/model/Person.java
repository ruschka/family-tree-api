package cz.ruschka.familytree.tree.model;

import org.springframework.data.annotation.Id;

/**
 * @author Vojtech Ruschka
 */
public class Person {
    @Id
    private String id;
    private String name;

    public Person() {}

    public Person(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
