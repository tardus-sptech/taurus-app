package com.taurus.financeapi.modules.spent.repository;

import com.taurus.financeapi.modules.spent.dto.SpentResponse;
import com.taurus.financeapi.modules.spent.model.Spent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpentRepository extends JpaRepository<Spent, Integer> {
    List<Spent> findByNameIgnoreCaseContaining(String name);
    List<Spent> findByCategoryId(Integer id);
    List<Spent> findByUserIdOrderByCreatedAtDesc(Integer idUser);
    Boolean existsByCategoryId(Integer categoryId);

    @Query(value = "SELECT SUM(s.value) FROM Spent s WHERE s.fk_user = ?1", nativeQuery = true)
    public Double sumSpentfindByUserId(Integer id);
}
