package com.taurus.financeapi.modules.spentlimit.repository;

import com.taurus.financeapi.modules.spentlimit.model.SpentLimit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpentLimitRepository extends JpaRepository<SpentLimit, Integer> {
    List<SpentLimit> findByUserId(Integer id);
}
