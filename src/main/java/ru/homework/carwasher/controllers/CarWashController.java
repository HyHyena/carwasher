package ru.homework.carwasher.controllers;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.homework.carwasher.entities.ClientEntity;
import ru.homework.carwasher.services.CarServices;
import ru.homework.carwasher.utils.QueueHandler;
import ru.homework.carwasher.utils.SimpleQueueHandler;

import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/carwash")
@Slf4j
public class CarWashController {

    private final Map<String, CarServices> carServices;
    private final QueueHandler queueHandler;

    @Autowired
    public CarWashController(Map<String, CarServices> carServices,
                             QueueHandler queueHandler) {
        this.carServices = carServices;
        this.queueHandler = queueHandler;
    }

    @GetMapping("/check")
    public String lifeCheck(){
        return "You have reached car wash controller";
    }

    @PostMapping(value = "/standInLine")
    @ApiOperation(value = "To stand in line, please, specify who you are and what car you want to be serviced.")
    public Long standInLine(@RequestBody ClientEntity clientEntity){
        log.info(clientEntity.getName() + " has come to " + clientEntity.getService());
        if (clientEntity.getCarEntity() == null) {
            log.error(clientEntity.getName() + " has come without his car");
            return null;
        }
        return queueHandler.standInLine(clientEntity);
    }

    @GetMapping("/services")
    @ApiOperation(value = "To know what services are available, send GET request.")
    public Set<String> services(){
        return carServices.keySet();
    }

    @GetMapping("/queuePosition")
    @ApiOperation(value = "To know what's your position in queue, please, specify your name and id in json format")
    public Long position(@RequestBody Long id){
        if (id != null)
            return queueHandler.getPosition(id);
        else return null;
    }

    @DeleteMapping("/getOut")
    @ApiOperation(value = "To get out of queue, please, specify your name in json format.")
    public void getOut(@RequestBody Long id){
        if (id != null)
            queueHandler.getOut(id);
    }

}
