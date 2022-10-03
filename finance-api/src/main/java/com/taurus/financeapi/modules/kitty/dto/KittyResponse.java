package com.taurus.financeapi.modules.kitty.dto;

import com.taurus.financeapi.modules.kitty.model.Kitty;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class KittyResponse {
    private Integer id;
    private String description;

    public static KittyResponse of(Kitty kitty) {
        var response = new KittyResponse();
        BeanUtils.copyProperties(kitty, response);
        return response;
    }
}