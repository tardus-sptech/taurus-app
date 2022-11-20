package com.taurus.financeapi.modules.kitty.repository;

import com.taurus.financeapi.modules.kitty.model.Kitty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KittyRepository extends JpaRepository<Kitty, Integer> {
    List<Kitty> findByNameIgnoreCaseContaining(String name);
    List<Kitty> findByCategoryId(Integer id);
    Boolean existsByCategoryId(Integer categoryId);
}