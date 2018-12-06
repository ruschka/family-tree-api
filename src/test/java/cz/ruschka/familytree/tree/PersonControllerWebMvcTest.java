package cz.ruschka.familytree.tree;

import cz.ruschka.familytree.tree.controller.PersonController;
import cz.ruschka.familytree.tree.model.Person;
import cz.ruschka.familytree.tree.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Vojtech Ruschka
 */
@WebMvcTest(value = PersonController.class)
public class PersonControllerWebMvcTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PersonService personService;

    @Test
    public void getByIdTest() throws Exception {
        when(this.personService.findById("1")).thenReturn(Optional.of(new Person("Ruschka")));
        mvc.perform(get("/person/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name", equalTo("Ruschka")));
        when(this.personService.findById("2")).thenReturn(Optional.empty());
        mvc.perform(get("/person/2"))
                .andExpect(status().isNotFound());
    }
}
