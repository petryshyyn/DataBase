package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.model.Staff;

public interface StaffRepository extends JpaRepository<Staff, Integer> {
}
