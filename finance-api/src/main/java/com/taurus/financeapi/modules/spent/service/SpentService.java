package com.taurus.financeapi.modules.spent.service;

import com.taurus.financeapi.config.exception.ValidationException;
import com.taurus.financeapi.modules.category.dto.CategoryRequest;
import com.taurus.financeapi.modules.category.service.CategoryService;
import com.taurus.financeapi.modules.spent.dto.SpentRequest;
import com.taurus.financeapi.modules.spent.dto.SpentResponse;
import com.taurus.financeapi.modules.spent.model.Spent;
import com.taurus.financeapi.modules.spent.repository.SpentRepository;
import com.taurus.financeapi.modules.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.util.ObjectUtils.isEmpty;

@Slf4j
@Service
public class SpentService {

    @Lazy
    @Autowired
    private SpentRepository spentRepository;

    @Lazy
    @Autowired
    private CategoryService categoryService;

    @Lazy
    @Autowired
    private UserService userService;

    public SpentResponse save(SpentRequest request) {
        var user = userService.findById(request.getUserId());
        user.setValueInAccount(user.getValueInAccount() - request.getValue());
        var category = categoryService.findById(request.getCategoryId());
        category.setValue(request.getValue() + category.getValue());
        var spent = spentRepository.save(Spent.of(request, category, user));
        return SpentResponse.of(spent);
    }

    public Spent findById(Integer id) {
        return spentRepository
                .findById(id)
                .orElseThrow(() -> new ValidationException("There's no spent for the given ID."));
    }


    public List<SpentResponse> findAll() {
        return spentRepository
                .findAll()
                .stream()
                .map(SpentResponse::of)
                .collect(Collectors.toList());
    }

    public List<SpentResponse> findByName(String name) {
        if (isEmpty(name)) {
            throw new ValidationException("The kitty name must be informed.");
        }

        return spentRepository
                .findByNameIgnoreCaseContaining(name)
                .stream()
                .map(SpentResponse::of)
                .collect(Collectors.toList());
    }

    public SpentResponse findByIdResponse(Integer id) {
        return SpentResponse.of(findById(id));
    }

    public List<SpentResponse> findByCategoryId(Integer categoryId) {
        if (isEmpty(categoryId)) {
            throw new ValidationException("The kitt' category ID must be informed.");
        }
        if (!spentRepository.existsByCategoryId(categoryId)) {
            throw new ValidationException("The spent' category ID was not found.");
        }
        return spentRepository
                .findByCategoryId(categoryId)
                .stream()
                .map(SpentResponse::of)
                .collect(Collectors.toList());
    }

    private void validateSpentDataInformed(SpentRequest request) {
        if (isEmpty(request.getName())) {
            throw new ValidationException("The spent name was not informed.");
        }
        if (request.getValue() <= 0) {
            throw new ValidationException("The value must be greater than 0.");
        }
    }

    public SpentResponse update(SpentRequest request, Integer id) {
        validateSpentDataInformed(request);
        validateCategoryIdInformed(request);
        validateInformedId(id);
        var user = userService.findById(request.getUserId());
        var category = categoryService.findById(request.getCategoryId());
        var spent = spentRepository.save(Spent.of(request, category, user));
        return SpentResponse.of(spent);
    }

    public void delete(Integer id) {
        spentRepository.deleteById(id);
    }

    private void validateInformedId(Integer id) {
        if (isEmpty(id)) {
            throw new ValidationException("The ID must be informed");
        }
    }

    private void validateCategoryIdInformed(SpentRequest request) {
        if (isEmpty(request.getCategoryId())) {
            throw new ValidationException("The spent ID was not informed.");
        }
    }

}