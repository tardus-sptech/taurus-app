package com.taurus.financeapi.modules.kitty.service;

import com.taurus.financeapi.config.exception.ValidationException;
import com.taurus.financeapi.modules.category.service.CategoryService;
import com.taurus.financeapi.modules.kitty.dto.KittyRequest;
import com.taurus.financeapi.modules.kitty.dto.KittyResponse;
import com.taurus.financeapi.modules.kitty.model.Kitty;
import com.taurus.financeapi.modules.kitty.repository.KittyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
public class KittyService {
    @Autowired
    private KittyRepository kittyRepository;

    @Autowired
    private CategoryService categoryService;

    public Kitty findById(Integer id) {
        return kittyRepository
                .findById(id)
                .orElseThrow(() -> new ValidationException("There's no kitty for the given ID."));
    }

    public List<KittyResponse> findAll() {
        return kittyRepository
                .findAll()
                .stream()
                .map(KittyResponse::of)
                .collect(Collectors.toList());
    }

    public List<KittyResponse> findByName(String name) {
        if (isEmpty(name)) {
            throw new ValidationException("The kitty name must be informed.");
        }

        return kittyRepository
                .findByNameIgnoreCaseContaining(name)
                .stream()
                .map(KittyResponse::of)
                .collect(Collectors.toList());
    }

    public KittyResponse findByIdResponse(Integer id) {
        return KittyResponse.of(findById(id));
    }

    public KittyResponse save(KittyRequest request) {
        validateKittyDescriptionInformed(request);
        var category = categoryService.findById(request.getCategoryId());
        var kitty = kittyRepository.save(Kitty.of(request, category));
        return KittyResponse.of(kitty);
    }

    public List<KittyResponse> findByCategoryId(Integer categoryId) {
        if (isEmpty(categoryId)) {
            throw new ValidationException("The kitt' category ID must be informed.");
        }
        if (!kittyRepository.existsByCategoryId(categoryId)) {
            throw new ValidationException("The kitty' category ID was not found.");
        }
        return kittyRepository
                .findByCategoryId(categoryId)
                .stream()
                .map(KittyResponse::of)
                .collect(Collectors.toList());
    }

    public void delete(Integer id) {
        kittyRepository.deleteById(id);
    }

    private void validateKittyDescriptionInformed(KittyRequest request) {
        if (isEmpty(request.getDescription())) {
            throw new ValidationException("The category description was not informed.");
        }
    }
}