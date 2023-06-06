package com.fit.mit.lab8.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data                       // from lombok - no need to write getters, setters
@Table(name="bags_lab8")    // name of the table that will be created in database
public class Bag
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private float length;
    private Integer temperature;
    private String photo;
}
