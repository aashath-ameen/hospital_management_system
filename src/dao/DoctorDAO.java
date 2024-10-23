package dao;

import entities.Appointment;
import entities.Doctor;
import utils.DatabaseConnection;

import javax.print.Doc;
import javax.swing.plaf.nimbus.State;
import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {

    public void addDoctor(Doctor doctor){
        try(Connection conn = DatabaseConnection.getConnection()){

            String query = "INSERT INTO doctors(name, specialty, availability) VALUES(?,?,?);";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1,doctor.getName());
            pst.setString(2, doctor.getSpecialty());
            pst.setString(3, doctor.getAvailability());
            pst.executeUpdate();

        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public Doctor getDoctorById(int doctorId) {
        Doctor doctor=null;
        try(Connection conn = DatabaseConnection.getConnection()){
            String query = "SELECT * FROM doctors WHERE doctor_id="+doctorId+";";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            if (rs.next()) {
                doctor = new Doctor(
                        rs.getInt("doctor_id"),
                        rs.getString("name"),
                        rs.getString("specialty"),
                        rs.getString("availability")
                );
            }

        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return doctor;
    }


    public List<Doctor> getAllDoctors(){
        List<Doctor> doctors = new ArrayList<>();

        try(Connection conn = DatabaseConnection.getConnection()){

            String query = "SELECT * FROM doctors;";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while(rs.next()){
                Doctor doctor=new Doctor(
                        rs.getInt("doctor_id"),
                        rs.getString("name"),
                        rs.getString("specialty"),
                        rs.getString("availability")
                );
                doctors.add(doctor);
            }

        }catch(SQLException ex){
            ex.printStackTrace();
        }

        return doctors;
    }

    public void deleteDoctor(int doctorId){
        try(Connection conn =DatabaseConnection.getConnection()){

            String query="DELETE FROM doctors WHERE doctor_id = "+ doctorId+";";
            Statement st = conn.createStatement();
            st.executeQuery(query);

        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public void updateDoctor(Doctor doctor){
        try(Connection conn = DatabaseConnection.getConnection()){

            String query = "UPDATE doctors SET name=?, specialty=?, availability=? WHERE doctor_id=?;";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1,doctor.getName());
            pst.setString(2, doctor.getSpecialty());
            pst.setString(3, doctor.getAvailability());
            pst.setInt(4,doctor.getDoctorId());
            pst.executeUpdate();

        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

}
