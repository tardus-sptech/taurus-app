package Taurus.CRUD.Kitty.Repository;

import Taurus.CRUD.Kitty.Domain.Kitty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KittyRepository extends JpaRepository<Kitty, Long> {
}
