package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import models.Invoice;

public class InvoiceDAO {
    Connection connection = DatabaseManager.getInstance().getConnection();

    public boolean addInvoice(Invoice invoice) {
        
        try {String sql = "insert into invoice values(?,?,?,?,?,?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, invoice.getInvoiceId());
                preparedStatement.setInt(2, invoice.getPartId());
                preparedStatement.setInt(3, invoice.getQuantityUsed());
                preparedStatement.setString(4, invoice.getServiceDescription());
                preparedStatement.setDouble(5, invoice.getLaborCost());
                preparedStatement.setDouble(6, invoice.getTotalCost());

                preparedStatement.executeUpdate();
            }

            System.out.println("Invoice added.");
            return true;
        } 
        
        catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        return false;
    }

    public void showInvoices() {
        
        try {String sql = "select * from invoice";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    
                    System.out.println(
                        resultSet.getInt(1) + " " +
                        resultSet.getInt(2) + " " +
                        resultSet.getInt(3) + " " +
                        resultSet.getString(4) + " $" +
                        resultSet.getDouble(5) + " $" +
                        resultSet.getDouble(6)
                    );
                }
            }
        } 
        
        catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
