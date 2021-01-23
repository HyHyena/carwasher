package ru.homework.carwasher.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.homework.carwasher.entities.ClientEntity;
import ru.homework.carwasher.utils.ClientsQueue;

@Service("washCar")
@Slf4j
public class WashCarService implements CarServices{

    private final ClientsQueue clientEntities;

    @Autowired
    public WashCarService(ClientsQueue clientEntities) {
        this.clientEntities = clientEntities;
    }

    public void standInLine(ClientEntity clientEntity) {
        clientEntities.add(clientEntity);
    }

    @Scheduled(initialDelay = 1000L, fixedRate = 10000L)
    public synchronized void wash(){
        ClientEntity clientEntity = clientEntities.peek();
        if (clientEntity != null && clientEntity.getService().equals("washCar")) {
            try {
                ClientEntity client = clientEntities.take();
                log.info(client.getName() + "'s car is washing");
                client.getCarEntity().wash();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        else log.info("there is no one in wash queue");
    }
}
