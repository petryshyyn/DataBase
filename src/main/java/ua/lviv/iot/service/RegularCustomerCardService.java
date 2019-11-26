package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.RegularCustomerCard;
import ua.lviv.iot.repository.RegularCustomerCardRepository;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Service
public class RegularCustomerCardService {

    @Autowired
    RegularCustomerCardRepository regularCustomerCardRepository;

    public List<RegularCustomerCard> findAll() throws Exception {
        List<RegularCustomerCard> regularCustomerCards = new LinkedList<>(regularCustomerCardRepository.findAll());
        if (regularCustomerCards.isEmpty()) {
            return null;
        }
        return regularCustomerCards;
    }

    public RegularCustomerCard findById(Integer id) throws Exception {
        if (regularCustomerCardRepository.findById(id).isPresent()) {
            return regularCustomerCardRepository.findById(id).get();
        }
        return null;
    }

    @Transactional
    public void create(RegularCustomerCard regularCustomerCard) throws Exception {
        if (regularCustomerCard != null) {
            regularCustomerCardRepository.save(regularCustomerCard);
        }
    }

    @Transactional
    public void update(RegularCustomerCard regularCustomerCard) throws Exception {
        regularCustomerCardRepository.findById(regularCustomerCard.getRegularCustomerCardId())
                .map(oldEntity -> {
                    oldEntity.setOuner(regularCustomerCard.getOuner());
                    oldEntity.setNumberOfFreeSpaces(regularCustomerCard.getNumberOfFreeSpaces());
                    oldEntity.setDeadline(regularCustomerCard.getDeadline());
                    return regularCustomerCardRepository.save(oldEntity);
                })
                .orElseGet(() -> regularCustomerCardRepository.save(regularCustomerCard));
    }
    @Transactional
    public void delete(Integer id) throws Exception {
        if (regularCustomerCardRepository.findById(id).isPresent()) {
            regularCustomerCardRepository.deleteById(id);
        }
    }
}
