package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.model.RegularCustomerCard;

public interface RegularCustomerCardRepository extends JpaRepository<RegularCustomerCard, Integer> {
}
