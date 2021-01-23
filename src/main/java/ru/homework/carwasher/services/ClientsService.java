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

    public Optional<ClientEntity> findById(long id) {
        return clientsRepository.findById(id);
    }

    public Optional<ClientEntity> findByName(String name){
        return clientsRepository.findByName(name);
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

    @Transactional
    public void deleteClientByName(String name){
        clientsRepository.deleteByName(name);
    }
    
}
