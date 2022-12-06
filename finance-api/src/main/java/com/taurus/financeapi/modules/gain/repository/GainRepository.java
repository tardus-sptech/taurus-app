package com.taurus.financeapi.modules.gain.repository;

import com.taurus.financeapi.modules.gain.model.Gain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GainRepository extends JpaRepository<Gain, Integer> {
    List<Gain> findByNameIgnoreCaseContaining(String name);
    List<Gain> findByUserId(Integer id);


    @Query(value = "SELECT SUM(g.value) FROM Gain g WHERE g.fk_user = ?1", nativeQuery = true)
    public Double sumGainfindByUserId(Integer id);


    List<Gain> findByUserIdOrderByCreatedAtDesc(Integer idUser);

    Integer countGainByUserId(Integer idUSer);
}
