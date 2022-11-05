package timofey.henhouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import timofey.henhouse.models.Egg;
import timofey.henhouse.models.House;

public interface HouseRepository extends JpaRepository<House,Long> {
    House findById(Integer id);

}
