package entities;

public class Doctor {
    private int doctorId;
    private String name;
    private String specialty;
    private String availability;

    public Doctor(String name, String specialty, String availability) {

        this.name = name;
        this.specialty = specialty;
        this.availability = availability;
    }

    public Doctor(int doctorId, String name, String specialty, String availability) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialty = specialty;
        this.availability = availability;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
}

