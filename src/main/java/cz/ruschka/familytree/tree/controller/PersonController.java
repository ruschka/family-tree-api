package cz.ruschka.familytree.tree.controller;

import cz.ruschka.familytree.tree.model.Person;
import cz.ruschka.familytree.tree.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Vojtech Ruschka
 */
@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/{id}")
    public ResponseEntity<Person> getById(@PathVariable(value = "id") String id) {
        return personService.findById(id)
                .map(person -> new ResponseEntity<>(person, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/")
    public Person create(@RequestBody Person person) {
        return personService.create(person);
    }
}
