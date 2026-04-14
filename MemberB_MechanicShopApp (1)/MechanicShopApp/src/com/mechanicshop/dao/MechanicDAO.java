package com.mechanicshop.dao;

import com.mechanicshop.exceptions.CustomerNotFoundException;
import com.mechanicshop.model.Mechanic;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MechanicDAO {

    private Connection connection;

    public MechanicDAO(Connection connection) {
        this.connection = connection;
    }

    public void addMechanic(Mechanic mechanic) throws SQLException {
        String sql = "INSERT INTO mechanics (first_name, last_name, email, phone, specialization, hourly_rate) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, mechanic.getFirstName());
        stmt.setString(2, mechanic.getLastName());
        stmt.setString(3, mechanic.getEmail());
        stmt.setString(4, mechanic.getPhone());
        stmt.setString(5, mechanic.getSpecialization());
        stmt.setDouble(6, mechanic.getHourlyRate());
        stmt.executeUpdate();
        ResultSet keys = stmt.getGeneratedKeys();
        if (keys.next()) {
            mechanic.setId(keys.getInt(1));
        }
        System.out.println("Mechanic added successfully with ID: " + mechanic.getId());
    }

    public Mechanic getMechanicById(int id) throws SQLException, CustomerNotFoundException {
        String sql = "SELECT * FROM mechanics WHERE id = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return mapResultSetToMechanic(rs);
        }
        throw new CustomerNotFoundException("Mechanic with ID " + id + " not found.");
    }

    public List<Mechanic> getAllMechanics() throws SQLException {
        List<Mechanic> mechanics = new ArrayList<>();
        String sql = "SELECT * FROM mechanics";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            mechanics.add(mapResultSetToMechanic(rs));
        }
        return mechanics;
    }

    public void updateMechanic(Mechanic mechanic) throws SQLException, CustomerNotFoundException {
        getMechanicById(mechanic.getId());
        String sql = "UPDATE mechanics SET first_name=?, last_name=?, email=?, phone=?, specialization=?, hourly_rate=? WHERE id=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, mechanic.getFirstName());
        stmt.setString(2, mechanic.getLastName());
        stmt.setString(3, mechanic.getEmail());
        stmt.setString(4, mechanic.getPhone());
        stmt.setString(5, mechanic.getSpecialization());
        stmt.setDouble(6, mechanic.getHourlyRate());
        stmt.setInt(7, mechanic.getId());
        stmt.executeUpdate();
        System.out.println("Mechanic ID " + mechanic.getId() + " updated successfully.");
    }

    public void deleteMechanic(int id) throws SQLException, CustomerNotFoundException {
        getMechanicById(id);
        String sql = "DELETE FROM mechanics WHERE id = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        System.out.println("Mechanic ID " + id + " deleted successfully.");
    }

    private Mechanic mapResultSetToMechanic(ResultSet rs) throws SQLException {
        return new Mechanic(
            rs.getInt("id"),
            rs.getString("first_name"),
            rs.getString("last_name"),
            rs.getString("email"),
            rs.getString("phone"),
            rs.getString("specialization"),
            rs.getDouble("hourly_rate")
        );
    }
}
