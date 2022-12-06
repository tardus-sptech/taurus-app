package com.taurus.financeapi.modules.spentlimit.repository;

import com.taurus.financeapi.modules.spentlimit.model.SpentLimit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpentLimitRepository extends JpaRepository<SpentLimit, Integer> {
    List<SpentLimit> findByUserId(Integer id);

    Optional<SpentLimit> findByCategoryIdAndUserId(Integer idCategory, Integer idUser);
}
