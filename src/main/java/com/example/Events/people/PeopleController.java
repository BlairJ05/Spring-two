package com.example.Events.people;

import com.example.Events.catering.Catering;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/people")
public class PeopleController {
    private final PeopleService peopleService;
    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }



    @GetMapping("/getAll")
    public ResponseEntity<List<People>> getAllPeople() {
        List<People> people = peopleService.getAllPeople();
        return ResponseEntity.ok(people);
    }

    @PostMapping("/createPerson")
    public People createPerson(@RequestBody People people){
        return peopleService.createPerson(people);
    }

    @GetMapping("/{id}")
    public People getPeopleById(@PathVariable("id") Long id) {
        return peopleService.getPeopleById(id);
    }

    @PutMapping("/updatePerson")
    public ResponseEntity<People> updatePerson(@RequestBody People person) {
        People createdPerson = peopleService.createPerson(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPerson);
    }

    @DeleteMapping(path = "/{personId}")
    public void deletePerson(@PathVariable("personId") Long personId) {
        peopleService.deletePerson(personId);
    }
}