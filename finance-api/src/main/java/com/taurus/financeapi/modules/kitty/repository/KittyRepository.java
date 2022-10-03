package com.taurus.financeapi.modules.kitty.repository;

import com.taurus.financeapi.modules.kitty.model.Kitty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KittyRepository extends JpaRepository<Kitty, Integer> {
}