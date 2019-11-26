package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.model.Users;
import ua.lviv.iot.service.UsersService;
import java.util.List;

@RestController
@RequestMapping("/petryshyn_lab3")
public class UsersController {
    @Autowired
    UsersService usersService;

    @GetMapping("/users")
    public List<Users> findAll() throws Exception {
        return usersService.findAll();
    }

    @GetMapping("/users/{id}")
    public Users findById(@PathVariable Integer id) throws Exception {
        return usersService.findById(id);
    }

    @PostMapping("/users")
    public void create(@RequestBody Users entity) throws Exception {
        usersService.create(entity);
    }

    @PutMapping("/users/{id}")
    public void update(@PathVariable Integer id, @RequestBody Users entity) throws Exception {
        entity.setUsersId(id);
        usersService.update(entity);
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        usersService.delete(id);
    }
}
