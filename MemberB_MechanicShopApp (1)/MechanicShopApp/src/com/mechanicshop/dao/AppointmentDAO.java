package com.mechanicshop.dao;

import com.mechanicshop.exceptions.AppointmentConflictException;
import com.mechanicshop.exceptions.CustomerNotFoundException;
import com.mechanicshop.model.Appointment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO {

    private Connection connection;

    public AppointmentDAO(Connection connection) {
        this.connection = connection;
    }

    public void addAppointment(Appointment appointment) throws SQLException, AppointmentConflictException {
        if (hasConflict(appointment.getMechanicId(), appointment.getAppointmentDate(), appointment.getAppointmentTime(), -1)) {
            throw new AppointmentConflictException(
                "Mechanic ID " + appointment.getMechanicId() + " already has an appointment on " +
                appointment.getAppointmentDate() + " at " + appointment.getAppointmentTime()
            );
        }
        String sql = "INSERT INTO appointments (customer_id, mechanic_id, vehicle_id, appointment_date, appointment_time, status, notes) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setInt(1, appointment.getCustomerId());
        stmt.setInt(2, appointment.getMechanicId());
        stmt.setInt(3, appointment.getVehicleId());
        stmt.setString(4, appointment.getAppointmentDate());
        stmt.setString(5, appointment.getAppointmentTime());
        stmt.setString(6, appointment.getStatus());
        stmt.setString(7, appointment.getNotes());
        stmt.executeUpdate();
        ResultSet keys = stmt.getGeneratedKeys();
        if (keys.next()) {
            appointment.setId(keys.getInt(1));
        }
        System.out.println("Appointment booked successfully with ID: " + appointment.getId());
    }

    public Appointment getAppointmentById(int id) throws SQLException, CustomerNotFoundException {
        String sql = "SELECT * FROM appointments WHERE id = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return mapResultSetToAppointment(rs);
        }
        throw new CustomerNotFoundException("Appointment with ID " + id + " not found.");
    }

    public List<Appointment> getAllAppointments() throws SQLException {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM appointments";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            appointments.add(mapResultSetToAppointment(rs));
        }
        return appointments;
    }

    public List<Appointment> getAppointmentsByCustomer(int customerId) throws SQLException {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM appointments WHERE customer_id = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, customerId);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            appointments.add(mapResultSetToAppointment(rs));
        }
        return appointments;
    }

    public void updateAppointment(Appointment appointment) throws SQLException, AppointmentConflictException, CustomerNotFoundException {
        getAppointmentById(appointment.getId());
        if (hasConflict(appointment.getMechanicId(), appointment.getAppointmentDate(), appointment.getAppointmentTime(), appointment.getId())) {
            throw new AppointmentConflictException(
                "Mechanic ID " + appointment.getMechanicId() + " already has an appointment on " +
                appointment.getAppointmentDate() + " at " + appointment.getAppointmentTime()
            );
        }
        String sql = "UPDATE appointments SET customer_id=?, mechanic_id=?, vehicle_id=?, appointment_date=?, appointment_time=?, status=?, notes=? WHERE id=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, appointment.getCustomerId());
        stmt.setInt(2, appointment.getMechanicId());
        stmt.setInt(3, appointment.getVehicleId());
        stmt.setString(4, appointment.getAppointmentDate());
        stmt.setString(5, appointment.getAppointmentTime());
        stmt.setString(6, appointment.getStatus());
        stmt.setString(7, appointment.getNotes());
        stmt.setInt(8, appointment.getId());
        stmt.executeUpdate();
        System.out.println("Appointment ID " + appointment.getId() + " updated successfully.");
    }

    public void deleteAppointment(int id) throws SQLException, CustomerNotFoundException {
        getAppointmentById(id);
        String sql = "DELETE FROM appointments WHERE id = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        System.out.println("Appointment ID " + id + " deleted successfully.");
    }

    private boolean hasConflict(int mechanicId, String date, String time, int excludeId) throws SQLException {
        String sql = "SELECT COUNT(*) FROM appointments WHERE mechanic_id = ? AND appointment_date = ? AND appointment_time = ? AND id != ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, mechanicId);
        stmt.setString(2, date);
        stmt.setString(3, time);
        stmt.setInt(4, excludeId);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0;
        }
        return false;
    }

    private Appointment mapResultSetToAppointment(ResultSet rs) throws SQLException {
        return new Appointment(
            rs.getInt("id"),
            rs.getInt("customer_id"),
            rs.getInt("mechanic_id"),
            rs.getInt("vehicle_id"),
            rs.getString("appointment_date"),
            rs.getString("appointment_time"),
            rs.getString("status"),
            rs.getString("notes")
        );
    }
}
