package ru.homework.carwasher.entities;

import lombok.Data;
import org.springframework.beans.factory.annotation.Configurable;

import javax.persistence.*;

@Entity
@Data
@Table(schema = "carwasher", name = "car")
public class CarEntity {
    @Id
    private Integer id;
    private String type;
    @OneToOne(mappedBy = "carEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ClientEntity clientEntity;

    public void wash(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void changeTyres(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
