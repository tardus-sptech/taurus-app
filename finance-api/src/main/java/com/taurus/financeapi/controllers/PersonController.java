package com.taurus.financeapi.controllers;

import com.taurus.financeapi.models.Person;
import com.taurus.financeapi.services.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/person/v1")
public class PersonController {

    final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<Object> savePerson(@RequestBody Person person) {
        personService.save(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.save(person));
    }

    @GetMapping
    public List<Person> findAll() {
        return personService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOnePerson(@PathVariable(value = "id") Long id) {
        Optional<Person> personOptional = personService.findById(id);
        if (personOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(personOptional.get());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deletePerson(@PathVariable(value = "id") Long id) {
        Optional<Person> personOptional = personService.findById(id);
        if (personOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person not found.");
        }
        personService.delete(personOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Person deleted sucessfully.");
    }

    @PutMapping("/login/{id}")
    public String login(@PathVariable(value = "id") Long id,
                                        @RequestParam String cpf,
                                        @RequestParam String password) {
        Optional<Person> user = personService.findById(id);
        var data = personService.existsByCpfAndPassword(cpf, password);

        if (user.isPresent()) {
            if (data) {
                user.get().setLogged(true);
                personService.login(user.get());

                return "O usuário de CPF: " + cpf + " foi logado.";

            }
        }
        return "don't exists";
    }

    @PutMapping("/logout/{id}")
    public String logout(@PathVariable(value = "id") Long id,
                                        @RequestParam String cpf,
                                        @RequestParam String password
        ) {
        Optional<Person> user = personService.findById(id);
        var data = personService.existsByCpfAndPassword(cpf, password);

        if (user.isPresent()) {
            if (data) {
                user.get().setLogged(false);
                personService.logout(user.get());

                return "O usuário de CPF: " + cpf + " foi deslogado.";
            }
        }
        return "dont exists";
    }
}
