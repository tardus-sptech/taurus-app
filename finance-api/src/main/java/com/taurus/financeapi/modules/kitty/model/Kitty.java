package com.taurus.financeapi.modules.kitty.model;

import com.taurus.financeapi.modules.category.dto.CategoryRequest;
import com.taurus.financeapi.modules.category.model.Category;
import com.taurus.financeapi.modules.kitty.dto.KittyRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "kitty")
public class Kitty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String description;

    private Float goal;

    public static Kitty of(KittyRequest request) {
        var kitty = new Kitty();
        BeanUtils.copyProperties(request, kitty);
        return kitty;
    }
}
