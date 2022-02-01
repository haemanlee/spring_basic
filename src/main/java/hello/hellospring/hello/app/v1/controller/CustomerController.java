package hello.hellospring.hello.app.v1.controller;

import hello.hellospring.hello.app.v1.dao.CustomerRepository;
import hello.hellospring.hello.app.v1.entity.Customer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    CustomerRepository repository;


    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/customer")
    public Customer postCustomer(Customer customer){
        return repository.save(customer);
    }
}
