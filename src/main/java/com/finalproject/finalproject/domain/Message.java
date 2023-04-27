package com.finalproject.finalproject.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String msg;
    @OneToOne
    Owner owner;
    @OneToOne
    Customer customer;
    @OneToOne
    Property property;
}
