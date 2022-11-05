package timofey.henhouse.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import timofey.henhouse.models.Egg;
@Transactional
public interface EggRepository extends CrudRepository<Egg, Long> {
    Egg findById(Integer id);
}
