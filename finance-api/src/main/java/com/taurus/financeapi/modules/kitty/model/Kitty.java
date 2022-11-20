package com.taurus.financeapi.modules.kitty.model;

import com.taurus.financeapi.modules.category.model.Category;
import com.taurus.financeapi.modules.kitty.dto.KittyRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "kitty")
public class Kitty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Float goal;

    @ManyToOne
    @JoinColumn(name = "fk_category", nullable = false)
    private Category category;

    @Column(nullable = false)
    private Integer quantityAvailable;

    public static Kitty of(KittyRequest request,
                           Category category) {
        return Kitty
                .builder()
                .name(request.getName())
                .description(request.getDescription())
                .category(category)
                .quantityAvailable(request.getQuantityAvailable())
                .build();
    }
}
