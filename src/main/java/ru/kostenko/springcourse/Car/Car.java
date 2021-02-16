package ru.kostenko.springcourse.Car;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table
public class Car {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="model")
    private String model;

    @Column(name="modefication")
    private String modefication;

    @Column(name="color")
    private String color;


}
