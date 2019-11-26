package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.model.Security;

public interface SecurityRepository extends JpaRepository<Security, Integer> {
}
