package org.example.Entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CompanyDAO {

    private final Connection connection;

    public CompanyDAO(Connection connection) {
        this.connection = connection;
    }

    public void insertCar(Car car)
    {
        String sqlAddCar = "INSERT IGNORE INTO car (car_Model) VALUES (?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlAddCar))
        {
            preparedStatement.setString(1,car.getCar_Model());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void registerClient(Client client, String car_Model)
    {
        String sqlAddClient = "INSERT IGNORE INTO client (client_Name, car_Id) VALUES (?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlAddClient))
        {
            //verificam daca modelul ales este in lista de masini!
            //daca da - adaugam clientul
            //daca nu - nu se adauga
            preparedStatement.setString(1, client.getClient_Name());
            preparedStatement.setInt(2, 2); //car_Id

            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

}
