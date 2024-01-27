package com.sid.tutorials.spring.boot3.hibernate.app.services;

import com.sid.tutorials.spring.boot3.hibernate.app.entity.PersonEntity;
import com.sid.tutorials.spring.boot3.hibernate.app.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kunmu On 30-12-2023
 */
@Service
public class PersonServices {

    @Autowired
    private PersonRepository personRepository;

    public PersonEntity createPersonDetails(PersonEntity person) {
        return personRepository.save(person);
    }

    public List<PersonEntity> createPersonDetailsList(List<PersonEntity> person) {
        return (List<PersonEntity>) personRepository.saveAll(person);
    }

    public List<PersonEntity> getAllPersonDetails() {
        return (List<PersonEntity>) personRepository.findAll();
    }

    public PersonEntity getPersonDetailsById(Integer id){
        return personRepository.findById(id).get();
    }
}
