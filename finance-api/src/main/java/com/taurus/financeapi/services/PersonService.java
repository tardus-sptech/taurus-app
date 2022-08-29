package com.taurus.financeapi.services;

import com.taurus.financeapi.models.Person;
import com.taurus.financeapi.repositories.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class PersonService {
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll() {
        logger.info("Finding all people!");
        return personRepository.findAll();
    }

    public Optional<Person> findById(Long id) {
        return personRepository.findById(id);
    }

    public Boolean existsByCpfAndPassword(String cpf, String password) {
        return personRepository.existsPersonByCpfAndPassword(cpf, password);
    }

    @Transactional
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Transactional
    public void login(Person person) {

        if(existsByCpfAndPassword(person.getCpf(), person.getPassword())) {
            person.setLogged(true);
            personRepository.save(person);
        }
    }
    @Transactional
    public void logout(Person person) {

        if(existsByCpfAndPassword(person.getCpf(), person.getPassword())) {
            person.setLogged(false);
            personRepository.save(person);
        }
    }

    @Transactional
    public void delete(Person person) {
        personRepository.delete(person);
    }
}
