package timofey.henhouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import timofey.henhouse.models.Chicken;

import java.util.Optional;

@Transactional
public interface ChickenRepository extends JpaRepository<Chicken, Long>{
    Chicken findById(Integer id);

}
