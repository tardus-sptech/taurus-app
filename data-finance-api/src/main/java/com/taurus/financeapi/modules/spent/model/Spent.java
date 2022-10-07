package com.taurus.financeapi.modules.spent.model;

import com.taurus.financeapi.modules.spent.dto.SpentRequest;
import com.taurus.financeapi.modules.category.model.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "spent")
public class Spent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "value", nullable = false)
    private Double value;

    @ManyToOne
    @JoinColumn(name = "fk_category", nullable = false)
    private Category category;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    public static Spent of(SpentRequest request,
                           Category category) {
        return Spent
                .builder()
                .name(request.getName())
                .value(request.getValue())
                .category(category)
                .build();
    }

    public void updateValue(Double newValue) {
        value = value + newValue;
    }
}