package com.sid.tutorials.spring.boot3.hibernate.app.services;

import com.sid.tutorials.spring.boot3.hibernate.app.entity.PersonEntity;
import com.sid.tutorials.spring.boot3.hibernate.app.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public PersonEntity getPersonDetailsById(Integer id) {
        return personRepository.findById(id).get();
    }

    public List<PersonEntity> getAllPersonDetailsByPagingAndSorting(int pageNumber, int pageSize, String columnDetails) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC, columnDetails);
        List<PersonEntity> personEntityList = personRepository.findAll(pageRequest)
                .map(person -> {
                    return PersonEntity.builder()
                            .id(person.getId())
                            .firstName(person.getFirstName())
                            .lastName(person.getLastName())
                            .age(person.getAge())
                            .gender(person.getGender())
                            .email(person.getEmail())
                            .build();
                }).stream().collect(Collectors.toList());
        return personEntityList;
    }
}
