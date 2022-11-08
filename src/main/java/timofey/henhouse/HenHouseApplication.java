package timofey.henhouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import timofey.henhouse.Services.ChickenService;
import timofey.henhouse.Services.HouseService;
import timofey.henhouse.models.Chicken;
import timofey.henhouse.models.House;
import timofey.henhouse.repositories.ChickenRepository;
import timofey.henhouse.repositories.HouseRepository;

@SpringBootApplication
public class HenHouseApplication {
    public static void main(String[] args) {
        SpringApplication.run(HenHouseApplication.class, args);

    }
    @Bean
    public CommandLineRunner commandLineRunner(ChickenService cs, HouseRepository hr, ChickenRepository cr){
        return args ->{
//           Chicken newOne = new Chicken(3, "Bigger", 1);
//           cs.update(newOne);
             Chicken chicken = cr.findById(24);
             System.out.println(cs.findById(24).getName());
            System.out.println("AAAAAAA");
        };
    }




}
