package com.taurus.financeapi.modules.kitty.service;

import com.taurus.financeapi.config.exception.ValidationException;
import com.taurus.financeapi.modules.category.dto.CategoryRequest;
import com.taurus.financeapi.modules.category.dto.CategoryResponse;
import com.taurus.financeapi.modules.category.model.Category;
import com.taurus.financeapi.modules.category.repository.CategoryRepository;
import com.taurus.financeapi.modules.kitty.dto.KittyRequest;
import com.taurus.financeapi.modules.kitty.dto.KittyResponse;
import com.taurus.financeapi.modules.kitty.model.Kitty;
import com.taurus.financeapi.modules.kitty.repository.KittyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
public class KittyService {
    @Autowired
    private KittyRepository kittyRepository;

    public Kitty findById(Integer id) {
        return kittyRepository
                .findById(id)
                .orElseThrow(() -> new ValidationException("There's no supplier for the given ID."));
    }

    public KittyResponse save(KittyRequest request) {
        validateKittyDescriptionInformed(request);
        var kitty = kittyRepository.save(Kitty.of(request));
        return KittyResponse.of(kitty);
    }

    private void validateKittyDescriptionInformed(KittyRequest request) {
        if (isEmpty(request.getDescription())) {
            throw new ValidationException("The category description was not informed.");
        }
    }
}