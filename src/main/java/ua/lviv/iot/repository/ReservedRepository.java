package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.model.Reserved;

public interface ReservedRepository extends JpaRepository<Reserved, Integer> {
}
