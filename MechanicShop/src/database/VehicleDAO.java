package database;
import java.sql.*;

public class VehicleDAO {
    Connection conn = DatabaseManager.getInstance().getConnection();

    public void addVehicle(int id,String make,String model){
        try{
            String sql = "insert into vehicle values(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id); ps.setString(2,make); ps.setString(3,model);
            ps.executeUpdate();
        }catch(Exception e){ System.out.println(e.getMessage()); }
    }

    public void showVehicles(){
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from vehicle");
            while(rs.next()){
                System.out.println(rs.getInt(1)+" " + rs.getString(2)+" "+rs.getString(3));
            }
        }catch(Exception e){ System.out.println(e.getMessage()); }
    }
}