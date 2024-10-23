package dao;

import entities.Patient;
import utils.DatabaseConnection;

import javax.swing.plaf.nimbus.State;
import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {

    public void addPatient(Patient patient){
        try(Connection conn = DatabaseConnection.getConnection()){
            String query = "INSERT INTO patients (name, age, address, phone) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1,patient.getName());
            pst.setInt(2, patient.getAge());
            pst.setString(3, patient.getAddress());
            pst.setString(4,patient.getPhone());
            pst.executeUpdate();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public Patient getPatientById(int patientId) {
        Patient patient=null;
        try(Connection conn = DatabaseConnection.getConnection()){
            String query = "SELECT * FROM patients WHERE patient_id="+patientId+";";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            if (rs.next()) {
                patient = new Patient(
                    rs.getInt("patient_id"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("address"),
                    rs.getString("phone")
                );
            }

        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return patient;
    }

    public List<Patient> getAllPatients(){
        List<Patient> patients = new ArrayList<>();

        try(Connection conn = DatabaseConnection.getConnection()){
            String query = "SELECT * FROM patients";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){

                Patient patient = new Patient(
                        rs.getInt("patient_id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("address"),
                        rs.getString("phone")
                );
                patients.add(patient);

            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }

        return patients;
    }

    public void deletePatient(int patientId){
        try(Connection conn = DatabaseConnection.getConnection()){

            String query = "DELETE FROM patients WHERE patient_id= "+patientId+";";
            Statement st = conn.createStatement();
            st.executeUpdate(query);

        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public void updatePatient(Patient patient){
        try(Connection conn = DatabaseConnection.getConnection()){

            String query = "UPDATE patients SET name=?,age=?,address=?,phone=? where patient_id =?;";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1,patient.getName());
            pst.setInt(2,patient.getAge());
            pst.setString(3, patient.getAddress());
            pst.setString(4, patient.getPhone());
            pst.setInt(5, patient.getPatientId());
            pst.executeUpdate();

        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }


}
