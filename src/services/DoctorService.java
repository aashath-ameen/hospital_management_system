package services;

import dao.DoctorDAO;
import dao.PatientDAO;
import entities.Doctor;
import entities.Patient;

import javax.print.Doc;
import java.util.List;

public class DoctorService {

    private DoctorDAO doctorDAO;

    public DoctorService(){
        doctorDAO = new DoctorDAO();
    }

    public void addDoctor(Doctor doctor){
        doctorDAO.addDoctor(doctor);
    }

    public Doctor getDoctorById(int doctorId) {
        return doctorDAO.getDoctorById(doctorId);
    }

    public List<Doctor> getAllDoctors(){
        return doctorDAO.getAllDoctors();
    }

    public void deleteDoctor(int doctorId){
        doctorDAO.deleteDoctor(doctorId);
    }

    public void updateDoctor(Doctor doctor){
        doctorDAO.updateDoctor(doctor);
    }

}
