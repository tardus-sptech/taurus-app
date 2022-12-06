package com.taurus.financeapi.modules.gain.model;

import com.taurus.financeapi.modules.gain.dto.GainRequest;
import com.taurus.financeapi.modules.user.model.User;
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
@Table(name = "gain")
public class Gain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "value", nullable = false)
    private Double value;

    @ManyToOne
    @JoinColumn(name = "fk_user", nullable = false)
    private User user;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    public static Gain of(GainRequest request,
                          User user) {
        return Gain
                .builder()
                .name(request.getName())
                .value(request.getValue())
                .user(user)
                .build();
    }

    public void updateValue() {
        value = user.getValueInAccount() - getValue();
    }
}