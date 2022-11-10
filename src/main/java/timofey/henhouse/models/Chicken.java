package timofey.henhouse.models;

import javax.persistence.*;
import java.util.List;

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


    @OneToMany(fetch = FetchType.EAGER, targetEntity=Egg.class, mappedBy="chicken_id")
    private List<Egg> eggList;


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

    public List<Egg> getEggList() {
        return eggList;
    }

    public Chicken(int id, String name, int house_id) {
        this.id = id;
        this.name = name;
        this.house_id = house_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHouse_id(int house_id) {
        this.house_id = house_id;
    }

    public void setEggList(List<Egg> eggList) {
        this.eggList = eggList;
    }
}
