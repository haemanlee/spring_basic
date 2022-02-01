package hello.hellospring.hello.app.v1.dao;

import hello.hellospring.hello.app.v1.entity.Customer;
import org.springframework.data.repository.CrudRepository;

//<entity type, id>
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
