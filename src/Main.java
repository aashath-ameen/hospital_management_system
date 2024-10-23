import services.*;
import entities.*;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Instantiate services for patients, doctors, staff, appointments, and billing
        PatientService patientService = new PatientService();
        DoctorService doctorService = new DoctorService();
        StaffService staffService = new StaffService();
        AppointmentService appointmentService = new AppointmentService();
        BillingService billingService = new BillingService();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Main Menu
            System.out.println("\n--- Hospital Management System ---");
            System.out.println("1. Manage Patients");
            System.out.println("2. Manage Doctors");
            System.out.println("3. Manage Staff");
            System.out.println("4. Manage Appointments");
            System.out.println("5. Manage Billing");
            System.out.println("6. Exit");
            System.out.print("Select an option: ");
            int entityChoice = scanner.nextInt();

            switch (entityChoice) {
                case 1 -> manageEntity("Patients", patientService, scanner);
                case 2 -> manageEntity("Doctors", doctorService, scanner);
                case 3 -> manageEntity("Staff", staffService, scanner);
                case 4 -> manageEntity("Appointments", appointmentService, scanner);
                case 5 -> manageEntity("Billing", billingService, scanner);
                case 6 -> {
                    System.out.println("Exiting the system...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice, please try again.");
            }
        }
    }

    // Generic method to manage entities
    private static void manageEntity(String entityName, Object service, Scanner scanner) {
        while (true) {
            System.out.println("\n--- Manage " + entityName + " ---");
            System.out.println("1. Add " + entityName);
            System.out.println("2. Update " + entityName);
            System.out.println("3. Delete " + entityName);
            System.out.println("4. Get " + entityName + " by ID");
            System.out.println("5. Get All " + entityName + "s");
            System.out.println("6. Back to Main Menu");
            System.out.print("Select an operation: ");
            int operationChoice = scanner.nextInt();

            switch (operationChoice) {
                case 1:
                    if (entityName.equals("Patients")) {
                        addPatient((PatientService) service, scanner);
                    } else if (entityName.equals("Doctors")) {
                        addDoctor((DoctorService) service, scanner);
                    } else if (entityName.equals("Staff")) {
                        addStaff((StaffService) service, scanner);
                    } else if (entityName.equals("Appointments")) {
                        addAppointment((AppointmentService) service, scanner);
                    } else if (entityName.equals("Billing")) {
                        addBilling((BillingService) service, scanner);
                    }
                    break;
                case 2:
                    if (entityName.equals("Patients")) {
                        updatePatient((PatientService) service, scanner);
                    } else if (entityName.equals("Doctors")) {
                        updateDoctor((DoctorService) service, scanner);
                    } else if (entityName.equals("Staff")) {
                        updateStaff((StaffService) service, scanner);
                    } else if (entityName.equals("Appointments")) {
                        updateAppointment((AppointmentService) service, scanner);
                    } else if (entityName.equals("Billing")) {
                        updateBilling((BillingService) service, scanner);
                    }
                    break;
                case 3:
                    if (entityName.equals("Patients")) {
                        deletePatient((PatientService) service, scanner);
                    } else if (entityName.equals("Doctors")) {
                        deleteDoctor((DoctorService) service, scanner);
                    } else if (entityName.equals("Staff")) {
                        deleteStaff((StaffService) service, scanner);
                    } else if (entityName.equals("Appointments")) {
                        deleteAppointment((AppointmentService) service, scanner);
                    } else if (entityName.equals("Billing")) {
                        deleteBilling((BillingService) service, scanner);
                    }
                    break;
                case 4:
                    if (entityName.equals("Patients")) {
                        getPatientById((PatientService) service, scanner);
                    } else if (entityName.equals("Doctors")) {
                        getDoctorById((DoctorService) service, scanner);
                    } else if (entityName.equals("Staff")) {
                        getStaffById((StaffService) service, scanner);
                    } else if (entityName.equals("Appointments")) {
                        getAppointmentById((AppointmentService) service, scanner);
                    } else if (entityName.equals("Billing")) {
                        getBillingById((BillingService) service, scanner);
                    }
                    break;
                case 5:
                    if (entityName.equals("Patients")) {
                        getAllPatients((PatientService) service);
                    } else if (entityName.equals("Doctors")) {
                        getAllDoctors((DoctorService) service);
                    } else if (entityName.equals("Staff")) {
                        getAllStaff((StaffService) service);
                    } else if (entityName.equals("Appointments")) {
                        getAllAppointments((AppointmentService) service);
                    } else if (entityName.equals("Billing")) {
                        getAllBilling((BillingService) service);
                    }
                    break;
                case 6:
                    return; // Back to Main Menu
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    // Add, Update, Delete, Get methods for Patients
    private static void addPatient(PatientService patientService, Scanner scanner) {
        System.out.println("Enter Patient Details:");

        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        System.out.print("Address: ");
        String address = scanner.next();
        System.out.print("Phone: ");
        String phone = scanner.next();

        Patient patient = new Patient(name, age, address, phone);

        patientService.addPatient(patient);
        System.out.println("Patient added successfully!");
    }

    private static void updatePatient(PatientService patientService, Scanner scanner) {
        System.out.print("Enter Patient ID to Update: ");
        int id = scanner.nextInt();

        System.out.print("New Name: ");
        String name = scanner.next();
        System.out.print("New Age: ");
        int age = scanner.nextInt();
        System.out.print("New Address: ");
        String address = scanner.next();
        System.out.print("New Phone: ");
        String phone = scanner.next();

        Patient patient = new Patient(id, name, age, address, phone);

        patientService.updatePatient(patient);
        System.out.println("Patient updated successfully!");
    }

    private static void deletePatient(PatientService patientService, Scanner scanner) {
        System.out.print("Enter Patient ID to Delete: ");
        int id = scanner.nextInt();
        patientService.deletePatient(id);
        System.out.println("Patient deleted successfully!");
    }

    private static void getPatientById(PatientService patientService, Scanner scanner) {
        System.out.print("Enter Patient ID: ");
        int id = scanner.nextInt();

        Patient patient = patientService.getPatientById(id);
        System.out.println("Patient Details: " );
        System.out.println("Name: "+patient.getName());
        System.out.println("Age: "+patient.getAge());
        System.out.println("Address: "+ patient.getAddress());
        System.out.println("Phone: "+ patient.getPhone());
    }

    private static void getAllPatients(PatientService patientService) {
        List<Patient> patients = patientService.getAllPatients();

        if (patients.isEmpty()) {
            System.out.println("No patients found.");
        } else {
            for (Patient patient : patients) {
                System.out.println("Patient ID: " + patient.getPatientId());
                System.out.println("Patient Name: " + patient.getName());
                System.out.println("Age: " + patient.getAge());
                System.out.println("Phone: " + patient.getPhone());
                System.out.println("Address: " + patient.getAddress());
                System.out.println("-----------------------------");
            }
        }

    }

    private static void addDoctor(DoctorService doctorService, Scanner scanner) {
        System.out.println("Enter Doctor Details:");

        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Specialty: ");
        String specialty = scanner.next();
        System.out.print("Availability: ");
        String availability = scanner.next();

        Doctor doctor = new Doctor(name,specialty,availability);

        doctorService.addDoctor(doctor);
        System.out.println("Doctor added successfully!");
    }

    private static void updateDoctor(DoctorService doctorService, Scanner scanner) {

        System.out.print("Enter Doctor ID to update: ");
        int id = scanner.nextInt();

        System.out.print("New Name: ");
        String name = scanner.next();
        System.out.print("New Specialty: ");
        String specialty = scanner.next();
        System.out.print("New Availability: ");
        String availability = scanner.next();

        Doctor doctor = new Doctor(id, name,specialty,availability);

        doctorService.updateDoctor(doctor);
        System.out.println("Doctor updated successfully!");
    }

    private static void deleteDoctor(DoctorService doctorService, Scanner scanner) {
        System.out.print("Enter Doctor ID to Delete: ");
        int id = scanner.nextInt();
        doctorService.deleteDoctor(id);
        System.out.println("Doctor deleted successfully!");
    }

    private static void getDoctorById(DoctorService doctorService, Scanner scanner) {
        System.out.print("Enter Doctor ID: ");
        int id = scanner.nextInt();

        Doctor doctor = doctorService.getDoctorById(id);
        System.out.println("Doctor Details: " );
        System.out.println("Name: "+doctor.getName());
        System.out.println("Specialty: "+doctor.getSpecialty());
        System.out.println("Availability: "+ doctor.getAvailability());
    }

    private static void getAllDoctors(DoctorService doctorService) {
        List<Doctor> doctors = doctorService.getAllDoctors();

        if (doctors.isEmpty()) {
            System.out.println("No doctors found.");
        } else {
            for (Doctor doctor : doctors) {
                System.out.println("Doctor ID: " + doctor.getDoctorId());
                System.out.println("Doctor Name: " + doctor.getName());
                System.out.println("Specialty: " + doctor.getSpecialty());
                System.out.println("Availability: " + doctor.getAvailability());
                System.out.println("-----------------------------");
            }
        }
    }

    private static void addStaff(StaffService staffService, Scanner scanner){
        System.out.println("Enter Staff Details:");

        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Role: ");
        String role = scanner.next();
        System.out.print("Department: ");
        String department = scanner.next();

        Staff staff = new Staff(name, role, department);

        staffService.addStaff(staff);
        System.out.println("Staff added successfully!");
    }

    private static void updateStaff(StaffService staffService, Scanner scanner){
        System.out.print("Enter Staff ID to update: ");
        int id = scanner.nextInt();

        System.out.print("New Name: ");
        String name = scanner.next();
        System.out.print("New Role: ");
        String role = scanner.next();
        System.out.print("New Department: ");
        String department = scanner.next();

        Staff staff = new Staff(id, name, role, department);

        staffService.updateStaff(staff);
        System.out.println("Staff updated successfully!");
    }

    private static void deleteStaff(StaffService staffService, Scanner scanner){
        System.out.print("Enter Staff ID to Delete: ");
        int id = scanner.nextInt();
        staffService.deleteStaff(id);
        System.out.println("Staff deleted successfully!");
    }

    private static void getAllStaff(StaffService staffService){
        List<Staff> staffs = staffService.getAllStaffs();

        if (staffs.isEmpty()) {
            System.out.println("No Staffs found.");
        } else {
            for (Staff staff : staffs) {
                System.out.println("Staff ID: " + staff.getStaffId());
                System.out.println("Staff Name: " + staff.getName());
                System.out.println("Role: " + staff.getRole());
                System.out.println("Department: " + staff.getDepartment());
                System.out.println("-----------------------------");
            }
        }
    }

    private static void getStaffById(StaffService staffService, Scanner scanner){
        System.out.print("Enter Staff ID: ");
        int id = scanner.nextInt();

        Staff staff = staffService.getStaffById(id);
        System.out.println("Staff Details: " );
        System.out.println("Name: "+staff.getName());
        System.out.println("Role: "+staff.getRole());
        System.out.println("Department: "+ staff.getDepartment());
    }

    private static void addAppointment(AppointmentService appointmentService, Scanner scanner){
        System.out.println("Enter Appointment Details:");

        System.out.print("Patient ID: ");
        int patient_id = scanner.nextInt();
        System.out.print("Doctor ID: ");
        int doctor_id = scanner.nextInt();
        System.out.print("Appointment Date (yyyy-MM-dd): ");
        String appointment_date = scanner.next();

        Date utilDate = convertStringToUtilDate(appointment_date);

        if (utilDate != null) {
            Appointment appointment = new Appointment(patient_id, doctor_id, utilDate);

            appointmentService.addAppointment(appointment);
            System.out.println("Appointment added successfully!");
        } else {
            System.out.println("Invalid date format.");
        }


    }

    private static void updateAppointment(AppointmentService appointmentService, Scanner scanner){
        System.out.print("Enter Appointment ID to update: ");
        int id = scanner.nextInt();

        System.out.print("New Patient ID: ");
        int patient_id = scanner.nextInt();
        System.out.print("New Doctor ID: ");
        int doctor_id = scanner.nextInt();
        System.out.print("New Appointment Date (yyyy-MM-dd): ");
        String appointment_date = scanner.next();

        Date utilDate = convertStringToUtilDate(appointment_date);

        if (utilDate != null) {
            Appointment appointment = new Appointment(id, patient_id, doctor_id, utilDate);

            appointmentService.updateAppointment(appointment);
            System.out.println("Appointment updated successfully!");
        } else {
            System.out.println("Invalid date format.");
        }
    }

    private static void deleteAppointment(AppointmentService appointmentService, Scanner scanner){
        System.out.print("Enter Appointment ID to Delete: ");
        int id = scanner.nextInt();
        appointmentService.deleteAppointment(id);
        System.out.println("Appointment deleted successfully!");
    }

    private static void getAppointmentById(AppointmentService appointmentService, Scanner scanner){
        System.out.print("Enter Appointment ID: ");
        int id = scanner.nextInt();

        Appointment appointment = appointmentService.getAppointmentById(id);
        System.out.println("Appointment Details: " );
        System.out.println("PatientID: "+appointment.getPatientId());
        System.out.println("DoctorID: "+appointment.getDoctorId());
        System.out.println("Appointment Date: "+ appointment.getAppointmentDate());
    }

    private static void getAllAppointments(AppointmentService appointmentService) {
        List<Appointment> appointments = appointmentService.getAllAppointments();

        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
        } else {
            for (Appointment appointment : appointments) {
                System.out.println("Appointment ID: " + appointment.getAppointmentId());
                System.out.println("Patient ID: " + appointment.getPatientId());
                System.out.println("Doctor ID: " + appointment.getDoctorId());
                System.out.println("Appointment Date: " + appointment.getAppointmentDate());
                System.out.println("-----------------------------");
            }
        }
    }

    public static Date convertStringToUtilDate(String dateString) {
        // Define the expected date format (e.g., "yyyy-MM-dd")
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            // Parse the string into java.util.Date
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();  // Print exception if the date format is invalid
            return null;
        }
    }

    private static void addBilling(BillingService billingService, Scanner scanner){
        System.out.println("Enter Billing Details:");

        System.out.print("Patient ID: ");
        int patient_id = scanner.nextInt();
        System.out.print("Amount: ");
        double amount = scanner.nextDouble();
        System.out.print("Payment Status: ");
        String payment_status = scanner.next();

        Billing billing = new Billing(patient_id, amount, payment_status);

        billingService.addBilling(billing);
        System.out.println("Billing added successfully!");
    }

    private static void updateBilling(BillingService billingService, Scanner scanner){
        System.out.print("Enter Billing ID to update: ");
        int id = scanner.nextInt();

        System.out.print("New Patient ID: ");
        int patient_id = scanner.nextInt();
        System.out.print("New Amount: ");
        double amount = scanner.nextDouble();
        System.out.print("New Payment Status: ");
        String payment_status = scanner.next();

        Billing billing = new Billing(id, patient_id, amount, payment_status);

        billingService.updateBilling(billing);
        System.out.println("Billing updated successfully!");
    }

    private static void deleteBilling(BillingService billingService, Scanner scanner){
        System.out.print("Enter Billing ID to Delete: ");
        int id = scanner.nextInt();
        billingService.deleteBilling(id);
        System.out.println("Billing deleted successfully!");
    }

    private static void getBillingById(BillingService billingService, Scanner scanner){
        System.out.print("Enter Billing ID: ");
        int id = scanner.nextInt();

        Billing billing = billingService.getBillingById(id);
        System.out.println("Billing Details: " );
        System.out.println("PatientID: "+billing.getPatientId());
        System.out.println("Amount: "+billing.getAmount());
        System.out.println("Payment Status: "+ billing.getPaymentStatus());
    }

    private static void getAllBilling(BillingService billingService) {
        List<Billing> billings = billingService.getAllBillings();

        if (billings.isEmpty()) {
            System.out.println("No billing records found.");
        } else {
            for (Billing billing : billings) {
                System.out.println("Billing ID: " + billing.getBillingId());
                System.out.println("Patient ID: " + billing.getPatientId());
                System.out.println("Amount: $" + billing.getAmount());
                System.out.println("Payment Status: " + billing.getPaymentStatus());
                System.out.println("-----------------------------");
            }
        }
    }

}
