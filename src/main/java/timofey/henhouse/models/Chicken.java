package timofey.henhouse.models;

import javax.persistence.*;

@Entity
@Table(name="chicken")
public class Chicken {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "house_id")
    private int house_id;

    public Chicken(){}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getHouse_id() {
        return house_id;
    }
}
