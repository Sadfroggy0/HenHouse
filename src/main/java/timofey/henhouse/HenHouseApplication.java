package timofey.henhouse;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import timofey.henhouse.Services.ChickenService;
import timofey.henhouse.models.Chicken;
import timofey.henhouse.models.House;
import timofey.henhouse.repositories.ChickenRepository;
import timofey.henhouse.repositories.HouseRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class HenHouseApplication {
    public static void main(String[] args) {
        SpringApplication.run(HenHouseApplication.class, args);

    }
    @Bean
    public CommandLineRunner commandLineRunner(ChickenService cs, HouseRepository hr, ChickenRepository cr){
        return args ->{
            House house = hr.findById(1);
           List<Chicken> l =  house.getChickenList();
           ArrayList<Chicken>arrayList = cs.chickensByHouseId(1);
            System.out.println(house.getChickenList());
        };
    }




}
