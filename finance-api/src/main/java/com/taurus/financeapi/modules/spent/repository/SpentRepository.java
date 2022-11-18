package com.taurus.financeapi.modules.spent.repository;

import com.taurus.financeapi.modules.spent.model.Spent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpentRepository extends JpaRepository<Spent, Integer> {
    List<Spent> findByNameIgnoreCaseContaining(String name);
    List<Spent> findByCategoryId(Integer id);
    Boolean existsByCategoryId(Integer categoryId);
}
