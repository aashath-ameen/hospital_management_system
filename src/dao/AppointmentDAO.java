package dao;

import entities.Appointment;
import entities.Billing;
import entities.Staff;
import utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO {

    public void addAppointment(Appointment appointment){
        try(Connection conn = DatabaseConnection.getConnection()){

            String query = "INSERT INTO Appointments(patient_id, doctor_id, appointment_date) VALUES(?,?,?);";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1,appointment.getPatientId());
            pst.setInt(2, appointment.getDoctorId());
            // Convert java.util.Date to java.sql.Date
            java.sql.Date sqlDate = new java.sql.Date(appointment.getAppointmentDate().getTime());
            pst.setDate(3, sqlDate);
            pst.executeUpdate();

        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public Appointment getAppointmentById(int appointmentId) {
        Appointment appointment=null;
        try(Connection conn = DatabaseConnection.getConnection()){
            String query = "SELECT * FROM appointments WHERE appointment_id="+appointmentId+";";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            if (rs.next()) {
                appointment = new Appointment(
                        rs.getInt("appointment_id"),
                        rs.getInt("patient_id"),
                        rs.getInt("doctor_id"),
                        rs.getDate("appointment_date")
                );
            }

        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return appointment;
    }

    public List<Appointment> getAllAppointments(){
        List<Appointment> appointments = new ArrayList<>();

        try(Connection conn = DatabaseConnection.getConnection()){

            String query = "SELECT * FROM appointments;";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while(rs.next()){
                Appointment appointment=new Appointment(
                        rs.getInt("appointment_id"),
                        rs.getInt("patient_id"),
                        rs.getInt("doctor_id"),
                        rs.getDate("appointment_date")
                );
                appointments.add(appointment);
            }

        }catch(SQLException ex){
            ex.printStackTrace();
        }

        return appointments;
    }

    public void deleteAppointment(int appointmentId){
        try(Connection conn =DatabaseConnection.getConnection()){

            String query="DELETE FROM appointments WHERE appointment_id = "+ appointmentId+";";
            Statement st = conn.createStatement();
            st.executeQuery(query);

        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public void updateAppointment(Appointment appointment){
        try(Connection conn = DatabaseConnection.getConnection()){

            String query = "UPDATE appointments SET patient_id=?, doctor_id=?, appointment_date=? WHERE appointment_id=?;";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1,appointment.getPatientId());
            pst.setInt(2, appointment.getDoctorId());
            java.sql.Date sqlDate = new java.sql.Date(appointment.getAppointmentDate().getTime());
            pst.setDate(3, sqlDate);
            pst.setInt(4,appointment.getAppointmentId());
            pst.executeUpdate();

        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}
