package timofey.henhouse.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import timofey.henhouse.models.Egg;
import timofey.henhouse.repositories.EggRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EggService implements ICrudService<Egg> {

    @Autowired
    EggRepository eggRepository;

    @Override
    public void save(Egg obj) {
        eggRepository.save(obj);
    }

    @Override
    public void update(Egg obj) {
        eggRepository.save(obj);
    }

    @Override
    public Egg findById(int id) {
        return eggRepository.findById(id);
    }

    @Override
    public List<Egg> findAll() {
       ArrayList<Egg> list = (ArrayList<Egg>) eggRepository.findAll();
       return list;
    }

    @Override
    public void delete(Egg obj) {
        eggRepository.delete(obj);
    }

    @Override
    public void deleteById(int id) {
        eggRepository.deleteById((long) id);
    }
}
