package entity;

import jakarta.persistence.*;

// implementation of Bag
@Entity
@Table(name = "bag")
public class Bag
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "bag_seq")
    @Column(name = "id", nullable = false)
    private Integer id;
    private String name;
    private Integer length;
    private String photo;

    public Bag() { }

    public Bag(Integer id, String name, Integer length, String photo)
    {
        this.id = id;
        this.name = name;
        this.length = length;
        this.photo = photo;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName() { return name; }

    public void setName(String name) {this.name = name;}

    public Integer getLength() { return length; }

    public void setLength(Integer length) { this.length = length; }

    public String getPhoto() { return photo; }

    public void setPhoto(String photo) { this.photo = photo; }

    @Override
    public String toString()
    {
        return "Bag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", length=" + length +
                ", photo='" + photo + '\'' +
                '}';
    }
}