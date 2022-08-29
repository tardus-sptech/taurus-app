package com.taurus.financeapi.repositories;

import com.taurus.financeapi.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    boolean existsPersonByCpfAndPassword(String cpf, String senha);
}