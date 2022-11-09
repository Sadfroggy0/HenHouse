package timofey.henhouse.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import timofey.henhouse.Services.EggService;
import timofey.henhouse.models.Chicken;
import timofey.henhouse.models.Egg;

import java.util.ArrayList;

@RestController
@RequestMapping("/egg")
public class EggController {
    @Autowired
    EggService es;

    @GetMapping
    ArrayList<Egg> getEggs(){
       return (ArrayList<Egg>) es.findAll();
    }
    @GetMapping("{id}")
    Egg getOne(@PathVariable int id ){

        return es.findById(id);
    }
    @PostMapping()
    public Egg create(@RequestBody Egg egg){
        es.save(egg);
        return egg;
    }
    @PutMapping("{id}")
    public Egg update(@PathVariable("id")int id ,@RequestBody Egg egg){
        es.update(egg);
        return es.findById(egg.getId());
    }


}
