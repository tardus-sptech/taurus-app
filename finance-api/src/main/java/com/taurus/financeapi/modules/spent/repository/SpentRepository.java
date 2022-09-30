package com.taurus.financeapi.modules.spent.repository;

import com.taurus.financeapi.modules.spent.model.Spent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpentRepository extends JpaRepository<Spent, Integer> {
}
