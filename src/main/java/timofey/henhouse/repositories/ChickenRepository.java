package timofey.henhouse.repositories;

import jdk.jfr.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import timofey.henhouse.models.Chicken;

import java.util.Optional;

@Transactional
public interface ChickenRepository extends JpaRepository<Chicken, Long> {
    Chicken findById(Integer id);

}
