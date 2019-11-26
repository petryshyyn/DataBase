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
import ua.lviv.iot.model.RegularCustomerCard;
import ua.lviv.iot.service.RegularCustomerCardService;

import java.util.List;

@RestController
@RequestMapping("/petryshyn_lab3")
public class RegularCustomerCardController {
    @Autowired
    RegularCustomerCardService regularCustomerCardService;

    @GetMapping("/regular_customer_card")
    public List<RegularCustomerCard> findAll() throws Exception {
        return regularCustomerCardService.findAll();
    }

    @GetMapping("/regular_customer_card/{id}")
    public RegularCustomerCard findById(@PathVariable Integer id) throws Exception {
        return regularCustomerCardService.findById(id);
    }

    @PostMapping("/regular_customer_card")
    public void create(@RequestBody RegularCustomerCard entity) throws Exception {
        regularCustomerCardService.create(entity);
    }

    @PutMapping("/regular_customer_card/{id}")
    public void update(@PathVariable Integer id, @RequestBody RegularCustomerCard entity) throws Exception {
        entity.setRegularCustomerCardId(id);
        regularCustomerCardService.update(entity);
    }

    @DeleteMapping("/regular_customer_card/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        regularCustomerCardService.delete(id);
    }
}
