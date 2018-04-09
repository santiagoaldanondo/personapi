package santiagoaldanondo.personapi.controller;

import santiagoaldanondo.personapi.exception.ResourceNotFoundException;
import santiagoaldanondo.personapi.model.Person;
import santiagoaldanondo.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    // Get All Persons
    @GetMapping("/persons")
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    // Create a new Person
    @PostMapping("/persons")
    public Person createPerson(@Valid @RequestBody Person person) {
        return personRepository.save(person);
    }

    // Get a Single Person
    @GetMapping("/persons/{id}")
    public Person getPersonById(@PathVariable(value = "id") Long personId) {
        return personRepository.findById(personId)
            .orElseThrow(() -> new ResourceNotFoundException("Person", "id", personId));
    }

    // Update a Person
    @PutMapping("/persons/{id}")
    public Person updatePerson(@PathVariable(value = "id") Long personId,
                                            @Valid @RequestBody Person personDetails) {

        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new ResourceNotFoundException("Person", "id", personId));

            person.setDni(personDetails.getDni());
            person.setFirstName(personDetails.getFirstName());
            person.setLastName1(personDetails.getLastName1());
            person.setLastName2(personDetails.getLastName2());
            person.setAge(personDetails.getAge());
            person.setBirthDate(personDetails.getBirthDate());

        Person updatedPerson = personRepository.save(person);
        return updatedPerson;
    }

    // Delete a Person
    @DeleteMapping("/persons/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable(value = "id") Long personId) {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new ResourceNotFoundException("Person", "id", personId));

        personRepository.delete(person);

        return ResponseEntity.ok().build();
    }
}