package Entity;

public class MyEntity
{
    private String name, photo;
    private float weight, length;

    public MyEntity(String name, String photo, float weight, float length)
    {
        this.name = name;
        this.photo = photo;
        this.weight = weight;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public String getPhoto() { return photo; }

    public void setPhoto(String photo) { this.photo = photo; }

    @Override
    public String toString()
    {
        return "MyEntity{" +
                "name='" + name + '\'' +
                ", photo='" + photo + '\'' +
                ", weight=" + weight +
                ", length=" + length +
                '}';
    }


}
