package com.taurus.financeapi.modules.spentlimit.service;

import com.taurus.financeapi.modules.category.service.CategoryService;
import com.taurus.financeapi.modules.spent.repository.SpentRepository;
import com.taurus.financeapi.modules.spentlimit.dto.SpentLimitRequest;
import com.taurus.financeapi.modules.spentlimit.dto.SpentLimitResponse;
import com.taurus.financeapi.modules.spentlimit.model.SpentLimit;
import com.taurus.financeapi.modules.spentlimit.repository.SpentLimitRepository;
import com.taurus.financeapi.modules.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
public class SpentLimitService {

    @Autowired
    private SpentLimitRepository spentLimitRepository;

    @Autowired
    private UserService userService;

    @Autowired
    SpentRepository spentRepository;

    @Autowired
    private CategoryService categoryService;


    public SpentLimitResponse save(SpentLimitRequest request) {

        Optional<SpentLimit> teste = findByCategoryIdAndUserId(request.getCategoryId(), request.getUserId());

        if (!teste.isEmpty()) {
            throw new IllegalArgumentException();
        }

        var user = userService.findById(request.getUserId());
        var category = categoryService.findById(request.getCategoryId());
        var spentLimit = (SpentLimit.of(request, category, user));
        category.setValue(spentLimit.getCategorySpent() + category.getValue());
        var spent = spentRepository.sumSpentfindByCategoryIdAndUserId(category.getId(), user.getId());

        spentLimitRepository.save(spentLimit);
        return SpentLimitResponse.of(spentLimit);
    }

    public List<SpentLimit> findByUserId(Integer userId) {
        return spentLimitRepository.findByUserId(userId);
    }

    public Optional<SpentLimit> findByCategoryIdAndUserId(Integer categoryId, Integer userId) {
        return spentLimitRepository.findByCategoryIdAndUserId(categoryId, userId);
    }

    public List<SpentLimit> findAll() {
        return spentLimitRepository.findAll();
    }

    @Transactional
    public void delete(Integer id) {
        spentLimitRepository.deleteById(id);
    }
}