package timofey.henhouse.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import timofey.henhouse.models.House;
import timofey.henhouse.repositories.HouseRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class HouseService implements ICrudService<House> {
    @Autowired
    HouseRepository houseRepository;

    @Override
    public void save(House obj) {
        houseRepository.save(obj);
    }


    @Override
    public House findById(int id) {
        return houseRepository.findById(id);
    }
    @Override
    public void update(House obj) {
        House houseFromDB = houseRepository.findById(obj.getId());
        if(obj.getName() != null ){
            houseFromDB.setName(obj.getName());
        }
        houseRepository.update(obj.getId(), houseFromDB.getName());

    }

    @Override
    public List<House> findAll() {
        ArrayList<House> list = (ArrayList<House>) houseRepository.findAll();
        return list;
    }

    @Override
    public void delete(House obj) {
        houseRepository.delete(obj);
    }

    @Override
    public void deleteById(int id) {
        houseRepository.deleteById(id);
    }
}
