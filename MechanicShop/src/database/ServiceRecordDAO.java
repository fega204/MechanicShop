package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ServiceRecordDAO {

    Connection conn = DatabaseManager.getInstance().getConnection();

    public void addRecord(int id, int vehicleId, String service, double cost) {

        try {
            String sql = "insert into servicerecord values(?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, vehicleId);
            ps.setString(3, service);
            ps.setDouble(4, cost);

            ps.executeUpdate();

            System.out.println("Record added.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void showRecords() {

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from servicerecord");

            while (rs.next()) {
                System.out.println(
                    rs.getInt(1) + " " +
                    rs.getInt(2) + " " +
                    rs.getString(3) + " $" +
                    rs.getDouble(4)
                );
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteRecord(int id) {

        try {
            String sql = "delete from servicerecord where id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Record deleted.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}