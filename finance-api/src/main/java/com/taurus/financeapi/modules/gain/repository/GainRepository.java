package com.taurus.financeapi.modules.gain.repository;

import com.taurus.financeapi.modules.gain.model.Gain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GainRepository extends JpaRepository<Gain, Integer> {
    List<Gain> findByNameIgnoreCaseContaining(String name);
    List<Gain> findByUserIdOrderByCreatedAtDesc(Integer idUser);
}
