package com.ust.aws;

import com.ust.aws.entity.Person;
import com.ust.aws.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class SpringbootDynamodbDemoApp{

    @Autowired
    private PersonRepository repository;

    @PostMapping("/person")
    public Person savePerson(@RequestBody Person person) {
        return repository.addPerson(person);
    }


    @GetMapping("/person/{personId}")
    public Person findPerson(@PathVariable String personId) {
        return repository.findPersonByPersonId(personId);
    }

    @DeleteMapping("/person")
    public String deletePerson(@RequestBody Person person) {
        return repository.deletePerson(person);
    }

    @PutMapping("/person")
    public String updatePerson(@RequestBody Person person) {
        return repository.editPerson(person);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDynamodbDemoApp.class, args);
    }

}
