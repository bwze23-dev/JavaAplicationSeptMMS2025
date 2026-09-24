package hospital;

import hospital.models.Patient;
import hospital.models.Doctor;
import hospital.models.Nurse;
import hospital.models.Department;
import hospital.models.Appointment;

import hospital.services.PatientService;
import hospital.services.DoctorService;
import hospital.services.NurseService;
import hospital.services.AppointmentService;

import hospital.userview.PatientView;
import hospital.userview.DoctorView;
import hospital.userview.NurseView;
import hospital.userview.AppointmentView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ABCHospitalApp {

    private static final Scanner scanner =
            new Scanner(System.in);

    // =========================================================
    // PATIENT
    // =========================================================

    private static final PatientService patientService =
            new PatientService();

    private static final PatientView patientView =
            new PatientView();


    // =========================================================
    // DOCTOR
    // =========================================================

    private static final DoctorService doctorService =
            new DoctorService();

    private static final DoctorView doctorView =
            new DoctorView();


    // =========================================================
    // NURSE
    // =========================================================

    private static final NurseService nurseService =
            new NurseService();

    private static final NurseView nurseView =
            new NurseView();


    // =========================================================
    // APPOINTMENT
    // =========================================================

    private static final AppointmentService appointmentService =
            new AppointmentService();

    private static final AppointmentView appointmentView =
            new AppointmentView();


    // =========================================================
    // DATE FORMATTER
    // =========================================================

    private static final DateTimeFormatter DATE_TIME_FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");


    // =========================================================
    // MAIN
    // =========================================================

    public static void main(String[] args) {

        while (true) {

            displayMainMenu();

            int choice =
                    readInt(
                            "Enter your choice: "
                    );

            switch (choice) {

                case 1:
                    patientMenu();
                    break;

                case 2:
                    doctorMenu();
                    break;

                case 3:
                    nurseMenu();
                    break;

                case 4:
                    appointmentMenu();
                    break;

                case 5:
                    System.out.println(
                            "Admission Management coming soon."
                    );
                    break;

                case 6:
                    System.out.println(
                            "Laboratory Management coming soon."
                    );
                    break;

                case 7:
                    System.out.println(
                            "Pharmacy Management coming soon."
                    );
                    break;

                case 8:
                    System.out.println(
                            "Billing Management coming soon."
                    );
                    break;

                case 0:

                    System.out.println();

                    System.out.println(
                            "Thank you for using ABC Hospital System."
                    );

                    scanner.close();

                    return;

                default:

                    System.out.println(
                            "Invalid choice."
                    );
            }
        }
    }


    // =========================================================
    // MAIN MENU
    // =========================================================

    private static void displayMainMenu() {

        System.out.println();

        System.out.println(
                "========================================"
        );

        System.out.println(
                "       ABC HOSPITAL MANAGEMENT SYSTEM"
        );

        System.out.println(
                "========================================"
        );

        System.out.println(
                "1. Patient Management"
        );

        System.out.println(
                "2. Doctor Management"
        );

        System.out.println(
                "3. Nurse Management"
        );

        System.out.println(
                "4. Appointment Management"
        );

        System.out.println(
                "5. Admission Management"
        );

        System.out.println(
                "6. Laboratory Management"
        );

        System.out.println(
                "7. Pharmacy Management"
        );

        System.out.println(
                "8. Billing Management"
        );

        System.out.println(
                "0. Exit"
        );

        System.out.println(
                "========================================"
        );
    }


    // =========================================================
    // PATIENT MENU
    // =========================================================

    private static void patientMenu() {

        while (true) {

            System.out.println();

            System.out.println(
                    "========================================"
            );

            System.out.println(
                    "           PATIENT MANAGEMENT"
            );

            System.out.println(
                    "========================================"
            );

            System.out.println(
                    "1. Register Patient"
            );

            System.out.println(
                    "2. View All Patients"
            );

            System.out.println(
                    "3. Find Patient"
            );

            System.out.println(
                    "4. Update Patient"
            );

            System.out.println(
                    "5. Delete Patient"
            );

            System.out.println(
                    "0. Back"
            );

            System.out.println(
                    "========================================"
            );

            int choice =
                    readInt(
                            "Enter your choice: "
                    );

            switch (choice) {

                case 1:
                    registerPatient();
                    break;

                case 2:
                    viewAllPatients();
                    break;

                case 3:
                    findPatient();
                    break;

                case 4:
                    updatePatient();
                    break;

                case 5:
                    deletePatient();
                    break;

                case 0:
                    return;

                default:
                    System.out.println(
                            "Invalid choice."
                    );
            }
        }
    }


    // =========================================================
    // REGISTER PATIENT
    // =========================================================

    private static void registerPatient() {

        System.out.println();

        System.out.println(
                "========== REGISTER PATIENT =========="
        );

        System.out.print(
                "First Name: "
        );

        String firstName =
                scanner.nextLine();

        System.out.print(
                "Last Name: "
        );

        String lastName =
                scanner.nextLine();

        System.out.print(
                "Gender (M/F): "
        );

        char gender =
                scanner.nextLine()
                        .charAt(0);

        System.out.print(
                "Date of Birth (yyyy-MM-dd): "
        );

        LocalDate dateOfBirth =
                LocalDate.parse(
                        scanner.nextLine()
                );

        System.out.print(
                "Phone: "
        );

        String phone =
                scanner.nextLine();

        System.out.print(
                "Email: "
        );

        String email =
                scanner.nextLine();

        System.out.print(
                "Street: "
        );

        String street =
                scanner.nextLine();

        System.out.print(
                "City: "
        );

        String city =
                scanner.nextLine();

        System.out.print(
                "Country: "
        );

        String country =
                scanner.nextLine();

        System.out.print(
                "Blood Group: "
        );

        String bloodGroup =
                scanner.nextLine();

        System.out.print(
                "Genotype: "
        );

        String genotype =
                scanner.nextLine();

        System.out.print(
                "Allergies: "
        );

        String allergies =
                scanner.nextLine();

        System.out.print(
                "Emergency Contact: "
        );

        String emergencyContact =
                scanner.nextLine();

        System.out.print(
                "Emergency Phone: "
        );

        String emergencyPhone =
                scanner.nextLine();

        Patient patient =
                new Patient(
                        0,
                        bloodGroup,
                        genotype,
                        allergies,
                        emergencyContact,
                        emergencyPhone,
                        firstName,
                        lastName,
                        gender,
                        dateOfBirth,
                        phone,
                        email,
                        street,
                        city,
                        country
                );

        boolean success =
                patientService.registerPatient(
                        patient
                );

        if (success) {

            System.out.println();

            System.out.println(
                    "Patient registered successfully."
            );

        } else {

            System.out.println();

            System.out.println(
                    "Failed to register patient."
            );
        }
    }


    // =========================================================
    // VIEW ALL PATIENTS
    // =========================================================

    private static void viewAllPatients() {

        List<Patient> patients =
                patientService.getAllPatients();

        patientView.displayPatients(
                patients
        );
    }


    // =========================================================
    // FIND PATIENT
    // =========================================================

    private static void findPatient() {

        int id =
                readInt(
                        "Enter Patient ID: "
                );

        Patient patient =
                patientService.getPatientById(
                        id
                );

        patientView.displayPatient(
                patient
        );
    }


    // =========================================================
    // UPDATE PATIENT
    // =========================================================

    private static void updatePatient() {

        int id =
                readInt(
                        "Enter Patient ID to update: "
                );

        Patient patient =
                patientService.getPatientById(
                        id
                );

        if (patient == null) {

            System.out.println(
                    "Patient not found."
            );

            return;
        }

        System.out.println();

        System.out.println(
                "Enter new patient information."
        );

        System.out.print(
                "First Name: "
        );

        patient.setFirstName(
                scanner.nextLine()
        );

        System.out.print(
                "Last Name: "
        );

        patient.setLastName(
                scanner.nextLine()
        );

        System.out.print(
                "Gender (M/F): "
        );

        patient.setGender(
                scanner.nextLine()
                        .charAt(0)
        );

        System.out.print(
                "Date of Birth (yyyy-MM-dd): "
        );

        patient.setDateOfBirth(
                LocalDate.parse(
                        scanner.nextLine()
                )
        );

        System.out.print(
                "Phone: "
        );

        patient.setPhone(
                scanner.nextLine()
        );

        System.out.print(
                "Email: "
        );

        patient.setEmail(
                scanner.nextLine()
        );

        System.out.print(
                "Street: "
        );

        patient.setStreet(
                scanner.nextLine()
        );

        System.out.print(
                "City: "
        );

        patient.setCity(
                scanner.nextLine()
        );

        System.out.print(
                "Country: "
        );

        patient.setCountry(
                scanner.nextLine()
        );

        System.out.print(
                "Blood Group: "
        );

        patient.setBloodGroup(
                scanner.nextLine()
        );

        System.out.print(
                "Genotype: "
        );

        patient.setGenotype(
                scanner.nextLine()
        );

        System.out.print(
                "Allergies: "
        );

        patient.setAllergies(
                scanner.nextLine()
        );

        System.out.print(
                "Emergency Contact: "
        );

        patient.setEmergencyContact(
                scanner.nextLine()
        );

        System.out.print(
                "Emergency Phone: "
        );

        patient.setEmergencyPhone(
                scanner.nextLine()
        );

        boolean success =
                patientService.updatePatient(
                        patient
                );

        if (success) {

            System.out.println(
                    "Patient updated successfully."
            );

        } else {

            System.out.println(
                    "Patient update failed."
            );
        }
    }


    // =========================================================
    // DELETE PATIENT
    // =========================================================

    private static void deletePatient() {

        int id =
                readInt(
                        "Enter Patient ID to delete: "
                );

        Patient patient =
                patientService.getPatientById(
                        id
                );

        if (patient == null) {

            System.out.println(
                    "Patient not found."
            );

            return;
        }

        patientView.displayPatient(
                patient
        );

        System.out.print(
                "Are you sure you want to delete this patient? (Y/N): "
        );

        String answer =
                scanner.nextLine();

        if (!answer.equalsIgnoreCase("Y")) {

            System.out.println(
                    "Delete cancelled."
            );

            return;
        }

        boolean success =
                patientService.deletePatient(
                        id
                );

        if (success) {

            System.out.println(
                    "Patient deleted successfully."
            );

        } else {

            System.out.println(
                    "Patient deletion failed."
            );
        }
    }


    // =========================================================
    // DOCTOR MENU
    // =========================================================

    private static void doctorMenu() {

        while (true) {

            System.out.println();

            System.out.println(
                    "========================================"
            );

            System.out.println(
                    "           DOCTOR MANAGEMENT"
            );

            System.out.println(
                    "========================================"
            );

            System.out.println(
                    "1. Register Doctor"
            );

            System.out.println(
                    "2. View All Doctors"
            );

            System.out.println(
                    "3. Find Doctor"
            );

            System.out.println(
                    "4. Update Doctor"
            );

            System.out.println(
                    "5. Delete Doctor"
            );

            System.out.println(
                    "0. Back"
            );

            System.out.println(
                    "========================================"
            );

            int choice =
                    readInt(
                            "Enter your choice: "
                    );

            switch (choice) {

                case 1:
                    registerDoctor();
                    break;

                case 2:
                    viewAllDoctors();
                    break;

                case 3:
                    findDoctor();
                    break;

                case 4:
                    updateDoctor();
                    break;

                case 5:
                    deleteDoctor();
                    break;

                case 0:
                    return;

                default:
                    System.out.println(
                            "Invalid choice."
                    );
            }
        }
    }


    // =========================================================
    // REGISTER DOCTOR
    // =========================================================

    private static void registerDoctor() {

        System.out.println();

        System.out.println(
                "========== REGISTER DOCTOR =========="
        );

        System.out.print(
                "First Name: "
        );

        String firstName =
                scanner.nextLine();

        System.out.print(
                "Last Name: "
        );

        String lastName =
                scanner.nextLine();

        System.out.print(
                "Gender (M/F): "
        );

        char gender =
                scanner.nextLine()
                        .charAt(0);

        System.out.print(
                "Date of Birth (yyyy-MM-dd): "
        );

        LocalDate dateOfBirth =
                LocalDate.parse(
                        scanner.nextLine()
                );

        System.out.print(
                "Phone: "
        );

        String phone =
                scanner.nextLine();

        System.out.print(
                "Email: "
        );

        String email =
                scanner.nextLine();

        System.out.print(
                "Street: "
        );

        String street =
                scanner.nextLine();

        System.out.print(
                "City: "
        );

        String city =
                scanner.nextLine();

        System.out.print(
                "Country: "
        );

        String country =
                scanner.nextLine();


        System.out.print(
                "Employment Date (yyyy-MM-dd): "
        );

        LocalDate employmentDate =
                LocalDate.parse(
                        scanner.nextLine()
                );

        System.out.print(
                "Salary: "
        );

        double salary =
                Double.parseDouble(
                        scanner.nextLine()
                );


        int departmentId =
                readInt(
                        "Department ID: "
                );

        System.out.print(
                "Department Name: "
        );

        String departmentName =
                scanner.nextLine();

        Department department =
                new Department();

        department.setId(
                departmentId
        );

        department.setName(
                departmentName
        );


        System.out.print(
                "Specialization: "
        );

        String specialization =
                scanner.nextLine();

        System.out.print(
                "License Number: "
        );

        String licenseNumber =
                scanner.nextLine();


        Doctor doctor =
                new Doctor(
                        firstName,
                        lastName,
                        gender,
                        dateOfBirth,
                        phone,
                        email,
                        street,
                        city,
                        country,
                        0,
                        employmentDate,
                        salary,
                        department,
                        specialization,
                        licenseNumber
                );


        boolean success =
                doctorService.registerDoctor(
                        doctor
                );

        if (success) {

            System.out.println();

            System.out.println(
                    "Doctor registered successfully."
            );

        } else {

            System.out.println();

            System.out.println(
                    "Failed to register doctor."
            );
        }
    }


    // =========================================================
    // VIEW ALL DOCTORS
    // =========================================================

    private static void viewAllDoctors() {

        List<Doctor> doctors =
                doctorService.getAllDoctors();

        doctorView.displayDoctors(
                doctors
        );
    }


    // =========================================================
    // FIND DOCTOR
    // =========================================================

    private static void findDoctor() {

        int id =
                readInt(
                        "Enter Doctor/Staff ID: "
                );

        Doctor doctor =
                doctorService.getDoctorById(
                        id
                );

        doctorView.displayDoctor(
                doctor
        );
    }


    // =========================================================
    // UPDATE DOCTOR
    // =========================================================

    private static void updateDoctor() {

        int id =
                readInt(
                        "Enter Doctor/Staff ID to update: "
                );

        Doctor doctor =
                doctorService.getDoctorById(
                        id
                );

        if (doctor == null) {

            System.out.println(
                    "Doctor not found."
            );

            return;
        }

        System.out.println();

        doctorView.displayDoctor(
                doctor
        );

        System.out.println();

        System.out.println(
                "Enter new doctor information."
        );


        System.out.print(
                "First Name: "
        );

        doctor.setFirstName(
                scanner.nextLine()
        );

        System.out.print(
                "Last Name: "
        );

        doctor.setLastName(
                scanner.nextLine()
        );

        System.out.print(
                "Gender (M/F): "
        );

        doctor.setGender(
                scanner.nextLine()
                        .charAt(0)
        );

        System.out.print(
                "Date of Birth (yyyy-MM-dd): "
        );

        doctor.setDateOfBirth(
                LocalDate.parse(
                        scanner.nextLine()
                )
        );

        System.out.print(
                "Phone: "
        );

        doctor.setPhone(
                scanner.nextLine()
        );

        System.out.print(
                "Email: "
        );

        doctor.setEmail(
                scanner.nextLine()
        );

        System.out.print(
                "Street: "
        );

        doctor.setStreet(
                scanner.nextLine()
        );

        System.out.print(
                "City: "
        );

        doctor.setCity(
                scanner.nextLine()
        );

        System.out.print(
                "Country: "
        );

        doctor.setCountry(
                scanner.nextLine()
        );


        System.out.print(
                "Employment Date (yyyy-MM-dd): "
        );

        doctor.setEmploymentDate(
                LocalDate.parse(
                        scanner.nextLine()
                )
        );

        System.out.print(
                "Salary: "
        );

        doctor.setSalary(
                Double.parseDouble(
                        scanner.nextLine()
                )
        );


        int departmentId =
                readInt(
                        "Department ID: "
                );

        System.out.print(
                "Department Name: "
        );

        String departmentName =
                scanner.nextLine();

        Department department =
                new Department();

        department.setId(
                departmentId
        );

        department.setName(
                departmentName
        );

        doctor.setDepartment(
                department
        );


        System.out.print(
                "Specialization: "
        );

        doctor.setSpecialization(
                scanner.nextLine()
        );

        System.out.print(
                "License Number: "
        );

        doctor.setLicenseNumber(
                scanner.nextLine()
        );


        boolean success =
                doctorService.updateDoctor(
                        doctor
                );

        if (success) {

            System.out.println();

            System.out.println(
                    "Doctor updated successfully."
            );

        } else {

            System.out.println();

            System.out.println(
                    "Doctor update failed."
            );
        }
    }


    // =========================================================
    // DELETE DOCTOR
    // =========================================================

    private static void deleteDoctor() {

        int id =
                readInt(
                        "Enter Doctor/Staff ID to delete: "
                );

        Doctor doctor =
                doctorService.getDoctorById(
                        id
                );

        if (doctor == null) {

            System.out.println(
                    "Doctor not found."
            );

            return;
        }

        doctorView.displayDoctor(
                doctor
        );

        System.out.print(
                "Are you sure you want to delete this doctor? (Y/N): "
        );

        String answer =
                scanner.nextLine();

        if (!answer.equalsIgnoreCase("Y")) {

            System.out.println(
                    "Delete cancelled."
            );

            return;
        }

        boolean success =
                doctorService.deleteDoctor(
                        id
                );

        if (success) {

            System.out.println(
                    "Doctor deleted successfully."
            );

        } else {

            System.out.println(
                    "Doctor deletion failed."
            );
        }
    }


    // =========================================================
    // NURSE MENU
    // =========================================================

    private static void nurseMenu() {

        while (true) {

            System.out.println();

            System.out.println(
                    "========================================"
            );

            System.out.println(
                    "            NURSE MANAGEMENT"
            );

            System.out.println(
                    "========================================"
            );

            System.out.println(
                    "1. Register Nurse"
            );

            System.out.println(
                    "2. View All Nurses"
            );

            System.out.println(
                    "3. Find Nurse"
            );

            System.out.println(
                    "4. Update Nurse"
            );

            System.out.println(
                    "5. Delete Nurse"
            );

            System.out.println(
                    "0. Back"
            );

            System.out.println(
                    "========================================"
            );

            int choice =
                    readInt(
                            "Enter your choice: "
                    );

            switch (choice) {

                case 1:
                    registerNurse();
                    break;

                case 2:
                    viewAllNurses();
                    break;

                case 3:
                    findNurse();
                    break;

                case 4:
                    updateNurse();
                    break;

                case 5:
                    deleteNurse();
                    break;

                case 0:
                    return;

                default:
                    System.out.println(
                            "Invalid choice."
                    );
            }
        }
    }


    // =========================================================
    // REGISTER NURSE
    // =========================================================

    private static void registerNurse() {

        System.out.println();

        System.out.println(
                "========== REGISTER NURSE =========="
        );

        System.out.println();

        System.out.println(
                "----- PERSONAL INFORMATION -----"
        );

        System.out.print(
                "First Name: "
        );

        String firstName =
                scanner.nextLine();

        System.out.print(
                "Last Name: "
        );

        String lastName =
                scanner.nextLine();

        System.out.print(
                "Gender (M/F): "
        );

        char gender =
                scanner.nextLine()
                        .charAt(0);

        System.out.print(
                "Date of Birth (yyyy-MM-dd): "
        );

        LocalDate dateOfBirth =
                LocalDate.parse(
                        scanner.nextLine()
                );

        System.out.print(
                "Phone: "
        );

        String phone =
                scanner.nextLine();

        System.out.print(
                "Email: "
        );

        String email =
                scanner.nextLine();

        System.out.print(
                "Street: "
        );

        String street =
                scanner.nextLine();

        System.out.print(
                "City: "
        );

        String city =
                scanner.nextLine();

        System.out.print(
                "Country: "
        );

        String country =
                scanner.nextLine();


        System.out.println();

        System.out.println(
                "----- STAFF INFORMATION -----"
        );

        System.out.print(
                "Employment Date (yyyy-MM-dd): "
        );

        LocalDate employmentDate =
                LocalDate.parse(
                        scanner.nextLine()
                );

        System.out.print(
                "Salary: "
        );

        double salary =
                Double.parseDouble(
                        scanner.nextLine()
                );


        System.out.println();

        System.out.println(
                "----- DEPARTMENT INFORMATION -----"
        );

        int departmentId =
                readInt(
                        "Department ID: "
                );

        System.out.print(
                "Department Name: "
        );

        String departmentName =
                scanner.nextLine();

        Department department =
                new Department();

        department.setId(
                departmentId
        );

        department.setName(
                departmentName
        );


        System.out.println();

        System.out.println(
                "----- NURSE INFORMATION -----"
        );

        System.out.print(
                "Nursing License: "
        );

        String nursingLicense =
                scanner.nextLine();

        System.out.print(
                "Qualification: "
        );

        String qualification =
                scanner.nextLine();


        Nurse nurse =
                new Nurse(
                        firstName,
                        lastName,
                        gender,
                        dateOfBirth,
                        phone,
                        email,
                        street,
                        city,
                        country,
                        0,
                        employmentDate,
                        salary,
                        department,
                        nursingLicense,
                        qualification
                );


        boolean success =
                nurseService.registerNurse(
                        nurse
                );

        if (success) {

            System.out.println();

            System.out.println(
                    "Nurse registered successfully."
            );

        } else {

            System.out.println();

            System.out.println(
                    "Failed to register nurse."
            );
        }
    }


    // =========================================================
    // VIEW ALL NURSES
    // =========================================================

    private static void viewAllNurses() {

        List<Nurse> nurses =
                nurseService.getAllNurses();

        nurseView.displayNurses(
                nurses
        );
    }


    // =========================================================
    // FIND NURSE
    // =========================================================

    private static void findNurse() {

        int staffId =
                readInt(
                        "Enter Nurse/Staff ID: "
                );

        Nurse nurse =
                nurseService.getNurseById(
                        staffId
                );

        nurseView.displayNurse(
                nurse
        );
    }


    // =========================================================
    // UPDATE NURSE
    // =========================================================

    private static void updateNurse() {

        int staffId =
                readInt(
                        "Enter Nurse/Staff ID to update: "
                );

        Nurse nurse =
                nurseService.getNurseById(
                        staffId
                );

        if (nurse == null) {

            System.out.println(
                    "Nurse not found."
            );

            return;
        }


        System.out.println();

        System.out.println(
                "Current nurse information:"
        );

        nurseView.displayNurse(
                nurse
        );


        System.out.println();

        System.out.println(
                "Enter new nurse information."
        );


        System.out.println();

        System.out.println(
                "----- PERSONAL INFORMATION -----"
        );

        System.out.print(
                "First Name: "
        );

        nurse.setFirstName(
                scanner.nextLine()
        );

        System.out.print(
                "Last Name: "
        );

        nurse.setLastName(
                scanner.nextLine()
        );

        System.out.print(
                "Gender (M/F): "
        );

        nurse.setGender(
                scanner.nextLine()
                        .charAt(0)
        );

        System.out.print(
                "Date of Birth (yyyy-MM-dd): "
        );

        nurse.setDateOfBirth(
                LocalDate.parse(
                        scanner.nextLine()
                )
        );

        System.out.print(
                "Phone: "
        );

        nurse.setPhone(
                scanner.nextLine()
        );

        System.out.print(
                "Email: "
        );

        nurse.setEmail(
                scanner.nextLine()
        );

        System.out.print(
                "Street: "
        );

        nurse.setStreet(
                scanner.nextLine()
        );

        System.out.print(
                "City: "
        );

        nurse.setCity(
                scanner.nextLine()
        );

        System.out.print(
                "Country: "
        );

        nurse.setCountry(
                scanner.nextLine()
        );


        System.out.println();

        System.out.println(
                "----- STAFF INFORMATION -----"
        );

        System.out.print(
                "Employment Date (yyyy-MM-dd): "
        );

        nurse.setEmploymentDate(
                LocalDate.parse(
                        scanner.nextLine()
                )
        );

        System.out.print(
                "Salary: "
        );

        nurse.setSalary(
                Double.parseDouble(
                        scanner.nextLine()
                )
        );


        System.out.println();

        System.out.println(
                "----- DEPARTMENT INFORMATION -----"
        );

        int departmentId =
                readInt(
                        "Department ID: "
                );

        System.out.print(
                "Department Name: "
        );

        String departmentName =
                scanner.nextLine();

        Department department =
                new Department();

        department.setId(
                departmentId
        );

        department.setName(
                departmentName
        );

        nurse.setDepartment(
                department
        );


        System.out.println();

        System.out.println(
                "----- NURSE INFORMATION -----"
        );

        System.out.print(
                "Nursing License: "
        );

        nurse.setNursingLicense(
                scanner.nextLine()
        );

        System.out.print(
                "Qualification: "
        );

        nurse.setQualification(
                scanner.nextLine()
        );


        boolean success =
                nurseService.updateNurse(
                        nurse
                );

        if (success) {

            System.out.println();

            System.out.println(
                    "Nurse updated successfully."
            );

        } else {

            System.out.println();

            System.out.println(
                    "Nurse update failed."
            );
        }
    }


    // =========================================================
    // DELETE NURSE
    // =========================================================

    private static void deleteNurse() {

        int staffId =
                readInt(
                        "Enter Nurse/Staff ID to delete: "
                );

        Nurse nurse =
                nurseService.getNurseById(
                        staffId
                );

        if (nurse == null) {

            System.out.println(
                    "Nurse not found."
            );

            return;
        }

        nurseView.displayNurse(
                nurse
        );

        System.out.print(
                "Are you sure you want to delete this nurse? (Y/N): "
        );

        String answer =
                scanner.nextLine();

        if (!answer.equalsIgnoreCase("Y")) {

            System.out.println(
                    "Delete cancelled."
            );

            return;
        }

        boolean success =
                nurseService.deleteNurse(
                        staffId
                );

        if (success) {

            System.out.println(
                    "Nurse deleted successfully."
            );

        } else {

            System.out.println(
                    "Nurse deletion failed."
            );
        }
    }


    // =========================================================
    // APPOINTMENT MENU
    // =========================================================

    private static void appointmentMenu() {

        while (true) {

            System.out.println();

            System.out.println(
                    "========================================"
            );

            System.out.println(
                    "        APPOINTMENT MANAGEMENT"
            );

            System.out.println(
                    "========================================"
            );

            System.out.println(
                    "1. Create Appointment"
            );

            System.out.println(
                    "2. View All Appointments"
            );

            System.out.println(
                    "3. Find Appointment"
            );

            System.out.println(
                    "4. Update Appointment"
            );

            System.out.println(
                    "5. Delete Appointment"
            );

            System.out.println(
                    "6. View Patient Appointments"
            );

            System.out.println(
                    "7. View Doctor Appointments"
            );

            System.out.println(
                    "0. Back"
            );

            System.out.println(
                    "========================================"
            );

            int choice =
                    readInt(
                            "Enter your choice: "
                    );

            switch (choice) {

                case 1:
                    createAppointment();
                    break;

                case 2:
                    viewAllAppointments();
                    break;

                case 3:
                    findAppointment();
                    break;

                case 4:
                    updateAppointment();
                    break;

                case 5:
                    deleteAppointment();
                    break;

                case 6:
                    viewPatientAppointments();
                    break;

                case 7:
                    viewDoctorAppointments();
                    break;

                case 0:
                    return;

                default:
                    System.out.println(
                            "Invalid choice."
                    );
            }
        }
    }


    // =========================================================
    // CREATE APPOINTMENT
    // =========================================================

    private static void createAppointment() {

        System.out.println();

        System.out.println(
                "========== CREATE APPOINTMENT =========="
        );


        // =====================================================
        // PATIENT
        // =====================================================

        int patientId =
                readInt(
                        "Enter Patient ID: "
                );

        Patient patient =
                patientService.getPatientById(
                        patientId
                );

        if (patient == null) {

            System.out.println(
                    "Patient not found."
            );

            return;
        }

        System.out.println();

        System.out.println(
                "Patient: "
                        + patient.getFirstName()
                        + " "
                        + patient.getLastName()
        );


        // =====================================================
        // DOCTOR
        // =====================================================

        int doctorId =
                readInt(
                        "Enter Doctor/Staff ID: "
                );

        Doctor doctor =
                doctorService.getDoctorById(
                        doctorId
                );

        if (doctor == null) {

            System.out.println(
                    "Doctor not found."
            );

            return;
        }

        System.out.println();

        System.out.println(
                "Doctor: Dr. "
                        + doctor.getFirstName()
                        + " "
                        + doctor.getLastName()
        );

        System.out.println(
                "Specialization: "
                        + doctor.getSpecialization()
        );


        // =====================================================
        // APPOINTMENT DATE
        // =====================================================

        System.out.println();

        System.out.println(
                "Date format: yyyy-MM-dd HH:mm"
        );

        System.out.print(
                "Appointment Date: "
        );

        String dateInput =
                scanner.nextLine();

        LocalDateTime appointmentDate;

        try {

            appointmentDate =
                    LocalDateTime.parse(
                            dateInput,
                            DATE_TIME_FORMATTER
                    );

        } catch (Exception e) {

            System.out.println(
                    "Invalid date/time format."
            );

            System.out.println(
                    "Please use: yyyy-MM-dd HH:mm"
            );

            return;
        }


        // =====================================================
        // REASON
        // =====================================================

        System.out.print(
                "Reason for Appointment: "
        );

        String reason =
                scanner.nextLine();


        // =====================================================
        // STATUS
        // =====================================================

        String status =
                selectAppointmentStatus();

        if (status == null) {
            return;
        }


        // =====================================================
        // NOTES
        // =====================================================

        System.out.print(
                "Notes: "
        );

        String notes =
                scanner.nextLine();


        // =====================================================
        // CREATE OBJECT
        // =====================================================

        Appointment appointment =
                new Appointment();

        // ID is generated by SQL Server.
        // Do not set the ID manually.

        appointment.setPatient(
                patient
        );

        appointment.setDoctor(
                doctor
        );

        appointment.setAppointmentDate(
                appointmentDate
        );

        appointment.setReason(
                reason
        );

        appointment.setStatus(
                status
        );

        appointment.setNotes(
                notes
        );


        // =====================================================
        // SAVE
        // =====================================================

        boolean success =
                appointmentService.addAppointment(
                        appointment
                );

        if (success) {

            System.out.println();

            System.out.println(
                    "Appointment created successfully."
            );

            if (appointment.getId() > 0) {

                System.out.println(
                        "Appointment ID: "
                                + appointment.getId()
                );
            }

        } else {

            System.out.println();

            System.out.println(
                    "Failed to create appointment."
            );
        }
    }


    // =========================================================
    // SELECT APPOINTMENT STATUS
    // =========================================================

    private static String selectAppointmentStatus() {

        System.out.println();

        System.out.println(
                "Appointment Status"
        );

        System.out.println(
                "1. Scheduled"
        );

        System.out.println(
                "2. Completed"
        );

        System.out.println(
                "3. Cancelled"
        );

        System.out.println(
                "4. Pending"
        );

        int choice =
                readInt(
                        "Select status: "
                );

        switch (choice) {

            case 1:
                return "Scheduled";

            case 2:
                return "Completed";

            case 3:
                return "Cancelled";

            case 4:
                return "Pending";

            default:

                System.out.println(
                        "Invalid status."
                );

                return null;
        }
    }


    // =========================================================
    // VIEW ALL APPOINTMENTS
    // =========================================================

    private static void viewAllAppointments() {

        List<Appointment> appointments =
                appointmentService.getAllAppointments();

        appointmentView.displayAppointments(
                appointments
        );
    }


    // =========================================================
    // FIND APPOINTMENT
    // =========================================================

    private static void findAppointment() {

        int appointmentId =
                readInt(
                        "Enter Appointment ID: "
                );

        Appointment appointment =
                appointmentService.getAppointmentById(
                        appointmentId
                );

        appointmentView.displayAppointment(
                appointment
        );
    }


    // =========================================================
    // UPDATE APPOINTMENT
    // =========================================================

    private static void updateAppointment() {

        int appointmentId =
                readInt(
                        "Enter Appointment ID to update: "
                );

        Appointment appointment =
                appointmentService.getAppointmentById(
                        appointmentId
                );

        if (appointment == null) {

            System.out.println(
                    "Appointment not found."
            );

            return;
        }

        System.out.println();

        System.out.println(
                "Current appointment information:"
        );

        appointmentView.displayAppointment(
                appointment
        );


        // =====================================================
        // PATIENT
        // =====================================================

        int patientId =
                readInt(
                        "Enter new Patient ID: "
                );

        Patient patient =
                patientService.getPatientById(
                        patientId
                );

        if (patient == null) {

            System.out.println(
                    "Patient not found."
            );

            return;
        }

        appointment.setPatient(
                patient
        );


        // =====================================================
        // DOCTOR
        // =====================================================

        int doctorId =
                readInt(
                        "Enter new Doctor/Staff ID: "
                );

        Doctor doctor =
                doctorService.getDoctorById(
                        doctorId
                );

        if (doctor == null) {

            System.out.println(
                    "Doctor not found."
            );

            return;
        }

        appointment.setDoctor(
                doctor
        );


        // =====================================================
        // DATE
        // =====================================================

        System.out.println();

        System.out.println(
                "Date format: yyyy-MM-dd HH:mm"
        );

        System.out.print(
                "Appointment Date: "
        );

        String dateInput =
                scanner.nextLine();

        try {

            appointment.setAppointmentDate(
                    LocalDateTime.parse(
                            dateInput,
                            DATE_TIME_FORMATTER
                    )
            );

        } catch (Exception e) {

            System.out.println(
                    "Invalid date/time format."
            );

            System.out.println(
                    "Please use: yyyy-MM-dd HH:mm"
            );

            return;
        }


        // =====================================================
        // REASON
        // =====================================================

        System.out.print(
                "Reason: "
        );

        appointment.setReason(
                scanner.nextLine()
        );


        // =====================================================
        // STATUS
        // =====================================================

        String status =
                selectAppointmentStatus();

        if (status == null) {
            return;
        }

        appointment.setStatus(
                status
        );


        // =====================================================
        // NOTES
        // =====================================================

        System.out.print(
                "Notes: "
        );

        appointment.setNotes(
                scanner.nextLine()
        );


        // =====================================================
        // UPDATE
        // =====================================================

        boolean success =
                appointmentService.updateAppointment(
                        appointment
                );

        if (success) {

            System.out.println();

            System.out.println(
                    "Appointment updated successfully."
            );

        } else {

            System.out.println();

            System.out.println(
                    "Appointment update failed."
            );
        }
    }


    // =========================================================
    // DELETE APPOINTMENT
    // =========================================================

    private static void deleteAppointment() {

        int appointmentId =
                readInt(
                        "Enter Appointment ID to delete: "
                );

        Appointment appointment =
                appointmentService.getAppointmentById(
                        appointmentId
                );

        if (appointment == null) {

            System.out.println(
                    "Appointment not found."
            );

            return;
        }

        appointmentView.displayAppointment(
                appointment
        );

        System.out.print(
                "Are you sure you want to delete this appointment? (Y/N): "
        );

        String answer =
                scanner.nextLine();

        if (!answer.equalsIgnoreCase("Y")) {

            System.out.println(
                    "Delete cancelled."
            );

            return;
        }

        boolean success =
                appointmentService.deleteAppointment(
                        appointmentId
                );

        if (success) {

            System.out.println(
                    "Appointment deleted successfully."
            );

        } else {

            System.out.println(
                    "Appointment deletion failed."
            );
        }
    }


    // =========================================================
    // VIEW PATIENT APPOINTMENTS
    // =========================================================

    private static void viewPatientAppointments() {

        int patientId =
                readInt(
                        "Enter Patient ID: "
                );

        Patient patient =
                patientService.getPatientById(
                        patientId
                );

        if (patient == null) {

            System.out.println(
                    "Patient not found."
            );

            return;
        }

        System.out.println();

        System.out.println(
                "Appointments for "
                        + patient.getFirstName()
                        + " "
                        + patient.getLastName()
        );

        List<Appointment> appointments =
                appointmentService.getAppointmentsByPatient(
                        patientId
                );

        appointmentView.displayAppointments(
                appointments
        );
    }


    // =========================================================
    // VIEW DOCTOR APPOINTMENTS
    // =========================================================

    private static void viewDoctorAppointments() {

        int doctorId =
                readInt(
                        "Enter Doctor/Staff ID: "
                );

        Doctor doctor =
                doctorService.getDoctorById(
                        doctorId
                );

        if (doctor == null) {

            System.out.println(
                    "Doctor not found."
            );

            return;
        }

        System.out.println();

        System.out.println(
                "Appointments for Dr. "
                        + doctor.getFirstName()
                        + " "
                        + doctor.getLastName()
        );

        List<Appointment> appointments =
                appointmentService.getAppointmentsByDoctor(
                        doctorId
                );

        appointmentView.displayAppointments(
                appointments
        );
    }


    // =========================================================
    // READ INTEGER
    // =========================================================

    private static int readInt(
            String message
    ) {

        while (true) {

            try {

                System.out.print(
                        message
                );

                return Integer.parseInt(
                        scanner.nextLine()
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid number."
                );
            }
        }
    }
}