package hello.hellospring.hello.app.v1.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @Column(length = 1024)
    private String address;

}
