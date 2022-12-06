package com.taurus.financeapi.modules.category.service;

import com.taurus.financeapi.config.exception.ValidationException;
import com.taurus.financeapi.modules.category.dto.CategoryRequest;
import com.taurus.financeapi.modules.category.dto.CategoryResponse;
import com.taurus.financeapi.modules.category.model.Category;
import com.taurus.financeapi.modules.category.repository.CategoryRepository;
import com.taurus.financeapi.modules.spent.service.SpentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SpentService spentService;

    public CategoryResponse findByIdResponse(Integer id) {
        return CategoryResponse.of(findById(id));
    }

    public List<CategoryResponse> findAll() {
        return categoryRepository
                .findAll()
                .stream()
                .map(CategoryResponse::of)
                .collect(Collectors.toList());
    }

    public List<CategoryResponse> findByDescription(String description) {
        if (isEmpty(description)) {
            throw new ValidationException("The category description must be informed.");
        }

        return categoryRepository
                .findByDescriptionIgnoreCaseContaining(description)
                .stream()
                .map(CategoryResponse::of)
                .collect(Collectors.toList());
    }

    public Category findById(Integer id) {
        if (isEmpty(id)) {
            throw new ValidationException("The category ID was not informed.");
        }
        return categoryRepository
                .findById(id)
                .orElseThrow(() -> new ValidationException("There's no category for the given ID."));
    }

    public CategoryResponse save(CategoryRequest request) {
        validateCategoryDescriptionInformed(request);
        var category = categoryRepository.save(Category.of(request));
        return CategoryResponse.of(category);
    }


    public void delete(Category request) {
        categoryRepository.delete(request);
    }


    private void validateCategoryDescriptionInformed(CategoryRequest request) {
        if (isEmpty(request.getDescription())) {
            throw new ValidationException("The category description was not informed.");
        }
    }
}
