package com.taurus.financeapi.modules.spent.repository;

import com.taurus.financeapi.modules.spent.model.Spent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpentRepository extends JpaRepository<Spent, Integer> {
    List<Spent> findByNameIgnoreCaseContaining(String name);
    List<Spent> findByCategoryId(Integer id);
    List<Spent> findByUserIdOrderByCreatedAtDesc(Integer idUser);
    Boolean existsByCategoryId(Integer categoryId);

    @Query("SELECT SUM(value) FROM Spent WHERE fk_user = ?1")
    public Double sumSpentfindByUserId(Integer id);

    @Query("SELECT SUM(value) FROM Spent WHERE fk_category = ?1 AND fk_user = ?2")
    public Double sumSpentfindByCategoryIdAndUserId(Integer categoryId, Integer userId);

    public Integer countSpentByUserId(Integer idUSer);
}
