package services;

import dao.AppointmentDAO;
import entities.Appointment;

import java.util.List;

public class AppointmentService {

    private AppointmentDAO appointmentDAO;

    public AppointmentService(){
        appointmentDAO = new AppointmentDAO();
    }

    public void addAppointment(Appointment appointment){
        appointmentDAO.addAppointment(appointment);
    }

    public Appointment getAppointmentById(int appointmentId){
        return appointmentDAO.getAppointmentById(appointmentId);
    }

    public List<Appointment> getAllAppointments(){
        return appointmentDAO.getAllAppointments();
    }

    public void deleteAppointment(int appointmentId){
        appointmentDAO.deleteAppointment(appointmentId);
    }

    public void updateAppointment(Appointment appointment){
        appointmentDAO.updateAppointment(appointment);
    }

}
