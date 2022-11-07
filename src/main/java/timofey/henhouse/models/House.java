package timofey.henhouse.models;

import javax.persistence.*;

@Entity
@Table(name="house")
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    public House(){}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
