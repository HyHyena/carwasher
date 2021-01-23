package ru.homework.carwasher.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.homework.carwasher.entities.CarEntity;

public interface CarRepository extends CrudRepository<CarEntity, Long> {

}
