package timofey.henhouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import timofey.henhouse.models.Chicken;
import timofey.henhouse.models.Egg;

import java.util.ArrayList;

@Transactional
public interface ChickenRepository extends JpaRepository<Chicken, Long> {
    Chicken findById(int id);
    void deleteById(int id);

    @Modifying
    @Query("UPDATE Chicken c " +
            "set c.name = :name, c.house_id =:house_id " +
            "where c.id = :id")
    void update(int id, String name, int house_id);

    @Query(value = "SELECT * FROM Chicken c WHERE  c.house_id = ?1", nativeQuery = true)
    ArrayList<Chicken> chickensByHouseId(int houseId);

    @Query(value = "SELECT * FROM e Egg where e.chicken_id == ?1 ", nativeQuery = true)
    ArrayList<Egg> findEggsById(int id);
}
