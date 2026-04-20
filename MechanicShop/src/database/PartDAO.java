package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import models.Part;

public class PartDAO {

    Connection connection = DatabaseManager.getInstance().getConnection();

    public void addPart(Part part) {

        try {
            String sql = "insert into part values(?,?,?,?)";

            PreparedStatement preparedStatement =
                connection.prepareStatement(sql);

            preparedStatement.setInt(1, part.getPartId());
            preparedStatement.setString(2, part.getPartName());
            preparedStatement.setInt(3, part.getQuantity());
            preparedStatement.setDouble(4, part.getUnitPrice());

            preparedStatement.executeUpdate();

            System.out.println("Part added.");
        }

        catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void showParts() {

        try {
            String sql = "select * from part";

            PreparedStatement preparedStatement =
                connection.prepareStatement(sql);

            ResultSet resultSet =
                preparedStatement.executeQuery();

            while (resultSet.next()) {

                System.out.println(
                    resultSet.getInt(1) + " " +
                    resultSet.getString(2) + " " +
                    resultSet.getInt(3) + " $" +
                    resultSet.getDouble(4)
                );
            }
        }

        catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public ArrayList<Part> getAllParts() {

        ArrayList<Part> parts = new ArrayList<Part>();

        try {
            String sql = "select * from part";

            PreparedStatement preparedStatement =
                connection.prepareStatement(sql);

            ResultSet resultSet =
                preparedStatement.executeQuery();

            while (resultSet.next()) {

                Part part = new Part(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getDouble(4)
                );

                parts.add(part);
            }
        }

        catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        return parts;
    }

    public Part getPartById(int partId) {

        try {
            String sql = "select * from part where id = ?";

            PreparedStatement preparedStatement =
                connection.prepareStatement(sql);

            preparedStatement.setInt(1, partId);

            ResultSet resultSet =
                preparedStatement.executeQuery();

            if (resultSet.next()) {

                return new Part(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getDouble(4)
                );
            }
        }

        catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        return null;
    }

    public void updatePartQuantity(int partId, int quantity) {

        try {
            String sql =
                "update part set quantity = ? where id = ?";

            PreparedStatement preparedStatement =
                connection.prepareStatement(sql);

            preparedStatement.setInt(1, quantity);
            preparedStatement.setInt(2, partId);

            int rowsChanged =
                preparedStatement.executeUpdate();

            if (rowsChanged > 0) {
                System.out.println("Part updated.");
            }
            else {
                System.out.println("Part not found.");
            }
        }

        catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void deletePart(int partId) {

        try {
            String sql =
                "delete from part where id = ?";

            PreparedStatement preparedStatement =
                connection.prepareStatement(sql);

            preparedStatement.setInt(1, partId);

            int rowsChanged =
                preparedStatement.executeUpdate();

            if (rowsChanged > 0) {
                System.out.println("Part deleted.");
            }
            else {
                System.out.println("Part not found.");
            }
        }

        catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}