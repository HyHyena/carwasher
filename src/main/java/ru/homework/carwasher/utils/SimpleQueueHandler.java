package ru.homework.carwasher.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.homework.carwasher.entities.ClientEntity;
import ru.homework.carwasher.services.ClientsService;

import java.util.Optional;
import java.util.concurrent.LinkedBlockingDeque;

@Component
@Slf4j
public class SimpleQueueHandler implements QueueHandler {

    private final ClientsService clientsService;
    private final LinkedBlockingDeque<ClientEntity> clientEntities;

    public SimpleQueueHandler(ClientsService clientsService, ClientsQueue clientEntities) {
        this.clientsService = clientsService;
        this.clientEntities = clientEntities;
    }

    public Long standInLine(ClientEntity clientEntity){
        ClientEntity clientEntity1 = clientsService.save(clientEntity);
        clientEntities.add(clientEntity1);
        log.info(clientEntity1.getName() + " is now standing in queue");
        return clientEntity1.getId();
    }

    public Long getPosition(Long id){
        Optional<ClientEntity> byName = clientsService.findById(id);
        long position = 1;
        if (byName.isPresent())
            for (ClientEntity clientEntity : clientEntities) {
                if (clientEntity.getId().equals(byName.get().getId())){
                    return position;
                }
                else position++;
            }
        return null;
    }

    public void getOut(Long id){
        Optional<ClientEntity> byName = clientsService.findById(id);
        if (byName.isPresent()) {
            byName.ifPresent(entity -> clientEntities.removeIf(clientEntity -> clientEntity.getId().equals(entity.getId())));
            byName.ifPresent(entity -> clientsService.deleteClientById(entity.getId()));
            log.info(byName.get().getName() + " has quited the queue");
        }
    }
}
