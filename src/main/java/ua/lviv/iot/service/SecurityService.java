package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.Security;
import ua.lviv.iot.repository.SecurityRepository;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Service
public class SecurityService {
    @Autowired
    SecurityRepository securityRepository;

    public List<Security> findAll() throws Exception {
        List<Security> accounts = new LinkedList<>(securityRepository.findAll());
        if (accounts.isEmpty()) {
            return null;
        }
        return accounts;
    }

    public Security findById(Integer id) throws Exception {
        if (securityRepository.findById(id).isPresent()) {
            return securityRepository.findById(id).get();
        }
        return null;
    }

    @Transactional
    public void create(Security security) throws Exception {
        if (security != null) {
            securityRepository.save(security);
        }
    }

    @Transactional
    public void update(Security security) throws Exception {
        securityRepository.findById(security.getSecurityId())
                .map(oldEntity -> {
                    oldEntity.setFinedCars(security.getFinedCars());
                    oldEntity.setFines(security.getFines());
                    return securityRepository.save(oldEntity);
                })
                .orElseGet(() -> securityRepository.save(security));
    }

    @Transactional
    public void delete(Integer id) throws Exception {
        if (securityRepository.findById(id).isPresent()) {
            securityRepository.deleteById(id);
        }
    }
}
