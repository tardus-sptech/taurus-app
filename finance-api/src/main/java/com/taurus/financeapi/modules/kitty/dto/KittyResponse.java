package com.taurus.financeapi.modules.kitty.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.taurus.financeapi.modules.category.dto.CategoryResponse;
import com.taurus.financeapi.modules.kitty.model.Kitty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class KittyResponse {
    private Integer id;
    private String name;
    private String description;
    private Float goal;
    private CategoryResponse category;
    @JsonProperty("quantity_available")
    private Integer quantityAvailable;

    public static KittyResponse of(Kitty kitty) {
        return KittyResponse
                .builder()
                .id(kitty.getId())
                .name(kitty.getName())
                .description(kitty.getDescription())
                .category(CategoryResponse.of(kitty.getCategory()))
                .quantityAvailable(kitty.getQuantityAvailable())
                .build();
    }
}