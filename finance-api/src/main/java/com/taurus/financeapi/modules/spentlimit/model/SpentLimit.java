package com.taurus.financeapi.modules.spentlimit.model;

import com.taurus.financeapi.modules.category.model.Category;
import com.taurus.financeapi.modules.spent.dto.SpentRequest;
import com.taurus.financeapi.modules.spent.model.Spent;
import com.taurus.financeapi.modules.spentlimit.dto.SpentLimitRequest;
import com.taurus.financeapi.modules.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.Month;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "spent_limit")
public class SpentLimit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "month", nullable = false)
    private Month month;

    @Column(name = "current_limit")
    private Double currentLimit;

    @Column(name = "month_spent", nullable = false)
    private Double monthSpent;

    @Column(name = "category_spent", nullable = false)
    private Double categorySpent;

    @ManyToOne
    @JoinColumn(name = "fk_category", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "fk_user", nullable = false)
    private User user;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    public static SpentLimit of(SpentLimitRequest request,
                                Category category,
                                User user) {
        return SpentLimit
                .builder()
                .month(request.getMonth())
                .currentLimit(request.getCurrentLimit())
                .monthSpent(request.getMonthSpent())
                .categorySpent(request.getCategorySpent())
                .category(category)
                .user(user)
                .build();
    }

}