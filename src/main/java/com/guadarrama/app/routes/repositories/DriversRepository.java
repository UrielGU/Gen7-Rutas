package com.guadarrama.app.routes.repositories;

import com.guadarrama.app.routes.models.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DriversRepository implements IRepository<Driver> {
    private Connection connection;

    public DriversRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Driver> toList() throws SQLException {
        List<Driver> drivers = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM DRIVERS")){
            while(resultSet.next()){
                Driver a = this.getDriver(resultSet);
                drivers.add(a);
            }
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return drivers;
    }

    @Override
    public Driver getById(Long id) throws SQLException {
        Driver driver = new Driver();
        try(PreparedStatement pstm = connection.prepareStatement("SELECT * FROM DRIVERS WHERE ID_DRIVER = ?")){
            pstm.setLong(1, id);
            try(ResultSet resultSet = pstm.executeQuery()){
                if (resultSet.next())
                    driver = this.getDriver(resultSet);
            }

        }
        return driver;
    }

    @Override
    public void save(Driver driver) throws SQLException {
        String sql = "";
        if(driver.getId_driver() != null && driver.getId_driver() > 0)
            sql = "UPDATE DRIVERS SET NAME=?, SURNAME=?, " +
                    "LASTNAME=?, LICENCE=?, PHONE=?, " +
                    "BIRTHDATE=?, AVAILABILITY=? WHERE ID_DRIVER=?";
        else
            sql = "INSERT INTO DRIVERS(ID_DRIVER, NAME, SURNAME, LASTNAME, LICENCE, PHONE, BIRTHDATE, AVAILABILITY)" +
                    "VALUES (-1,?,?,?,?,?,?,?)";

        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            if(driver.getId_driver()!=null && driver.getId_driver()>0) {
                stmt.setString(1, driver.getName());
                stmt.setString(2, driver.getSurname());
                stmt.setString(3, driver.getLastName());
                stmt.setString(4, driver.getLicence());
                stmt.setString(5, driver.getPhone());
                stmt.setDate(6, Date.valueOf(driver.getBirthDate()));
                stmt.setInt(7, driver.getAvailability() ? 1 : 0);
                stmt.setLong(8, driver.getId_driver());
            }else {
                stmt.setString(1, driver.getName());
                stmt.setString(2, driver.getLastName());
                stmt.setString(3, driver.getSurname());
                stmt.setString(4, driver.getLicence());
                stmt.setString(5, driver.getPhone());
                stmt.setDate(6, Date.valueOf(driver.getBirthDate()));
                stmt.setInt(7, driver.getAvailability() ? 1 : 0);
            }
            stmt.executeUpdate();

        }catch (SQLException ex){

        }
    }

    @Override
    public void delete(Long id) throws SQLException {
        String sql = "DELETE FROM DRIVERS WHERE ID_DRIVER=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setLong(1, id);
            statement.executeUpdate(sql);
        }
    }

    private Driver getDriver(ResultSet resultSet) throws SQLException{
        Driver a = new Driver();
        a.setId_driver(resultSet.getLong("ID_DRIVER"));
        a.setName(resultSet.getString("NAME"));
        a.setSurname(resultSet.getString("SURNAME"));
        a.setLastName(resultSet.getString("LASTNAME"));
        a.setLicence(resultSet.getString("LICENCE"));
        a.setPhone(resultSet.getString("PHONE"));
        a.setBirthDate(resultSet.getDate("BIRTH_DATE").toLocalDate());
        a.setAvailability(resultSet.getBoolean("AVAILABILITY"));
        return a;
    }
}
