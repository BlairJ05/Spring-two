package com.example.Events.people;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleService {

    @Autowired
    private PeopleRepository peopleRepository;

    @Transactional
    public People createPerson(People people){
        return peopleRepository.save(people);
    }

    @Transactional
    public People updatePerson(People person){
        return peopleRepository.save(person);
    }

    @Transactional
    public List<People> getAllPeople(){
        return peopleRepository.findAll();
    }

    @Transactional
    public People getPeopleById(Long id){
        return peopleRepository.findById(id).orElseThrow(()-> new IllegalStateException("Person #"+id+" doesn't exist!"));
    }

    @Transactional
    public void deletePerson(Long personId){
        if(peopleRepository.existsById(personId)){
            peopleRepository.deleteById(personId);
        }
        else {
            throw new IllegalStateException("Can't delete comment #"+personId+",that doesn't exist");
        }
        peopleRepository.deleteById(personId);
    }
}
