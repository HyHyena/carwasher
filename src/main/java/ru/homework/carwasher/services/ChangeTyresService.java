package ru.homework.carwasher.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.homework.carwasher.entities.ClientEntity;
import ru.homework.carwasher.utils.ClientsQueue;

@Service("changeTyres")
@Slf4j
public class ChangeTyresService implements CarServices{

    private final ClientsQueue clientEntities;

    @Autowired
    public ChangeTyresService(ClientsQueue clientEntities) {
        this.clientEntities = clientEntities;
    }

    public void standInLine(ClientEntity clientEntity) {
        clientEntities.add(clientEntity);
    }

    @Scheduled(initialDelay = 1000L, fixedRate = 10000L)
    public synchronized void changeTyres(){
        ClientEntity clientEntity = clientEntities.peek();
        if (clientEntity != null && clientEntity.getService().equals("changeTyres")) {
            try {
                ClientEntity client = clientEntities.take();
                log.info("Changing tyres on " + client.getName() + "'s car");
                client.getCarEntity().changeTyres();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        else log.info("there is no one in tyres queue");
    }

}
