package com.taurus.financeapi.modules.category.repository;

import com.taurus.financeapi.modules.category.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}