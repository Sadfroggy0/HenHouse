package timofey.henhouse.models;

import javax.persistence.*;

@Entity
@Table(name = "egg")
public class Egg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="chicken_id")
    private int chicken_id;
    public Egg(){}

    public int getId() {
        return id;
    }

    public int getChicken_id() {
        return chicken_id;
    }
}
