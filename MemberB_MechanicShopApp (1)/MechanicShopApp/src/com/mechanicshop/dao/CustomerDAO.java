package com.mechanicshop.dao;

import com.mechanicshop.exceptions.CustomerNotFoundException;
import com.mechanicshop.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    private Connection connection;

    public CustomerDAO(Connection connection) {
        this.connection = connection;
    }

    public void addCustomer(Customer customer) throws SQLException {
        String sql = "INSERT INTO customers (first_name, last_name, email, phone, address, membership_type) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, customer.getFirstName());
        stmt.setString(2, customer.getLastName());
        stmt.setString(3, customer.getEmail());
        stmt.setString(4, customer.getPhone());
        stmt.setString(5, customer.getAddress());
        stmt.setString(6, customer.getMembershipType());
        stmt.executeUpdate();
        ResultSet keys = stmt.getGeneratedKeys();
        if (keys.next()) {
            customer.setId(keys.getInt(1));
        }
        System.out.println("Customer added successfully with ID: " + customer.getId());
    }

    public Customer getCustomerById(int id) throws SQLException, CustomerNotFoundException {
        String sql = "SELECT * FROM customers WHERE id = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return mapResultSetToCustomer(rs);
        }
        throw new CustomerNotFoundException("Customer with ID " + id + " not found.");
    }

    public List<Customer> getAllCustomers() throws SQLException {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM customers";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            customers.add(mapResultSetToCustomer(rs));
        }
        return customers;
    }

    public void updateCustomer(Customer customer) throws SQLException, CustomerNotFoundException {
        getCustomerById(customer.getId());
        String sql = "UPDATE customers SET first_name=?, last_name=?, email=?, phone=?, address=?, membership_type=? WHERE id=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, customer.getFirstName());
        stmt.setString(2, customer.getLastName());
        stmt.setString(3, customer.getEmail());
        stmt.setString(4, customer.getPhone());
        stmt.setString(5, customer.getAddress());
        stmt.setString(6, customer.getMembershipType());
        stmt.setInt(7, customer.getId());
        stmt.executeUpdate();
        System.out.println("Customer ID " + customer.getId() + " updated successfully.");
    }

    public void deleteCustomer(int id) throws SQLException, CustomerNotFoundException {
        getCustomerById(id);
        String sql = "DELETE FROM customers WHERE id = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        System.out.println("Customer ID " + id + " deleted successfully.");
    }

    private Customer mapResultSetToCustomer(ResultSet rs) throws SQLException {
        return new Customer(
            rs.getInt("id"),
            rs.getString("first_name"),
            rs.getString("last_name"),
            rs.getString("email"),
            rs.getString("phone"),
            rs.getString("address"),
            rs.getString("membership_type")
        );
    }
}
