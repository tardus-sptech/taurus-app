package com.taurus.financeapi.modules.spentlimit.service;

import com.taurus.financeapi.config.exception.ValidationException;
import com.taurus.financeapi.modules.category.service.CategoryService;
import com.taurus.financeapi.modules.spent.dto.SpentResponse;
import com.taurus.financeapi.modules.spent.model.Spent;
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

import static org.springframework.util.ObjectUtils.isEmpty;

@Slf4j
@Service
public class SpentLimitService {

    @Autowired
    private SpentLimitRepository spentLimitRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;



    public SpentLimitResponse save(SpentLimitRequest request) {
        var user = userService.findById(request.getUserId());
        var category = categoryService.findById(request.getCategoryId());
        var spent = spentLimitRepository.save(SpentLimit.of(request, category, user));
        return SpentLimitResponse.of(spent);
    }

    public SpentLimit findById(Integer id) {
        return spentLimitRepository
                .findById(id)
                .orElseThrow(() -> new ValidationException("There's no limit for the given ID."));
    }

    public SpentLimit findByUserId(Integer userId) {
        return spentLimitRepository.findByUserId(userId);

    }

    public List<SpentLimit> findAll() {
        return spentLimitRepository.findAll();
    }

    @Transactional
    public void delete(Integer id) {
        spentLimitRepository.deleteById(id);
    }
}