package timofey.henhouse.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import timofey.henhouse.Services.HouseService;
import timofey.henhouse.models.House;

import java.util.ArrayList;

@RestController
@RequestMapping("/houses")
public class HouseController {
    @Autowired
    HouseService hs;

    @GetMapping
    ArrayList<House> main(){
        ArrayList<House> houseList = (ArrayList<House>) hs.findAll();
        return houseList;
    }
    @GetMapping("{id}")
    House getOne(@PathVariable int id){
        return hs.findById(id);
    }

    @PostMapping
    public House create(@RequestBody House house){
        hs.save(house);
        return house;
    }
    @PutMapping("{id}")
    public House update(@RequestBody House house){
        hs.update(house);
        return house;
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        hs.deleteById(id);
    }

}
