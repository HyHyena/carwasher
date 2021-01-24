package ru.homework.carwasher.entities;

import lombok.Data;
import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

@Entity
@Data
@Table(schema = "carwasher", name = "clients")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            columnDefinition = "serial"
    )
    private Long id;
    private String name;
    private String surname;
    private LocalDate birthday;
    private String service;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private CarEntity carEntity;

}
