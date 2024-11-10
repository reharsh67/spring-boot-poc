package com.boot.poc.userService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String userEmail;
    private transient String password;
    @ElementCollection
    @CollectionTable(name = "user_orders", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "order_id")
    private List<Long> orderIds = new ArrayList<>();
}
