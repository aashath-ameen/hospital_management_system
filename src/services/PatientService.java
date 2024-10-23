package services;

import dao.PatientDAO;
import entities.Patient;

import java.util.List;

public class PatientService {

    private PatientDAO patientDAO;

    public PatientService(){
        patientDAO = new PatientDAO();
    }

    public void addPatient(Patient patient){
        patientDAO.addPatient(patient);
    }

    public Patient getPatientById(int patientId) {
        return patientDAO.getPatientById(patientId);
    }

    public List<Patient> getAllPatients(){
        return patientDAO.getAllPatients();
    }

    public void deletePatient(int patientId){
        patientDAO.deletePatient(patientId);
    }

    public void updatePatient(Patient patient){
        patientDAO.updatePatient(patient);
    }


}
