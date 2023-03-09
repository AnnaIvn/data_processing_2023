package Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="entity_table")
public class MyEntity implements Serializable
{
    //private static final long serialVersionUID = 1L;
    @Id
    private int id;
    private String name;
    private int weight;

    public MyEntity(int id, String name, int weight)
    {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public MyEntity()
    {
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getWeight()
    {
        return weight;
    }

    public void setWeight(int weight)
    {
        this.weight = weight;
    }

    @Override
    public String toString()
    {
        return "MyEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
