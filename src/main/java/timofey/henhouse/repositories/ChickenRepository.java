package timofey.henhouse.repositories;

import jdk.jfr.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import timofey.henhouse.models.Chicken;

import java.util.Optional;

@Transactional
public interface ChickenRepository extends JpaRepository<Chicken, Long> {
    Chicken findById(int id);
    void deleteById(int id);

    @Modifying
    @Query("UPDATE Chicken c set c.name = :name where c.id = :id")
    void updateName(int id, String name);

}
