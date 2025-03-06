package org.example.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Enable auto-increment
    private int car_Id;

    private String car_Model;

    public Car() {
    }
    public Car(String car_Model) {
        this.car_Model = car_Model;
    }

    public int getCar_Id() {
        return car_Id;
    }

    public void setCar_Id(int car_Id) {
        this.car_Id = car_Id;
    }

    public String getCar_Model() {
        return car_Model;
    }

    public void setCar_Model(String car_Model) {
        this.car_Model = car_Model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "car_Id=" + car_Id +
                ", car_Model='" + car_Model + '\'' +
                '}';
    }
}
