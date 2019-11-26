package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
}
