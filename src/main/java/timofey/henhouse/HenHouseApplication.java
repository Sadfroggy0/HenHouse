package timofey.henhouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import timofey.henhouse.Services.HouseService;
import timofey.henhouse.models.House;
import timofey.henhouse.repositories.HouseRepository;

@SpringBootApplication
public class HenHouseApplication {
    public static void main(String[] args) {
        SpringApplication.run(HenHouseApplication.class, args);

    }
    @Bean
    public CommandLineRunner commandLineRunner(HouseRepository hr){
        return args ->{
//            hr.save(new House( "Newhouse"));
        };
    }




}
