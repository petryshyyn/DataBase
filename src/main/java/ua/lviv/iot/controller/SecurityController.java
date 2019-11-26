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
import ua.lviv.iot.model.Security;
import ua.lviv.iot.service.SecurityService;
import java.util.List;

@RestController
@RequestMapping("/petryshyn_lab3")
public class SecurityController {
    @Autowired
    SecurityService securityService;

    @GetMapping("/security")
    public List<Security> findAll() throws Exception {
        return securityService.findAll();
    }

    @GetMapping("/security/{id}")
    public Security findById(@PathVariable Integer id) throws Exception {
        return securityService.findById(id);
    }

    @PostMapping("/security")
    public void create(@RequestBody Security entity) throws Exception {
        securityService.create(entity);
    }

    @PutMapping("/security/{id}")
    public void update(@PathVariable Integer id, @RequestBody Security entity) throws Exception {
        entity.setSecurityId(id);
        securityService.update(entity);
    }

    @DeleteMapping("/security/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        securityService.delete(id);
    }
}
