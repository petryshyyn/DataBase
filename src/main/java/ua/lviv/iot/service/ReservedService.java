package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.Reserved;
import ua.lviv.iot.repository.ReservedRepository;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Service
public class ReservedService {
    @Autowired
    ReservedRepository reservedRepository;

    public List<Reserved> findAll() throws Exception {
        List<Reserved> reserved = new LinkedList<>(reservedRepository.findAll());
        if (reserved.isEmpty()) {
            return null;
        }
        return reserved;
    }

    public Reserved findById(Integer id) throws Exception {
        if (reservedRepository.findById(id).isPresent()) {
            return reservedRepository.findById(id).get();
        }
        return null;
    }

    @Transactional
    public void create(Reserved reserved) throws Exception {
        if (reserved != null) {
            reservedRepository.save(reserved);
        }
    }

    @Transactional
    public void update(Reserved reserved) throws Exception {
        reservedRepository.findById(reserved.getReservedId())
                .map(oldEntity -> {
                    oldEntity.setTime(reserved.getTime());
                    oldEntity.setNumberCars(reserved.getNumberCars());
                    return reservedRepository.save(oldEntity);
                })
                .orElseGet(() -> reservedRepository.save(reserved));
    }

    @Transactional
    public void delete(Integer id) throws Exception {
        if (reservedRepository.findById(id).isPresent()) {
            reservedRepository.deleteById(id);
        }
    }
}
