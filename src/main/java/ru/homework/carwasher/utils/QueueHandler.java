package ru.homework.carwasher.utils;

import ru.homework.carwasher.entities.ClientEntity;

public interface QueueHandler {
    Long standInLine(ClientEntity clientEntity);

    Long getPosition(Long id);

    void getOut(Long id);
}
