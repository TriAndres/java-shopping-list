package ru.practicum.shoping.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "shoppings")
@Data
public class Shopping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
}