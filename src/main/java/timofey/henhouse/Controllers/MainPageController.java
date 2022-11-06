package timofey.henhouse.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import timofey.henhouse.Services.ChickenService;
import timofey.henhouse.models.Chicken;
import timofey.henhouse.repositories.ChickenRepository;

import java.util.ArrayList;

@RestController
@RequestMapping("chickens")
public class MainPageController {

    @Autowired
    private ChickenService cs;
    @GetMapping
    public ArrayList<Chicken> main(){
        ArrayList<Chicken> chickens = (ArrayList<Chicken>) cs.findAll();
        return chickens;
    }
    @GetMapping("{id}")
    public Chicken getOne(@PathVariable("id") int id){
        return cs.findById(id);
    }
    @PostMapping
    public Chicken create(@RequestBody Chicken chicken){
         cs.save(chicken);
         return chicken;
    }
    @PutMapping("{id}")
    public Chicken update(@PathVariable("id")int id ,@RequestBody Chicken chicken){
        Chicken chicken1 = cs.findById(id);
        chicken1 = chicken;
        cs.update(chicken1);
        return chicken1;
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        cs.deleteById(id);
    }

}
