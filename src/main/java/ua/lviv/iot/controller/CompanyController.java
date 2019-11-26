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
import ua.lviv.iot.model.Company;
import ua.lviv.iot.service.CompanyService;

import java.util.List;

@RestController
@RequestMapping("/petryshyn_lab3")
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @GetMapping("/company")
    public List<Company> findAll() throws Exception {
        return companyService.findAll();
    }

    @GetMapping("/company/{id}")
    public Company findById(@PathVariable Integer id) throws Exception {
        return companyService.findById(id);
    }

    @PostMapping("/company")
    public void create(@RequestBody Company entity) throws Exception {
        companyService.create(entity);
    }

    @PutMapping("/company/{id}")
    public void update(@PathVariable Integer id, @RequestBody Company entity) throws Exception {
        entity.setCompanyId(id);
        companyService.update(entity);
    }

    @DeleteMapping("/company/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        companyService.delete(id);
    }
}
