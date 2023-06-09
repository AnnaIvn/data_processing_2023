package ua.fit.mit.exam.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data                         // from lombok - no need to write getters, setters
@Table(name="scout_table")    // name of the table that will be created in database
public class Scout
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String goal;
    private float duration;
    private Integer members;
}
