package timofey.henhouse.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import timofey.henhouse.models.Chicken;
import timofey.henhouse.models.Egg;
import timofey.henhouse.repositories.ChickenRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ChickenService implements ICrudService<Chicken> {
    @Autowired
    protected ChickenRepository chickenRepo;

    @Override
    public void save(Chicken obj) {
        chickenRepo.save(obj);
    }

    public ArrayList<Chicken> chickensByHouseId(int id){
       return chickenRepo.chickensByHouseId(id);
    }

    @Override
    public void update(Chicken obj) {
        Chicken chickenFromDB = chickenRepo.findById(obj.getId());
        if(obj.getName() != null ){
            chickenFromDB.setName(obj.getName());
        }
        if(obj.getHouse_id() != 0 & obj.getHouse_id() >=-1){
            chickenFromDB.setHouse_id(obj.getHouse_id());
        }
        chickenRepo.update(obj.getId(), chickenFromDB.getName(), chickenFromDB.getHouse_id());

    }

    @Override
    public Chicken findById(int id) {
        return chickenRepo.findById(id);
    }

    @Override
    public List<Chicken> findAll() {
        ArrayList<Chicken> list =(ArrayList<Chicken>) chickenRepo.findAll();
        return list;
    }

    @Override
    public void delete(Chicken obj) {
        chickenRepo.delete(obj);
    }

    @Override
    public void deleteById(int id) {
        chickenRepo.deleteById(id);
    }

    public ArrayList<Egg> findEggsById(int id) {
        return chickenRepo.findEggsById(id);
    }
}
