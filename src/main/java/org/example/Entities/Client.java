package org.example.Entities;

import jakarta.persistence.OneToMany;

public class Client {

    public int client_Id;
    public String client_Name;

    @OneToMany
    public Car car;

}
