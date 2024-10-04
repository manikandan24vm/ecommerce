package com.ecommerce.user_service.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
@Entity
@Table(name="user_db")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Users extends Details {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String phoneNumber;
    @Embedded
    private Address address;

}
