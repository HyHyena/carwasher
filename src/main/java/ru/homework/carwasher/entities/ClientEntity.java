package ru.homework.carwasher.entities;

import lombok.Data;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

@Entity
@Data
@Table(schema = "carwasher", name = "clients")
public class ClientEntity {

    @Id
    private Long id;
    private String name;
    private String surname;
    private LocalDate birthday;
    private String service;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    private CarEntity carEntity;

}
