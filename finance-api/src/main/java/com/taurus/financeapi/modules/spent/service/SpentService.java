package com.taurus.financeapi.modules.spent.service;

import com.taurus.financeapi.config.exception.ValidationException;
import com.taurus.financeapi.modules.category.dto.CategoryRequest;
import com.taurus.financeapi.modules.category.dto.CategoryResponse;
import com.taurus.financeapi.modules.category.service.CategoryService;
import com.taurus.financeapi.modules.spent.dto.SpentRequest;
import com.taurus.financeapi.modules.spent.dto.SpentResponse;
import com.taurus.financeapi.modules.spent.model.Spent;
import com.taurus.financeapi.modules.spent.repository.SpentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
public class SpentService {
    @Autowired
    private SpentRepository spentRepository;

    @Autowired
    private CategoryService categoryService;

    public SpentResponse save(SpentRequest request) {
        validateSpentDataInformed(request);
        validateCategoryIdInformed(request);
        var category = categoryService.findById(request.getCategoryId());
        var spent = spentRepository.save(Spent.of(request, category));
        return SpentResponse.of(spent);
    }

    private void validateSpentDataInformed(SpentRequest request) {
        if (isEmpty(request.getName())) {
            throw new ValidationException("The spent name was not informed.");
        }
        if (request.getValue() <= 0) {
            throw new ValidationException("The value must be greater than 0.");
        }
    }

    private void validateCategoryIdInformed(SpentRequest request) {
        if (isEmpty(request.getCategoryId())) {
            throw new ValidationException("The spent ID was not informed.");
        }
    }
}