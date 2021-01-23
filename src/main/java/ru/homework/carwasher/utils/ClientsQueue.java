package ru.homework.carwasher.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.homework.carwasher.entities.ClientEntity;

import java.util.concurrent.LinkedBlockingDeque;

@Component
@Scope("singleton")
public class ClientsQueue extends LinkedBlockingDeque<ClientEntity> {
}
