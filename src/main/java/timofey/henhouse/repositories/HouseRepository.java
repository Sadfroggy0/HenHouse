package timofey.henhouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import timofey.henhouse.models.Egg;
import timofey.henhouse.models.House;

@Transactional
public interface HouseRepository extends CrudRepository<House,Long> {
    House findById(int id);
    void deleteById(int id);

    @Modifying
    @Query("UPDATE House h " +
            "SET h.name = ?2 " +
            "where h.id = ?1")
    void update(int id, String name);

}
