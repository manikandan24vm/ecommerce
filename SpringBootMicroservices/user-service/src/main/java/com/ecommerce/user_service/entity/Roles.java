package com.ecommerce.user_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Roles {
    @Id
    private long roleId;
    private String roleNames;
    private String description;
    private Role roleName;
    public enum Role{
        ADMIN,CUSTOMER
    }
}
