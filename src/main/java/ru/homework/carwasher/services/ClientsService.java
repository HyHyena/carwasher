package ru.homework.carwasher.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.homework.carwasher.entities.ClientEntity;
import ru.homework.carwasher.repositories.ClientsRepository;

import java.util.Optional;

@Service
public class ClientsService {

    private final ClientsRepository clientsRepository;

    @Autowired
    public ClientsService(ClientsRepository clientsRepository) {
        this.clientsRepository = clientsRepository;
    }

    public ClientEntity save(ClientEntity clientEntity) {
        return clientsRepository.save(clientEntity);
    }

    public Iterable<ClientEntity> findAll() {
        return clientsRepository.findAll();
    }

    public Optional<ClientEntity> findById(Long id) {
        return clientsRepository.findById(id);
    }

    @Transactional
    public void deleteAllClients(){
        clientsRepository.deleteAll();
    }

    @Transactional
    public void deleteClient(ClientEntity userEntity){
        clientsRepository.delete(userEntity);
    }

    @Transactional
    public void deleteClientById(long id){
        clientsRepository.deleteById(id);
    }

}
