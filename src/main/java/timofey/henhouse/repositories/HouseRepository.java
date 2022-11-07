package timofey.henhouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import timofey.henhouse.models.Egg;
import timofey.henhouse.models.House;

@Transactional
public interface HouseRepository extends CrudRepository<House,Long> {
    House findById(Integer id);

}
