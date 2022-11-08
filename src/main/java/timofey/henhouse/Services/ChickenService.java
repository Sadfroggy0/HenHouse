package timofey.henhouse.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import timofey.henhouse.models.Chicken;
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

    @Override
    public void update(Chicken obj) {
        Chicken chickenFromDB = chickenRepo.findById(obj.getId());
        if(obj.getName() != null ){
            chickenFromDB.setName(obj.getName());
        }
        if(obj.getHouse_id() != 0){
            chickenFromDB.setHouse_id(obj.getHouse_id());
        }
        chickenRepo.updateName(obj.getId(), chickenFromDB.getName());

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
}
