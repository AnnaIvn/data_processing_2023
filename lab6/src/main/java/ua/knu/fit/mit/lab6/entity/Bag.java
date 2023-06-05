package ua.knu.fit.mit.lab6.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data                  // from lombok - no need to write getters, setters
@Table(name="bags")    // name of the table that will be created in database
public class Bag
{
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer length;
    private String photo;
}
