package ru.homework.carwasher.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.homework.carwasher.entities.ClientEntity;

public interface ClientsRepository extends CrudRepository<ClientEntity, Long> {

}
