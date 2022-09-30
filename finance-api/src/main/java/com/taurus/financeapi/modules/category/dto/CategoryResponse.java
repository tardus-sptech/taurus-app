package com.taurus.financeapi.modules.category.dto;

import com.taurus.financeapi.modules.category.model.Category;
import org.springframework.beans.BeanUtils;

public class CategoryResponse {
    private Integer id;
    private String description;

    public static CategoryResponse of(Category category) {
        var response = new CategoryResponse();
        BeanUtils.copyProperties(category, response);
        return response;
    }
}
