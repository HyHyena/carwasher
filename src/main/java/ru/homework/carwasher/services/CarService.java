package ru.homework.carwasher.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.homework.carwasher.entities.CarEntity;
import ru.homework.carwasher.repositories.CarRepository;

import java.util.Optional;

@Service
public class CarService {
    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public CarEntity save(CarEntity clientEntity) {
        return carRepository.save(clientEntity);
    }

    public Iterable<CarEntity> findAll() {
        return carRepository.findAll();
    }

    public Optional<CarEntity> findById(long id) {
        return carRepository.findById(id);
    }

    @Transactional
    public void deleteAllCars(){
        carRepository.deleteAll();
    }

    @Transactional
    public void deleteCar(CarEntity userEntity){
        carRepository.delete(userEntity);
    }

    @Transactional
    public void deleteCarById(long id){
        carRepository.deleteById(id);
    }
    
}
