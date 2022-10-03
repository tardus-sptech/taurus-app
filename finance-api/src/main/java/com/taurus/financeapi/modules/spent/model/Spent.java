package com.taurus.financeapi.modules.spent.model;

import com.taurus.financeapi.modules.category.model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
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
}