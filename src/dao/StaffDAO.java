package dao;

import entities.Doctor;
import entities.Staff;
import utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StaffDAO {

    public void addStaff(Staff staff){
        try(Connection conn = DatabaseConnection.getConnection()){

            String query = "INSERT INTO staff(name, role, department) VALUES(?,?,?);";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1,staff.getName());
            pst.setString(2, staff.getRole());
            pst.setString(3, staff.getDepartment());
            pst.executeUpdate();

        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public Staff getStaffById(int staffId) {
        Staff staff=null;
        try(Connection conn = DatabaseConnection.getConnection()){
            String query = "SELECT * FROM staff WHERE staff_id="+staffId+";";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            if (rs.next()) {
                staff = new Staff(
                        rs.getInt("staff_id"),
                        rs.getString("name"),
                        rs.getString("role"),
                        rs.getString("department")
                );
            }

        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return staff;
    }

    public List<Staff> getAllStaffs(){
        List<Staff> staffs = new ArrayList<>();

        try(Connection conn = DatabaseConnection.getConnection()){

            String query = "SELECT * FROM staff;";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while(rs.next()){
                Staff staff=new Staff(
                        rs.getInt("staff_id"),
                        rs.getString("name"),
                        rs.getString("role"),
                        rs.getString("department")
                );
                staffs.add(staff);
            }

        }catch(SQLException ex){
            ex.printStackTrace();
        }

        return staffs;
    }

    public void deleteStaff(int staffId){
        try(Connection conn =DatabaseConnection.getConnection()){

            String query="DELETE FROM staff WHERE staff_id = "+ staffId+";";
            Statement st = conn.createStatement();
            st.executeQuery(query);

        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public void updateStaff(Staff staff){
        try(Connection conn = DatabaseConnection.getConnection()){

            String query = "UPDATE staff SET name=?, role=?, department=? WHERE staff_id=?;";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1,staff.getName());
            pst.setString(2, staff.getRole());
            pst.setString(3, staff.getDepartment());
            pst.setInt(4,staff.getStaffId());
            pst.executeUpdate();

        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}
