package com.example.shopproject.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue
    private Long id;
    @NotNull(message = "must provide description")
    private String description;
    @NotNull(message = "must provide price")
    private Double price;
    @NotNull(message = "must provide quantity")
    private Long quantity;

}
