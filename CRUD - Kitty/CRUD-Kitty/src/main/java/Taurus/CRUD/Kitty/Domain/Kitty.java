package Taurus.CRUD.Kitty.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Kitty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer description;

    private Float goal;

    public Kitty(Long id, String name, Integer description, Float goal) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.goal = goal;
    }

    public Kitty(String name, Integer description, Float goal) {
        this.name = name;
        this.description = description;
        this.goal = goal;
    }

    public Kitty() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDescription() {
        return description;
    }

    public void setDescription(Integer description) {
        this.description = description;
    }

    public Float getGoal() {
        return goal;
    }

    public void setGoal(Float goal) {
        this.goal = goal;
    }
}
