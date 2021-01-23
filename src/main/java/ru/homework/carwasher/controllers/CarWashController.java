package ru.homework.carwasher.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.homework.carwasher.entities.ClientEntity;
import ru.homework.carwasher.services.CarServices;
import java.util.Map;

@RestController
@RequestMapping("/carwash")
@Slf4j
public class CarWashController {

    private final Map<String, CarServices> carServices;

    @Autowired
    public CarWashController(Map<String, CarServices> carServices) {
        this.carServices = carServices;
    }

    @GetMapping("/check")
    public String lifeCheck(){
        return "You have reached car wash controller";
    }

    @PostMapping("/standInLine")
    public void wash(@RequestBody ClientEntity clientEntity){
        log.info(clientEntity.toString());
        log.info(clientEntity.getName() + " has come to " + clientEntity.getService());
        carServices.get(clientEntity.getService()).standInLine(clientEntity);
    }

}
