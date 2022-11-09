package timofey.henhouse.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="house")
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    public House(){}
    public House(String name){
        this.name = name;
    }
    public House(int id, String name){
        this.id = id;
        this.name = name;
    }

    @OneToMany(fetch = FetchType.EAGER, targetEntity=Chicken.class, mappedBy="house_id")
    private List<Chicken> chickenList;

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Chicken> getChickenList() {
        return chickenList;
    }
}
