package ru.homework.carwasher.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.homework.carwasher.entities.ClientEntity;

import java.util.Optional;

public interface ClientsRepository extends CrudRepository<ClientEntity, Long> {


    Optional<ClientEntity> findByName(String name);

    void deleteByName(String name);
}
