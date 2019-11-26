package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.Users;
import ua.lviv.iot.repository.UsersRepository;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Service
public class UsersService {
    @Autowired
    UsersRepository usersRepository;

    public List<Users> findAll() throws Exception {
        List<Users> users = new LinkedList<>(usersRepository.findAll());
        if (users.isEmpty()) {
            return null;
        }
        return users;
    }

    public Users findById(Integer id) throws Exception {
        if (usersRepository.findById(id).isPresent()) {
            return usersRepository.findById(id).get();
        }
        return null;
    }

    @Transactional
    public void create(Users users) throws Exception {
        if (users != null) {
            usersRepository.save(users);
        }
    }

    @Transactional
    public void update(Users users) throws Exception {
        usersRepository.findById(users.getUsersId())
                .map(oldEntity -> {
                    oldEntity.setFirstName(users.getFirstName());
                    oldEntity.setLastName(users.getLastName());
                    oldEntity.setNumberOfParking(users.getNumberOfParking());
                    oldEntity.setDisabledPeople(users.getDisabledPeople());
                    return usersRepository.save(oldEntity);
                })
                .orElseGet(() -> usersRepository.save(users));
    }

    @Transactional
    public void delete(Integer id) throws Exception {
        if (usersRepository.findById(id).isPresent()) {
            usersRepository.deleteById(id);
        }
    }
}
