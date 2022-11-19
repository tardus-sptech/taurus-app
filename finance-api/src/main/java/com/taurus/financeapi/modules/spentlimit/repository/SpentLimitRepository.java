package com.taurus.financeapi.modules.spentlimit.repository;

import com.taurus.financeapi.modules.spentlimit.model.SpentLimit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpentLimitRepository extends JpaRepository<SpentLimit, Integer> {
    SpentLimit findByUserId(Integer id);
}
