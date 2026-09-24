package hospital;

import hospital.models.*;
import hospital.services.*;
import hospital.userview.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ABCHospitalApp {

    private static final Scanner scanner = new Scanner(System.in);

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    // ---- services ----
    private static final AuthService authService = new AuthService();
    private static final PatientService patientService = new PatientService();
    private static final DoctorService doctorService = new DoctorService();
    private static final NurseService nurseService = new NurseService();
    private static final PharmacistService pharmacistService = new PharmacistService();
    private static final LaboratoryTechnicianService laboratoryTechnicianService = new LaboratoryTechnicianService();
    private static final AppointmentService appointmentService = new AppointmentService();
    private static final AdmissionService admissionService = new AdmissionService();
    private static final WardService wardService = new WardService();
    private static final RoomService roomService = new RoomService();
    private static final BedService bedService = new BedService();
    private static final NurseAssignmentService nurseAssignmentService = new NurseAssignmentService();
    private static final DiagnosisService diagnosisService = new DiagnosisService();
    private static final TreatmentService treatmentService = new TreatmentService();
    private static final MedicalRecordService medicalRecordService = new MedicalRecordService();
    private static final LaboratoryTestService laboratoryTestService = new LaboratoryTestService();
    private static final MedicationService medicationService = new MedicationService();
    private static final PrescriptionService prescriptionService = new PrescriptionService();
    private static final MedicationDispensingService medicationDispensingService = new MedicationDispensingService();
    private static final InvoiceService invoiceService = new InvoiceService();
    private static final PaymentService paymentService = new PaymentService();
    private static final DepartmentService departmentService = new DepartmentService();
    private static final UserAccountService userAccountService = new UserAccountService();

    // ---- userviews ----
    private static final PatientView patientView = new PatientView();
    private static final DoctorView doctorView = new DoctorView();
    private static final NurseView nurseView = new NurseView();
    private static final PharmacistView pharmacistView = new PharmacistView();
    private static final LaboratoryTechnicianView laboratoryTechnicianView = new LaboratoryTechnicianView();
    private static final AppointmentView appointmentView = new AppointmentView();
    private static final AdmissionView admissionView = new AdmissionView();
    private static final WardView wardView = new WardView();
    private static final RoomView roomView = new RoomView();
    private static final BedView bedView = new BedView();
    private static final NurseAssignmentView nurseAssignmentView = new NurseAssignmentView();
    private static final DiagnosisView diagnosisView = new DiagnosisView();
    private static final TreatmentView treatmentView = new TreatmentView();
    private static final MedicalRecordView medicalRecordView = new MedicalRecordView();
    private static final LaboratoryTestView laboratoryTestView = new LaboratoryTestView();
    private static final MedicationView medicationView = new MedicationView();
    private static final PrescriptionView prescriptionView = new PrescriptionView();
    private static final MedicationDispensingView medicationDispensingView = new MedicationDispensingView();
    private static final InvoiceView invoiceView = new InvoiceView();
    private static final PaymentView paymentView = new PaymentView();
    private static final DepartmentView departmentView = new DepartmentView();
    private static final UserView userView = new UserView();

    private static User currentUser;

    // =========================================================
    // MAIN
    // =========================================================

    public static void main(String[] args) {

        System.out.println("================================================================");
        System.out.println("                 ABC HOSPITAL MANAGEMENT SYSTEM");
        System.out.println("================================================================");

        if (!login()) {
            scanner.close();
            return;
        }

        while (true) {

            displayMainMenu();

            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> showDashboard();
                case 2 -> patientMenu();
                case 3 -> staffMenu();
                case 4 -> appointmentMenu();
                case 5 -> admissionBedMenu();
                case 6 -> clinicalMenu();
                case 7 -> laboratoryMenu();
                case 8 -> pharmacyMenu();
                case 9 -> billingMenu();
                case 10 -> hospitalAdministrationMenu();
                case 11 -> userAccountMenu();
                case 0 -> {
                    System.out.println();
                    System.out.println("Thank you for using ABC Hospital Management System.");
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    // =========================================================
    // LOGIN
    // =========================================================

    private static boolean login() {

        while (true) {

            System.out.println();
            System.out.println("================================================================");
            System.out.println("                            LOGIN");
            System.out.println("================================================================");

            System.out.print("Username: ");
            String username = scanner.nextLine();

            System.out.print("Password: ");
            String password = scanner.nextLine();

            User user = authService.login(username, password);

            if (user != null) {
                currentUser = user;
                System.out.println();
                System.out.println("LOGIN SUCCESSFUL");
                System.out.println("Welcome, " + user.getUsername());
                System.out.println("Role: " + user.getRole());
                return true;
            }

            System.out.print("Try again? (Y/N): ");
            String retry = scanner.nextLine();
            if (retry.equalsIgnoreCase("N")) {
                System.out.println();
                System.out.println("Thank you for using ABC Hospital Management System.");
                System.out.println("Goodbye!");
                return false;
            }
        }
    }

    // =========================================================
    // DASHBOARD
    // =========================================================

    private static void showDashboard() {

        System.out.println();
        System.out.println("================================================================");
        System.out.println("                       ABC HOSPITAL");
        System.out.println("                        DASHBOARD");
        System.out.println("================================================================");
        System.out.printf("%-24s: %s%n", "Logged-in User", currentUser.getUsername());
        System.out.printf("%-24s: %s%n", "Role", currentUser.getRole());
        System.out.printf("%-24s: %s%n", "Account Status", currentUser.isActive() ? "ACTIVE" : "INACTIVE");
        System.out.println("----------------------------------------------------------------");
        System.out.printf("%-24s: %s%n", "System Status", "ONLINE");
        System.out.println("----------------------------------------------------------------");
    }

    // =========================================================
    // MAIN MENU
    // =========================================================

    private static void displayMainMenu() {

        System.out.println();
        System.out.println("================================================================");
        System.out.println("                 ABC HOSPITAL MANAGEMENT SYSTEM");
        System.out.println("================================================================");
        System.out.println("1.  Dashboard");
        System.out.println("2.  Patient Management");
        System.out.println("3.  Staff Management");
        System.out.println("4.  Appointment Management");
        System.out.println("5.  Admission & Bed Management");
        System.out.println("6.  Clinical Management");
        System.out.println("7.  Laboratory Services");
        System.out.println("8.  Pharmacy Services");
        System.out.println("9.  Billing & Payment");
        System.out.println("10. Hospital Administration");
        System.out.println("11. User Account");
        System.out.println("0.  Logout");
        System.out.println("================================================================");
    }

    // =========================================================
    // PATIENT MANAGEMENT
    // =========================================================

    private static void patientMenu() {

        while (true) {

            System.out.println();
            System.out.println("================================================================");
            System.out.println("                     PATIENT MANAGEMENT");
            System.out.println("================================================================");
            System.out.println("1.  Register Patient");
            System.out.println("2.  View All Patients");
            System.out.println("3.  Find Patient");
            System.out.println("4.  Update Patient");
            System.out.println("5.  Delete Patient");
            System.out.println("6.  View Patient Profile");
            System.out.println("7.  View Medical History");
            System.out.println("8.  View Patient Appointments");
            System.out.println("9.  View Patient Admissions");
            System.out.println("10. View Patient Prescriptions");
            System.out.println("11. View Patient Billing History");
            System.out.println("0.  Back");
            System.out.println("================================================================");

            switch (readInt("Enter your choice: ")) {
                case 1 -> registerPatient();
                case 2 -> patientView.displayPatients(patientService.getAllPatients());
                case 3 -> findPatient();
                case 4 -> updatePatient();
                case 5 -> deletePatient();
                case 6 -> viewPatientProfile();
                case 7 -> viewPatientMedicalHistory();
                case 8 -> viewPatientAppointments();
                case 9 -> viewPatientAdmissions();
                case 10 -> viewPatientPrescriptions();
                case 11 -> viewPatientBillingHistory();
                case 0 -> { return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void registerPatient() {

        System.out.println();
        System.out.println("========== REGISTER PATIENT ==========");

        System.out.print("First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();

        char gender = readChar("Gender (M/F): ");
        LocalDate dateOfBirth = readDate("Date of Birth (yyyy-MM-dd): ");

        System.out.print("Phone: ");
        String phone = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Street: ");
        String street = scanner.nextLine();

        System.out.print("City: ");
        String city = scanner.nextLine();

        System.out.print("Country: ");
        String country = scanner.nextLine();

        System.out.print("Blood Group: ");
        String bloodGroup = scanner.nextLine();

        System.out.print("Genotype: ");
        String genotype = scanner.nextLine();

        System.out.print("Allergies: ");
        String allergies = scanner.nextLine();

        System.out.print("Emergency Contact: ");
        String emergencyContact = scanner.nextLine();

        System.out.print("Emergency Phone: ");
        String emergencyPhone = scanner.nextLine();

        Patient patient = new Patient(0, bloodGroup, genotype, allergies, emergencyContact, emergencyPhone,
                firstName, lastName, gender, dateOfBirth, phone, email, street, city, country);

        if (patientService.registerPatient(patient)) {
            patientView.displayPatientRegistered();
        } else {
            System.out.println("Failed to register patient.");
        }
    }

    private static void findPatient() {
        int id = readInt("Enter Patient ID: ");
        patientView.displayPatient(patientService.getPatientById(id));
    }

    private static void updatePatient() {

        int id = readInt("Enter Patient ID to update: ");
        Patient patient = patientService.getPatientById(id);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.println("Leave blank to keep the current value.");

        System.out.print("Phone [" + patient.getPhone() + "]: ");
        String phone = scanner.nextLine();
        if (!phone.isBlank()) patient.setPhone(phone);

        System.out.print("Email [" + patient.getEmail() + "]: ");
        String email = scanner.nextLine();
        if (!email.isBlank()) patient.setEmail(email);

        System.out.print("Street [" + patient.getStreet() + "]: ");
        String street = scanner.nextLine();
        if (!street.isBlank()) patient.setStreet(street);

        System.out.print("City [" + patient.getCity() + "]: ");
        String city = scanner.nextLine();
        if (!city.isBlank()) patient.setCity(city);

        System.out.print("Blood Group [" + patient.getBloodGroup() + "]: ");
        String bloodGroup = scanner.nextLine();
        if (!bloodGroup.isBlank()) patient.setBloodGroup(bloodGroup);

        System.out.print("Allergies [" + patient.getAllergies() + "]: ");
        String allergies = scanner.nextLine();
        if (!allergies.isBlank()) patient.setAllergies(allergies);

        System.out.print("Emergency Contact [" + patient.getEmergencyContact() + "]: ");
        String emergencyContact = scanner.nextLine();
        if (!emergencyContact.isBlank()) patient.setEmergencyContact(emergencyContact);

        System.out.print("Emergency Phone [" + patient.getEmergencyPhone() + "]: ");
        String emergencyPhone = scanner.nextLine();
        if (!emergencyPhone.isBlank()) patient.setEmergencyPhone(emergencyPhone);

        if (patientService.updatePatient(patient)) {
            patientView.displayPatientUpdated();
        } else {
            System.out.println("Failed to update patient.");
        }
    }

    private static void deletePatient() {

        int id = readInt("Enter Patient ID to delete: ");
        System.out.print("Are you sure? (Y/N): ");
        String confirm = scanner.nextLine();

        if (!confirm.equalsIgnoreCase("Y")) {
            System.out.println("Cancelled.");
            return;
        }

        if (patientService.deletePatient(id)) {
            patientView.displayPatientDeleted();
        } else {
            System.out.println("Failed to delete patient.");
        }
    }

    private static void viewPatientProfile() {
        int id = readInt("Enter Patient ID: ");
        patientView.displayPatient(patientService.getPatientById(id));
    }

    private static void viewPatientMedicalHistory() {

        int id = readInt("Enter Patient ID: ");

        System.out.println();
        System.out.println("---- Diagnoses ----");
        diagnosisView.displayDiagnoses(diagnosisService.getDiagnosesByPatient(id));

        System.out.println("---- Treatments ----");
        treatmentView.displayTreatments(treatmentService.getTreatmentsByPatient(id));

        System.out.println("---- Medical Records ----");
        medicalRecordView.displayRecords(medicalRecordService.getMedicalRecordsByPatient(id));
    }

    private static void viewPatientAppointments() {
        int id = readInt("Enter Patient ID: ");
        appointmentView.displayAppointments(appointmentService.getAppointmentsByPatient(id));
    }

    private static void viewPatientAdmissions() {
        int id = readInt("Enter Patient ID: ");
        admissionView.displayAdmissions(admissionService.getAdmissionsByPatient(id));
    }

    private static void viewPatientPrescriptions() {
        int id = readInt("Enter Patient ID: ");
        prescriptionView.displayPrescriptions(prescriptionService.getPrescriptionsByPatient(id));
    }

    private static void viewPatientBillingHistory() {
        int id = readInt("Enter Patient ID: ");
        invoiceView.displayInvoices(invoiceService.getInvoicesByPatient(id));
    }

    // =========================================================
    // STAFF MANAGEMENT
    // =========================================================

    private static void staffMenu() {

        while (true) {

            System.out.println();
            System.out.println("================================================================");
            System.out.println("                      STAFF MANAGEMENT");
            System.out.println("================================================================");
            System.out.println("1. Doctor Management");
            System.out.println("2. Nurse Management");
            System.out.println("3. Pharmacist Management");
            System.out.println("4. Laboratory Technician Management");
            System.out.println("5. View All Staff");
            System.out.println("6. Find Staff");
            System.out.println("7. View Staff by Department");
            System.out.println("8. Staff Account Management");
            System.out.println("0. Back");
            System.out.println("================================================================");

            switch (readInt("Enter your choice: ")) {
                case 1 -> doctorMenu();
                case 2 -> nurseMenu();
                case 3 -> pharmacistMenu();
                case 4 -> laboratoryTechnicianMenu();
                case 5 -> viewAllStaff();
                case 6 -> findStaff();
                case 7 -> viewStaffByDepartment();
                case 8 -> userManagementMenu();
                case 0 -> { return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    // ---- Doctor ----

    private static void doctorMenu() {

        while (true) {

            System.out.println();
            System.out.println("========== DOCTOR MANAGEMENT ==========");
            System.out.println("1. Register Doctor");
            System.out.println("2. View All Doctors");
            System.out.println("3. Find Doctor");
            System.out.println("4. Update Doctor");
            System.out.println("5. Delete Doctor");
            System.out.println("0. Back");

            switch (readInt("Enter your choice: ")) {
                case 1 -> registerDoctor();
                case 2 -> doctorView.displayDoctors(doctorService.getAllDoctors());
                case 3 -> doctorView.displayDoctor(doctorService.getDoctorById(readInt("Enter Doctor/Staff ID: ")));
                case 4 -> updateDoctor();
                case 5 -> {
                    int id = readInt("Enter Doctor/Staff ID to delete: ");
                    if (doctorService.deleteDoctor(id)) {
                        doctorView.displayDoctorDeleted();
                    } else {
                        System.out.println("Failed to delete doctor.");
                    }
                }
                case 0 -> { return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void registerDoctor() {

        System.out.println();
        System.out.println("========== REGISTER DOCTOR ==========");

        System.out.print("First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();

        char gender = readChar("Gender (M/F): ");
        LocalDate dateOfBirth = readDate("Date of Birth (yyyy-MM-dd): ");

        System.out.print("Phone: ");
        String phone = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Street: ");
        String street = scanner.nextLine();

        System.out.print("City: ");
        String city = scanner.nextLine();

        System.out.print("Country: ");
        String country = scanner.nextLine();

        LocalDate employmentDate = readDate("Employment Date (yyyy-MM-dd): ");
        double salary = readDouble("Salary: ");
        Department department = selectDepartment();

        System.out.print("Specialization: ");
        String specialization = scanner.nextLine();

        System.out.print("License Number: ");
        String licenseNumber = scanner.nextLine();

        Doctor doctor = new Doctor(firstName, lastName, gender, dateOfBirth, phone, email, street, city, country,
                0, employmentDate, salary, department, specialization, licenseNumber);

        if (doctorService.registerDoctor(doctor)) {
            doctorView.displayDoctorRegistered();
        } else {
            System.out.println("Failed to register doctor.");
        }
    }

    private static void updateDoctor() {

        int id = readInt("Enter Doctor/Staff ID to update: ");
        Doctor doctor = doctorService.getDoctorById(id);

        if (doctor == null) {
            System.out.println("Doctor not found.");
            return;
        }

        System.out.println("Leave blank to keep the current value.");

        System.out.print("Phone [" + doctor.getPhone() + "]: ");
        String phone = scanner.nextLine();
        if (!phone.isBlank()) doctor.setPhone(phone);

        System.out.print("Email [" + doctor.getEmail() + "]: ");
        String email = scanner.nextLine();
        if (!email.isBlank()) doctor.setEmail(email);

        System.out.print("Specialization [" + doctor.getSpecialization() + "]: ");
        String specialization = scanner.nextLine();
        if (!specialization.isBlank()) doctor.setSpecialization(specialization);

        System.out.print("License Number [" + doctor.getLicenseNumber() + "]: ");
        String licenseNumber = scanner.nextLine();
        if (!licenseNumber.isBlank()) doctor.setLicenseNumber(licenseNumber);

        if (doctorService.updateDoctor(doctor)) {
            doctorView.displayDoctorUpdated();
        } else {
            System.out.println("Failed to update doctor.");
        }
    }

    // ---- Nurse ----

    private static void nurseMenu() {

        while (true) {

            System.out.println();
            System.out.println("========== NURSE MANAGEMENT ==========");
            System.out.println("1. Register Nurse");
            System.out.println("2. View All Nurses");
            System.out.println("3. Find Nurse");
            System.out.println("4. Update Nurse");
            System.out.println("5. Delete Nurse");
            System.out.println("0. Back");

            switch (readInt("Enter your choice: ")) {
                case 1 -> registerNurse();
                case 2 -> nurseView.displayNurses(nurseService.getAllNurses());
                case 3 -> nurseView.displayNurse(nurseService.getNurseById(readInt("Enter Nurse/Staff ID: ")));
                case 4 -> updateNurse();
                case 5 -> {
                    int id = readInt("Enter Nurse/Staff ID to delete: ");
                    if (nurseService.deleteNurse(id)) {
                        nurseView.displayNurseDeleted();
                    } else {
                        System.out.println("Failed to delete nurse.");
                    }
                }
                case 0 -> { return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void registerNurse() {

        System.out.println();
        System.out.println("========== REGISTER NURSE ==========");

        System.out.print("First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();

        char gender = readChar("Gender (M/F): ");
        LocalDate dateOfBirth = readDate("Date of Birth (yyyy-MM-dd): ");

        System.out.print("Phone: ");
        String phone = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Street: ");
        String street = scanner.nextLine();

        System.out.print("City: ");
        String city = scanner.nextLine();

        System.out.print("Country: ");
        String country = scanner.nextLine();

        LocalDate employmentDate = readDate("Employment Date (yyyy-MM-dd): ");
        double salary = readDouble("Salary: ");
        Department department = selectDepartment();

        System.out.print("Nursing License: ");
        String nursingLicense = scanner.nextLine();

        System.out.print("Qualification: ");
        String qualification = scanner.nextLine();

        Nurse nurse = new Nurse(firstName, lastName, gender, dateOfBirth, phone, email, street, city, country,
                0, employmentDate, salary, department, nursingLicense, qualification);

        if (nurseService.registerNurse(nurse)) {
            nurseView.displayNurseRegistered();
        } else {
            System.out.println("Failed to register nurse.");
        }
    }

    private static void updateNurse() {

        int id = readInt("Enter Nurse/Staff ID to update: ");
        Nurse nurse = nurseService.getNurseById(id);

        if (nurse == null) {
            System.out.println("Nurse not found.");
            return;
        }

        System.out.println("Leave blank to keep the current value.");

        System.out.print("Phone [" + nurse.getPhone() + "]: ");
        String phone = scanner.nextLine();
        if (!phone.isBlank()) nurse.setPhone(phone);

        System.out.print("Email [" + nurse.getEmail() + "]: ");
        String email = scanner.nextLine();
        if (!email.isBlank()) nurse.setEmail(email);

        System.out.print("Qualification [" + nurse.getQualification() + "]: ");
        String qualification = scanner.nextLine();
        if (!qualification.isBlank()) nurse.setQualification(qualification);

        System.out.print("Nursing License [" + nurse.getNursingLicense() + "]: ");
        String nursingLicense = scanner.nextLine();
        if (!nursingLicense.isBlank()) nurse.setNursingLicense(nursingLicense);

        if (nurseService.updateNurse(nurse)) {
            nurseView.displayNurseUpdated();
        } else {
            System.out.println("Failed to update nurse.");
        }
    }

    // ---- Pharmacist ----

    private static void pharmacistMenu() {

        while (true) {

            System.out.println();
            System.out.println("========== PHARMACIST MANAGEMENT ==========");
            System.out.println("1. Register Pharmacist");
            System.out.println("2. View All Pharmacists");
            System.out.println("3. Find Pharmacist");
            System.out.println("4. Delete Pharmacist");
            System.out.println("0. Back");

            switch (readInt("Enter your choice: ")) {
                case 1 -> registerPharmacist();
                case 2 -> pharmacistView.displayPharmacists(pharmacistService.getAllPharmacists());
                case 3 -> pharmacistView.displayPharmacist(pharmacistService.getPharmacistById(readInt("Enter Pharmacist/Staff ID: ")));
                case 4 -> {
                    int id = readInt("Enter Pharmacist/Staff ID to delete: ");
                    if (pharmacistService.deletePharmacist(id)) {
                        pharmacistView.displayPharmacistDeleted();
                    } else {
                        System.out.println("Failed to delete pharmacist.");
                    }
                }
                case 0 -> { return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void registerPharmacist() {

        System.out.println();
        System.out.println("========== REGISTER PHARMACIST ==========");

        System.out.print("First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();

        char gender = readChar("Gender (M/F): ");
        LocalDate dateOfBirth = readDate("Date of Birth (yyyy-MM-dd): ");

        System.out.print("Phone: ");
        String phone = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Street: ");
        String street = scanner.nextLine();

        System.out.print("City: ");
        String city = scanner.nextLine();

        System.out.print("Country: ");
        String country = scanner.nextLine();

        LocalDate employmentDate = readDate("Employment Date (yyyy-MM-dd): ");
        double salary = readDouble("Salary: ");
        Department department = selectDepartment();

        System.out.print("Qualification: ");
        String qualification = scanner.nextLine();

        System.out.print("License Number: ");
        String licenseNumber = scanner.nextLine();

        Pharmacist pharmacist = new Pharmacist(firstName, lastName, gender, dateOfBirth, phone, email, street, city,
                country, 0, employmentDate, salary, department, qualification, licenseNumber);

        if (pharmacistService.registerPharmacist(pharmacist)) {
            pharmacistView.displayPharmacistRegistered();
        } else {
            System.out.println("Failed to register pharmacist.");
        }
    }

    // ---- Laboratory Technician ----

    private static void laboratoryTechnicianMenu() {

        while (true) {

            System.out.println();
            System.out.println("========== LABORATORY TECHNICIAN MANAGEMENT ==========");
            System.out.println("1. Register Laboratory Technician");
            System.out.println("2. View All Laboratory Technicians");
            System.out.println("3. Find Laboratory Technician");
            System.out.println("4. Delete Laboratory Technician");
            System.out.println("0. Back");

            switch (readInt("Enter your choice: ")) {
                case 1 -> registerLaboratoryTechnician();
                case 2 -> laboratoryTechnicianView.displayTechnicians(laboratoryTechnicianService.getAllLaboratoryTechnicians());
                case 3 -> laboratoryTechnicianView.displayTechnician(laboratoryTechnicianService.getLaboratoryTechnicianById(readInt("Enter Technician/Staff ID: ")));
                case 4 -> {
                    int id = readInt("Enter Technician/Staff ID to delete: ");
                    if (laboratoryTechnicianService.deleteLaboratoryTechnician(id)) {
                        laboratoryTechnicianView.displayTechnicianDeleted();
                    } else {
                        System.out.println("Failed to delete laboratory technician.");
                    }
                }
                case 0 -> { return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void registerLaboratoryTechnician() {

        System.out.println();
        System.out.println("========== REGISTER LABORATORY TECHNICIAN ==========");

        System.out.print("First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();

        char gender = readChar("Gender (M/F): ");
        LocalDate dateOfBirth = readDate("Date of Birth (yyyy-MM-dd): ");

        System.out.print("Phone: ");
        String phone = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Street: ");
        String street = scanner.nextLine();

        System.out.print("City: ");
        String city = scanner.nextLine();

        System.out.print("Country: ");
        String country = scanner.nextLine();

        LocalDate employmentDate = readDate("Employment Date (yyyy-MM-dd): ");
        double salary = readDouble("Salary: ");
        Department department = selectDepartment();

        System.out.print("Qualification: ");
        String qualification = scanner.nextLine();

        System.out.print("License Number: ");
        String licenseNumber = scanner.nextLine();

        LaboratoryTechnician technician = new LaboratoryTechnician(firstName, lastName, gender, dateOfBirth, phone,
                email, street, city, country, 0, employmentDate, salary, department, qualification, licenseNumber);

        if (laboratoryTechnicianService.registerLaboratoryTechnician(technician)) {
            laboratoryTechnicianView.displayTechnicianRegistered();
        } else {
            System.out.println("Failed to register laboratory technician.");
        }
    }

    // ---- Cross-staff views ----

    private static void viewAllStaff() {
        System.out.println();
        System.out.println("---- Doctors ----");
        doctorView.displayDoctors(doctorService.getAllDoctors());
        System.out.println("---- Nurses ----");
        nurseView.displayNurses(nurseService.getAllNurses());
        System.out.println("---- Pharmacists ----");
        pharmacistView.displayPharmacists(pharmacistService.getAllPharmacists());
        System.out.println("---- Laboratory Technicians ----");
        laboratoryTechnicianView.displayTechnicians(laboratoryTechnicianService.getAllLaboratoryTechnicians());
    }

    private static void findStaff() {

        int id = readInt("Enter Staff ID: ");

        Doctor doctor = doctorService.getDoctorById(id);
        if (doctor != null) {
            doctorView.displayDoctor(doctor);
            return;
        }

        Nurse nurse = nurseService.getNurseById(id);
        if (nurse != null) {
            nurseView.displayNurse(nurse);
            return;
        }

        Pharmacist pharmacist = pharmacistService.getPharmacistById(id);
        if (pharmacist != null) {
            pharmacistView.displayPharmacist(pharmacist);
            return;
        }

        LaboratoryTechnician technician = laboratoryTechnicianService.getLaboratoryTechnicianById(id);
        if (technician != null) {
            laboratoryTechnicianView.displayTechnician(technician);
            return;
        }

        System.out.println("No staff member found with that ID.");
    }

    private static void viewStaffByDepartment() {

        int departmentId = readInt("Enter Department ID: ");

        List<Doctor> doctors = doctorService.getAllDoctors().stream()
                .filter(d -> d.getDepartment() != null && d.getDepartment().getId() == departmentId).toList();
        List<Nurse> nurses = nurseService.getAllNurses().stream()
                .filter(n -> n.getDepartment() != null && n.getDepartment().getId() == departmentId).toList();

        System.out.println();
        System.out.println("---- Doctors ----");
        doctorView.displayDoctors(doctors);
        System.out.println("---- Nurses ----");
        nurseView.displayNurses(nurses);
    }

    // ---- Helpers reused across staff sub-menus ----

    private static Department selectDepartment() {

        List<Department> departments = departmentService.getAllDepartments();
        departmentView.displayDepartments(departments);

        int id = readInt("Enter Department ID: ");
        Department department = departmentService.getDepartmentById(id);

        if (department == null) {
            System.out.println("Department not found; leaving unassigned.");
        }

        return department;
    }

    // =========================================================
    // APPOINTMENT MANAGEMENT
    // =========================================================

    private static void appointmentMenu() {

        while (true) {

            System.out.println();
            System.out.println("================================================================");
            System.out.println("                   APPOINTMENT MANAGEMENT");
            System.out.println("================================================================");
            System.out.println("1.  Create Appointment");
            System.out.println("2.  View All Appointments");
            System.out.println("3.  Find Appointment");
            System.out.println("4.  Update Appointment");
            System.out.println("5.  Cancel Appointment");
            System.out.println("6.  Delete Appointment");
            System.out.println("7.  View Patient Appointments");
            System.out.println("8.  View Doctor Appointments");
            System.out.println("9.  Today's Appointments");
            System.out.println("10. Upcoming Appointments");
            System.out.println("0.  Back");
            System.out.println("================================================================");

            switch (readInt("Enter your choice: ")) {
                case 1 -> createAppointment();
                case 2 -> appointmentView.displayAppointments(appointmentService.getAllAppointments());
                case 3 -> appointmentView.displayAppointment(appointmentService.getAppointmentById(readInt("Enter Appointment ID: ")));
                case 4 -> updateAppointment();
                case 5 -> cancelAppointment();
                case 6 -> deleteAppointment();
                case 7 -> appointmentView.displayAppointments(appointmentService.getAppointmentsByPatient(readInt("Enter Patient ID: ")));
                case 8 -> appointmentView.displayAppointments(appointmentService.getAppointmentsByDoctor(readInt("Enter Doctor/Staff ID: ")));
                case 9 -> viewTodaysAppointments();
                case 10 -> viewUpcomingAppointments();
                case 0 -> { return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void createAppointment() {

        System.out.println();
        System.out.println("========== CREATE APPOINTMENT ==========");

        int patientId = readInt("Enter Patient ID: ");
        Patient patient = patientService.getPatientById(patientId);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        int doctorId = readInt("Enter Doctor/Staff ID: ");
        Doctor doctor = doctorService.getDoctorById(doctorId);
        if (doctor == null) {
            System.out.println("Doctor not found.");
            return;
        }

        LocalDateTime appointmentDate = readDateTime("Appointment Date (yyyy-MM-dd HH:mm): ");
        if (appointmentDate == null) {
            return;
        }

        System.out.print("Reason for Appointment: ");
        String reason = scanner.nextLine();

        System.out.print("Notes: ");
        String notes = scanner.nextLine();

        Appointment appointment = new Appointment();
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setAppointmentDate(appointmentDate);
        appointment.setReason(reason);
        appointment.setStatus("SCHEDULED");
        appointment.setNotes(notes);

        if (appointmentService.addAppointment(appointment)) {
            appointmentView.displayAppointmentCreated();
        } else {
            System.out.println("Failed to create appointment.");
        }
    }

    private static void updateAppointment() {

        int id = readInt("Enter Appointment ID to update: ");
        Appointment appointment = appointmentService.getAppointmentById(id);

        if (appointment == null) {
            System.out.println("Appointment not found.");
            return;
        }

        System.out.println("Leave blank to keep the current value.");

        System.out.print("Reason [" + appointment.getReason() + "]: ");
        String reason = scanner.nextLine();
        if (!reason.isBlank()) appointment.setReason(reason);

        System.out.print("Notes [" + appointment.getNotes() + "]: ");
        String notes = scanner.nextLine();
        if (!notes.isBlank()) appointment.setNotes(notes);

        System.out.print("Status [" + appointment.getStatus() + "] (SCHEDULED/COMPLETED/CANCELLED): ");
        String status = scanner.nextLine();
        if (!status.isBlank()) appointment.setStatus(status.toUpperCase());

        if (appointmentService.updateAppointment(appointment)) {
            appointmentView.displayAppointmentUpdated();
        } else {
            System.out.println("Failed to update appointment.");
        }
    }

    private static void cancelAppointment() {

        int id = readInt("Enter Appointment ID to cancel: ");
        Appointment appointment = appointmentService.getAppointmentById(id);

        if (appointment == null) {
            System.out.println("Appointment not found.");
            return;
        }

        appointment.setStatus("CANCELLED");

        if (appointmentService.updateAppointment(appointment)) {
            System.out.println("Appointment cancelled.");
        } else {
            System.out.println("Failed to cancel appointment.");
        }
    }

    private static void deleteAppointment() {

        int id = readInt("Enter Appointment ID to delete: ");
        System.out.print("Are you sure? (Y/N): ");
        String confirm = scanner.nextLine();

        if (!confirm.equalsIgnoreCase("Y")) {
            System.out.println("Cancelled.");
            return;
        }

        if (appointmentService.deleteAppointment(id)) {
            appointmentView.displayAppointmentDeleted();
        } else {
            System.out.println("Failed to delete appointment.");
        }
    }

    private static void viewTodaysAppointments() {
        LocalDate today = LocalDate.now();
        List<Appointment> todays = appointmentService.getAllAppointments().stream()
                .filter(a -> a.getAppointmentDate() != null && a.getAppointmentDate().toLocalDate().equals(today))
                .toList();
        appointmentView.displayAppointments(todays);
    }

    private static void viewUpcomingAppointments() {
        LocalDateTime now = LocalDateTime.now();
        List<Appointment> upcoming = appointmentService.getAllAppointments().stream()
                .filter(a -> a.getAppointmentDate() != null && a.getAppointmentDate().isAfter(now))
                .toList();
        appointmentView.displayAppointments(upcoming);
    }

    // =========================================================
    // ADMISSION & BED MANAGEMENT
    // =========================================================

    private static void admissionBedMenu() {

        while (true) {

            System.out.println();
            System.out.println("================================================================");
            System.out.println("                ADMISSION & BED MANAGEMENT");
            System.out.println("================================================================");
            System.out.println("1.  Admit Patient");
            System.out.println("2.  View All Admissions");
            System.out.println("3.  Find Admission");
            System.out.println("4.  Update Admission");
            System.out.println("5.  Discharge Patient");
            System.out.println("6.  View Active Admissions");
            System.out.println("7.  Ward Management");
            System.out.println("8.  Room Management");
            System.out.println("9.  Bed Management");
            System.out.println("10. View Available Beds");
            System.out.println("11. View Occupied Beds");
            System.out.println("12. Nurse Assignment");
            System.out.println("0.  Back");
            System.out.println("================================================================");

            switch (readInt("Enter your choice: ")) {
                case 1 -> admitPatient();
                case 2 -> admissionView.displayAdmissions(admissionService.getAllAdmissions());
                case 3 -> findAdmission();
                case 4 -> updateAdmission();
                case 5 -> dischargePatient();
                case 6 -> admissionView.displayAdmissions(admissionService.getActiveAdmissions());
                case 7 -> wardMenu();
                case 8 -> roomMenu();
                case 9 -> bedMenu();
                case 10 -> bedView.displayBeds(bedService.getAvailableBeds());
                case 11 -> bedView.displayBeds(bedService.getOccupiedBeds());
                case 12 -> assignNurseToPatient();
                case 0 -> { return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void admitPatient() {

        System.out.println();
        System.out.println("========== ADMIT PATIENT ==========");

        int patientId = readInt("Enter Patient ID: ");
        Patient patient = patientService.getPatientById(patientId);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        bedView.displayBeds(bedService.getAvailableBeds());
        int bedId = readInt("Enter Bed ID: ");
        Bed bed = bedService.getBedById(bedId);
        if (bed == null) {
            System.out.println("Bed not found.");
            return;
        }

        int doctorId = readInt("Enter Attending Doctor/Staff ID: ");
        Doctor doctor = doctorService.getDoctorById(doctorId);

        System.out.print("Reason for Admission: ");
        String reason = scanner.nextLine();

        Admission admission = new Admission();
        admission.setPatient(patient);
        admission.setBed(bed);
        admission.setAttendingDoctor(doctor);
        admission.setReason(reason);

        if (admissionService.admitPatient(admission)) {
            admissionView.displayAdmissionCreated();
        } else {
            System.out.println("Failed to admit patient.");
        }
    }

    private static void findAdmission() {
        int id = readInt("Enter Admission ID: ");
        Admission admission = admissionService.getAdmissionById(id);
        if (admission == null) {
            System.out.println("Admission not found.");
            return;
        }
        admissionView.displayAdmissions(List.of(admission));
    }

    private static void updateAdmission() {

        int id = readInt("Enter Admission ID to update: ");
        Admission admission = admissionService.getAdmissionById(id);

        if (admission == null) {
            System.out.println("Admission not found.");
            return;
        }

        System.out.print("Reason [" + admission.getReason() + "]: ");
        String reason = scanner.nextLine();
        if (!reason.isBlank()) admission.setReason(reason);

        if (admissionService.updateAdmission(admission)) {
            System.out.println("Admission updated successfully.");
        } else {
            System.out.println("Failed to update admission.");
        }
    }

    private static void dischargePatient() {
        int id = readInt("Enter Admission ID to discharge: ");
        if (admissionService.dischargePatient(id)) {
            admissionView.displayPatientDischarged();
        } else {
            System.out.println("Failed to discharge patient.");
        }
    }

    private static void assignNurseToPatient() {

        System.out.println();
        System.out.println("========== NURSE ASSIGNMENT ==========");

        int patientId = readInt("Enter Patient ID: ");
        Patient patient = patientService.getPatientById(patientId);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        int nurseId = readInt("Enter Nurse/Staff ID: ");
        Nurse nurse = nurseService.getNurseById(nurseId);
        if (nurse == null) {
            System.out.println("Nurse not found.");
            return;
        }

        int admissionId = readInt("Enter Admission ID (0 if none): ");
        Admission admission = admissionId > 0 ? admissionService.getAdmissionById(admissionId) : null;

        System.out.print("Shift (DAY/NIGHT): ");
        String shift = scanner.nextLine();

        NurseAssignment assignment = new NurseAssignment();
        assignment.setPatient(patient);
        assignment.setNurse(nurse);
        assignment.setAdmission(admission);
        assignment.setShift(shift);

        if (nurseAssignmentService.assignNurse(assignment)) {
            nurseAssignmentView.displayNurseAssigned();
        } else {
            System.out.println("Failed to assign nurse.");
        }
    }

    // ---- Ward ----

    private static void wardMenu() {

        while (true) {

            System.out.println();
            System.out.println("========== WARD MANAGEMENT ==========");
            System.out.println("1. Add Ward");
            System.out.println("2. View All Wards");
            System.out.println("0. Back");

            switch (readInt("Enter your choice: ")) {
                case 1 -> addWard();
                case 2 -> wardView.displayWards(wardService.getAllWards());
                case 0 -> { return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void addWard() {

        System.out.print("Ward Name: ");
        String name = scanner.nextLine();

        System.out.print("Ward Type: ");
        String type = scanner.nextLine();

        int capacity = readInt("Capacity: ");

        Ward ward = new Ward();
        ward.setName(name);
        ward.setWardType(type);
        ward.setCapacity(capacity);

        if (wardService.addWard(ward)) {
            wardView.displayWardAdded();
        } else {
            System.out.println("Failed to add ward.");
        }
    }

    // ---- Room ----

    private static void roomMenu() {

        while (true) {

            System.out.println();
            System.out.println("========== ROOM MANAGEMENT ==========");
            System.out.println("1. Add Room");
            System.out.println("2. View All Rooms");
            System.out.println("0. Back");

            switch (readInt("Enter your choice: ")) {
                case 1 -> addRoom();
                case 2 -> roomView.displayRooms(roomService.getAllRooms());
                case 0 -> { return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void addRoom() {

        wardView.displayWards(wardService.getAllWards());
        int wardId = readInt("Enter Ward ID: ");
        Ward ward = wardService.getWardById(wardId);
        if (ward == null) {
            System.out.println("Ward not found.");
            return;
        }

        System.out.print("Room Number: ");
        String roomNumber = scanner.nextLine();

        System.out.print("Room Type: ");
        String type = scanner.nextLine();

        int capacity = readInt("Capacity: ");

        Room room = new Room();
        room.setRoomNumber(roomNumber);
        room.setWard(ward);
        room.setRoomType(type);
        room.setCapacity(capacity);

        if (roomService.addRoom(room)) {
            roomView.displayRoomAdded();
        } else {
            System.out.println("Failed to add room.");
        }
    }

    // ---- Bed ----

    private static void bedMenu() {

        while (true) {

            System.out.println();
            System.out.println("========== BED MANAGEMENT ==========");
            System.out.println("1. Add Bed");
            System.out.println("2. View All Beds");
            System.out.println("0. Back");

            switch (readInt("Enter your choice: ")) {
                case 1 -> addBed();
                case 2 -> bedView.displayBeds(bedService.getAllBeds());
                case 0 -> { return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void addBed() {

        roomView.displayRooms(roomService.getAllRooms());
        int roomId = readInt("Enter Room ID: ");
        Room room = roomService.getRoomById(roomId);
        if (room == null) {
            System.out.println("Room not found.");
            return;
        }

        System.out.print("Bed Number: ");
        String bedNumber = scanner.nextLine();

        Bed bed = new Bed();
        bed.setBedNumber(bedNumber);
        bed.setRoom(room);
        bed.setStatus("AVAILABLE");

        if (bedService.addBed(bed)) {
            bedView.displayBedAdded();
        } else {
            System.out.println("Failed to add bed.");
        }
    }

    // =========================================================
    // CLINICAL MANAGEMENT
    // =========================================================

    private static void clinicalMenu() {

        while (true) {

            System.out.println();
            System.out.println("================================================================");
            System.out.println("                     CLINICAL MANAGEMENT");
            System.out.println("================================================================");
            System.out.println("1. Diagnosis Management");
            System.out.println("2. Treatment Management");
            System.out.println("3. Medical Records");
            System.out.println("4. Nurse Assignment");
            System.out.println("5. Patient Medical History");
            System.out.println("0. Back");
            System.out.println("================================================================");

            switch (readInt("Enter your choice: ")) {
                case 1 -> diagnosisMenu();
                case 2 -> treatmentMenu();
                case 3 -> medicalRecordMenu();
                case 4 -> assignNurseToPatient();
                case 5 -> viewPatientMedicalHistory();
                case 0 -> { return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void diagnosisMenu() {

        while (true) {

            System.out.println();
            System.out.println("========== DIAGNOSIS MANAGEMENT ==========");
            System.out.println("1. Add Diagnosis");
            System.out.println("2. View All Diagnoses");
            System.out.println("3. View Diagnoses by Patient");
            System.out.println("0. Back");

            switch (readInt("Enter your choice: ")) {
                case 1 -> addDiagnosis();
                case 2 -> diagnosisView.displayDiagnoses(diagnosisService.getAllDiagnoses());
                case 3 -> diagnosisView.displayDiagnoses(diagnosisService.getDiagnosesByPatient(readInt("Enter Patient ID: ")));
                case 0 -> { return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void addDiagnosis() {

        int patientId = readInt("Enter Patient ID: ");
        Patient patient = patientService.getPatientById(patientId);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        int doctorId = readInt("Enter Doctor/Staff ID: ");
        Doctor doctor = doctorService.getDoctorById(doctorId);
        if (doctor == null) {
            System.out.println("Doctor not found.");
            return;
        }

        System.out.print("Diagnosis Name: ");
        String name = scanner.nextLine();

        System.out.print("Description: ");
        String description = scanner.nextLine();

        Diagnosis diagnosis = new Diagnosis();
        diagnosis.setPatient(patient);
        diagnosis.setDoctor(doctor);
        diagnosis.setDiagnosisName(name);
        diagnosis.setDescription(description);
        diagnosis.setDiagnosisDate(LocalDate.now());

        if (diagnosisService.addDiagnosis(diagnosis)) {
            diagnosisView.displayDiagnosisAdded();
        } else {
            System.out.println("Failed to add diagnosis.");
        }
    }

    private static void treatmentMenu() {

        while (true) {

            System.out.println();
            System.out.println("========== TREATMENT MANAGEMENT ==========");
            System.out.println("1. Add Treatment");
            System.out.println("2. View All Treatments");
            System.out.println("3. View Treatments by Patient");
            System.out.println("0. Back");

            switch (readInt("Enter your choice: ")) {
                case 1 -> addTreatment();
                case 2 -> treatmentView.displayTreatments(treatmentService.getAllTreatments());
                case 3 -> treatmentView.displayTreatments(treatmentService.getTreatmentsByPatient(readInt("Enter Patient ID: ")));
                case 0 -> { return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void addTreatment() {

        int patientId = readInt("Enter Patient ID: ");
        Patient patient = patientService.getPatientById(patientId);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        int doctorId = readInt("Enter Doctor/Staff ID: ");
        Doctor doctor = doctorService.getDoctorById(doctorId);
        if (doctor == null) {
            System.out.println("Doctor not found.");
            return;
        }

        List<Diagnosis> diagnoses = diagnosisService.getDiagnosesByPatient(patientId);
        diagnosisView.displayDiagnoses(diagnoses);
        int diagnosisId = readInt("Enter Diagnosis ID related to this treatment (0 if none): ");
        Diagnosis diagnosis = diagnoses.stream().filter(d -> d.getId() == diagnosisId).findFirst().orElse(null);

        System.out.print("Treatment Name: ");
        String name = scanner.nextLine();

        System.out.print("Description: ");
        String description = scanner.nextLine();

        Treatment treatment = new Treatment();
        treatment.setPatient(patient);
        treatment.setDoctor(doctor);
        treatment.setDiagnosis(diagnosis);
        treatment.setTreatmentName(name);
        treatment.setDescription(description);
        treatment.setTreatmentDate(LocalDate.now());

        if (treatmentService.addTreatment(treatment)) {
            treatmentView.displayTreatmentAdded();
        } else {
            System.out.println("Failed to add treatment.");
        }
    }

    private static void medicalRecordMenu() {

        while (true) {

            System.out.println();
            System.out.println("========== MEDICAL RECORDS ==========");
            System.out.println("1. Create Medical Record");
            System.out.println("2. View All Medical Records");
            System.out.println("3. View Medical Records by Patient");
            System.out.println("0. Back");

            switch (readInt("Enter your choice: ")) {
                case 1 -> createMedicalRecord();
                case 2 -> medicalRecordView.displayRecords(medicalRecordService.getAllMedicalRecords());
                case 3 -> medicalRecordView.displayRecords(medicalRecordService.getMedicalRecordsByPatient(readInt("Enter Patient ID: ")));
                case 0 -> { return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void createMedicalRecord() {

        int patientId = readInt("Enter Patient ID: ");
        Patient patient = patientService.getPatientById(patientId);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        MedicalRecord record = new MedicalRecord();
        record.setPatient(patient);
        record.setCreatedDate(LocalDate.now());

        if (medicalRecordService.createMedicalRecord(record)) {
            medicalRecordView.displayRecordCreated();
        } else {
            System.out.println("Failed to create medical record.");
        }
    }

    // =========================================================
    // LABORATORY SERVICES
    // =========================================================

    private static void laboratoryMenu() {

        while (true) {

            System.out.println();
            System.out.println("================================================================");
            System.out.println("                     LABORATORY SERVICES");
            System.out.println("================================================================");
            System.out.println("1. Create Laboratory Test");
            System.out.println("2. View All Laboratory Tests");
            System.out.println("3. Find Laboratory Test");
            System.out.println("4. Update Laboratory Test");
            System.out.println("5. Delete Laboratory Test");
            System.out.println("6. View Patient Tests");
            System.out.println("7. View Pending Tests");
            System.out.println("8. View Completed Tests");
            System.out.println("9. Record Test Result");
            System.out.println("0. Back");
            System.out.println("================================================================");

            switch (readInt("Enter your choice: ")) {
                case 1 -> createLaboratoryTest();
                case 2 -> laboratoryTestView.displayTests(laboratoryTestService.getAllTests());
                case 3 -> laboratoryTestView.displayTest(laboratoryTestService.getTestById(readInt("Enter Test ID: ")));
                case 4 -> updateLaboratoryTest();
                case 5 -> deleteLaboratoryTest();
                case 6 -> laboratoryTestView.displayTests(laboratoryTestService.getTestsByPatient(readInt("Enter Patient ID: ")));
                case 7 -> laboratoryTestView.displayTests(laboratoryTestService.getPendingTests());
                case 8 -> laboratoryTestView.displayTests(laboratoryTestService.getCompletedTests());
                case 9 -> recordTestResult();
                case 0 -> { return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void createLaboratoryTest() {

        int patientId = readInt("Enter Patient ID: ");
        Patient patient = patientService.getPatientById(patientId);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        int technicianId = readInt("Enter Laboratory Technician/Staff ID: ");
        LaboratoryTechnician technician = laboratoryTechnicianService.getLaboratoryTechnicianById(technicianId);

        System.out.print("Test Name: ");
        String testName = scanner.nextLine();

        LaboratoryTest test = new LaboratoryTest();
        test.setPatient(patient);
        test.setTechnician(technician);
        test.setTestName(testName);
        test.setTestDate(LocalDateTime.now());

        if (laboratoryTestService.createTest(test)) {
            laboratoryTestView.displayTestCreated();
        } else {
            System.out.println("Failed to create laboratory test.");
        }
    }

    private static void updateLaboratoryTest() {

        int id = readInt("Enter Test ID to update: ");
        LaboratoryTest test = laboratoryTestService.getTestById(id);

        if (test == null) {
            System.out.println("Test not found.");
            return;
        }

        System.out.print("Test Name [" + test.getTestName() + "]: ");
        String name = scanner.nextLine();
        if (!name.isBlank()) test.setTestName(name);

        System.out.println("Test updated successfully.");
    }

    private static void deleteLaboratoryTest() {
        int id = readInt("Enter Test ID to delete: ");
        LaboratoryTest test = laboratoryTestService.getTestById(id);
        if (test == null) {
            System.out.println("Test not found.");
            return;
        }
        System.out.println("Note: laboratory tests remain in patient history and are not hard-deleted.");
    }

    private static void recordTestResult() {

        int id = readInt("Enter Test ID: ");

        System.out.print("Result: ");
        String result = scanner.nextLine();

        System.out.print("Reference Range: ");
        String referenceRange = scanner.nextLine();

        if (laboratoryTestService.recordResult(id, result, referenceRange)) {
            laboratoryTestView.displayResultRecorded();
        } else {
            System.out.println("Failed to record test result.");
        }
    }

    // =========================================================
    // PHARMACY SERVICES
    // =========================================================

    private static void pharmacyMenu() {

        while (true) {

            System.out.println();
            System.out.println("================================================================");
            System.out.println("                      PHARMACY SERVICES");
            System.out.println("================================================================");
            System.out.println("1. Medication Management");
            System.out.println("2. Prescription Management");
            System.out.println("3. Dispense Medication");
            System.out.println("4. View Dispensing Records");
            System.out.println("5. View Patient Prescriptions");
            System.out.println("6. View Available Medications");
            System.out.println("7. View Low Stock Medications");
            System.out.println("8. Update Medication Stock");
            System.out.println("0. Back");
            System.out.println("================================================================");

            switch (readInt("Enter your choice: ")) {
                case 1 -> medicationMenu();
                case 2 -> prescriptionMenu();
                case 3 -> dispenseMedication();
                case 4 -> medicationDispensingView.displayRecords(medicationDispensingService.getAllDispensingRecords());
                case 5 -> prescriptionView.displayPrescriptions(prescriptionService.getPrescriptionsByPatient(readInt("Enter Patient ID: ")));
                case 6 -> medicationView.displayMedications(medicationService.getAvailableMedications());
                case 7 -> medicationView.displayMedications(medicationService.getLowStockMedications());
                case 8 -> updateMedicationStock();
                case 0 -> { return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void medicationMenu() {

        while (true) {

            System.out.println();
            System.out.println("========== MEDICATION MANAGEMENT ==========");
            System.out.println("1. Add Medication");
            System.out.println("2. View All Medications");
            System.out.println("0. Back");

            switch (readInt("Enter your choice: ")) {
                case 1 -> addMedication();
                case 2 -> medicationView.displayMedications(medicationService.getAllMedications());
                case 0 -> { return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void addMedication() {

        System.out.print("Medication Name: ");
        String name = scanner.nextLine();

        System.out.print("Description: ");
        String description = scanner.nextLine();

        System.out.print("Dosage Form (Tablet/Capsule/Syrup...): ");
        String dosageForm = scanner.nextLine();

        double price = readDouble("Price: ");
        int stock = readInt("Quantity in Stock: ");

        Medication medication = new Medication();
        medication.setName(name);
        medication.setDescription(description);
        medication.setDosageForm(dosageForm);
        medication.setPrice(price);
        medication.setQuantityInStock(stock);

        if (medicationService.addMedication(medication)) {
            medicationView.displayMedicationAdded();
        } else {
            System.out.println("Failed to add medication.");
        }
    }

    private static void updateMedicationStock() {
        int id = readInt("Enter Medication ID: ");
        int quantity = readInt("New Stock Quantity: ");
        if (medicationService.updateStock(id, quantity)) {
            medicationView.displayStockUpdated();
        } else {
            System.out.println("Failed to update stock.");
        }
    }

    private static void prescriptionMenu() {

        while (true) {

            System.out.println();
            System.out.println("========== PRESCRIPTION MANAGEMENT ==========");
            System.out.println("1. Create Prescription");
            System.out.println("2. Add Prescription Item");
            System.out.println("3. View All Prescriptions");
            System.out.println("0. Back");

            switch (readInt("Enter your choice: ")) {
                case 1 -> createPrescription();
                case 2 -> addPrescriptionItem();
                case 3 -> prescriptionView.displayPrescriptions(prescriptionService.getAllPrescriptions());
                case 0 -> { return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void createPrescription() {

        int patientId = readInt("Enter Patient ID: ");
        Patient patient = patientService.getPatientById(patientId);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        int doctorId = readInt("Enter Doctor/Staff ID: ");
        Doctor doctor = doctorService.getDoctorById(doctorId);

        Prescription prescription = new Prescription();
        prescription.setPatient(patient);
        prescription.setDoctor(doctor);
        prescription.setPrescriptionDate(LocalDate.now());

        if (prescriptionService.createPrescription(prescription)) {
            prescriptionView.displayPrescriptionCreated();
            System.out.println("Prescription ID: " + prescription.getId());
        } else {
            System.out.println("Failed to create prescription.");
        }
    }

    private static void addPrescriptionItem() {

        List<Prescription> all = prescriptionService.getAllPrescriptions();
        prescriptionView.displayPrescriptions(all);

        int prescriptionId = readInt("Enter Prescription ID: ");
        Prescription prescription = all.stream().filter(p -> p.getId() == prescriptionId).findFirst().orElse(null);
        if (prescription == null) {
            System.out.println("Prescription not found.");
            return;
        }

        medicationView.displayMedications(medicationService.getAllMedications());
        int medicationId = readInt("Enter Medication ID: ");
        Medication medication = medicationService.getMedicationById(medicationId);
        if (medication == null) {
            System.out.println("Medication not found.");
            return;
        }

        System.out.print("Dosage (e.g. 500mg): ");
        String dosage = scanner.nextLine();

        System.out.print("Frequency (e.g. Twice daily): ");
        String frequency = scanner.nextLine();

        int duration = readInt("Duration: ");

        System.out.print("Duration Unit (days/weeks): ");
        String durationUnit = scanner.nextLine();

        System.out.print("Instructions: ");
        String instructions = scanner.nextLine();

        PrescriptionItem item = new PrescriptionItem();
        item.setMedication(medication);
        item.setDosage(dosage);
        item.setFrequency(frequency);
        item.setDuration(duration);
        item.setDurationUnit(durationUnit);
        item.setInstructions(instructions);

        if (prescriptionService.addItem(prescription, item)) {
            prescriptionView.displayItemAdded();
        } else {
            System.out.println("Failed to add prescription item.");
        }
    }

    private static void dispenseMedication() {

        List<Prescription> all = prescriptionService.getAllPrescriptions();
        prescriptionView.displayPrescriptions(all);

        int prescriptionId = readInt("Enter Prescription ID: ");
        Prescription prescription = all.stream().filter(p -> p.getId() == prescriptionId).findFirst().orElse(null);
        if (prescription == null || prescription.getItems().isEmpty()) {
            System.out.println("Prescription not found or has no items.");
            return;
        }

        PrescriptionItem item = prescription.getItems().get(0);
        if (prescription.getItems().size() > 1) {
            System.out.println("This prescription has " + prescription.getItems().size() + " items; dispensing the first: "
                    + (item.getMedication() != null ? item.getMedication().getName() : ""));
        }

        int quantity = readInt("Quantity to Dispense: ");

        MedicationDispensing record = new MedicationDispensing();
        record.setPrescription(prescription);
        record.setPrescriptionItem(item);
        record.setPatient(prescription.getPatient());
        record.setQuantity(quantity);

        if (medicationDispensingService.dispenseMedication(record)) {
            medicationDispensingView.displayMedicationDispensed();
        } else {
            System.out.println("Failed to dispense medication.");
        }
    }

    // =========================================================
    // BILLING & PAYMENT
    // =========================================================

    private static void billingMenu() {

        while (true) {

            System.out.println();
            System.out.println("================================================================");
            System.out.println("                      BILLING & PAYMENT");
            System.out.println("================================================================");
            System.out.println("1.  Create Invoice");
            System.out.println("2.  View All Invoices");
            System.out.println("3.  Find Invoice");
            System.out.println("4.  Update Invoice");
            System.out.println("5.  Add Invoice Item");
            System.out.println("6.  View Invoice Items");
            System.out.println("7.  Record Payment");
            System.out.println("8.  View Payments");
            System.out.println("9.  Patient Billing History");
            System.out.println("10. Outstanding Bills");
            System.out.println("0.  Back");
            System.out.println("================================================================");

            switch (readInt("Enter your choice: ")) {
                case 1 -> createInvoice();
                case 2 -> invoiceView.displayInvoices(invoiceService.getAllInvoices());
                case 3 -> invoiceView.displayInvoice(invoiceService.getInvoiceById(readInt("Enter Invoice ID: ")));
                case 4 -> updateInvoice();
                case 5 -> addInvoiceItem();
                case 6 -> invoiceView.displayInvoice(invoiceService.getInvoiceById(readInt("Enter Invoice ID: ")));
                case 7 -> recordPayment();
                case 8 -> paymentView.displayPayments(paymentService.getAllPayments());
                case 9 -> invoiceView.displayInvoices(invoiceService.getInvoicesByPatient(readInt("Enter Patient ID: ")));
                case 10 -> invoiceView.displayInvoices(invoiceService.getOutstandingInvoices());
                case 0 -> { return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void createInvoice() {

        int patientId = readInt("Enter Patient ID: ");
        Patient patient = patientService.getPatientById(patientId);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        Invoice invoice = new Invoice();
        invoice.setPatient(patient);
        invoice.setInvoiceDate(LocalDate.now());
        invoice.setStatus("UNPAID");

        if (invoiceService.createInvoice(invoice)) {
            invoiceView.displayInvoiceCreated();
            System.out.println("Invoice ID: " + invoice.getId());
        } else {
            System.out.println("Failed to create invoice.");
        }
    }

    private static void updateInvoice() {

        int id = readInt("Enter Invoice ID to update: ");
        Invoice invoice = invoiceService.getInvoiceById(id);

        if (invoice == null) {
            System.out.println("Invoice not found.");
            return;
        }

        System.out.print("Status [" + invoice.getStatus() + "] (UNPAID/PARTIAL/PAID): ");
        String status = scanner.nextLine();
        if (!status.isBlank()) invoice.setStatus(status.toUpperCase());

        System.out.println("Invoice updated successfully.");
    }

    private static void addInvoiceItem() {

        int invoiceId = readInt("Enter Invoice ID: ");
        Invoice invoice = invoiceService.getInvoiceById(invoiceId);
        if (invoice == null) {
            System.out.println("Invoice not found.");
            return;
        }

        System.out.print("Description: ");
        String description = scanner.nextLine();

        double amount = readDouble("Amount: ");

        InvoiceItem item = new InvoiceItem();
        item.setDescription(description);
        item.setAmount(amount);

        if (invoiceService.addInvoiceItem(invoice, item)) {
            invoiceView.displayItemAdded();
        } else {
            System.out.println("Failed to add invoice item.");
        }
    }

    private static void recordPayment() {

        int invoiceId = readInt("Enter Invoice ID: ");
        Invoice invoice = invoiceService.getInvoiceById(invoiceId);
        if (invoice == null) {
            System.out.println("Invoice not found.");
            return;
        }

        double amount = readDouble("Payment Amount: ");

        System.out.print("Payment Method (CASH/CARD/MOBILE MONEY): ");
        String method = scanner.nextLine();

        Payment payment = new Payment();
        payment.setInvoice(invoice);
        payment.setAmount(amount);
        payment.setPaymentMethod(method);
        payment.setPaymentDate(LocalDate.now());

        if (paymentService.recordPayment(payment)) {
            paymentView.displayPaymentRecorded();
        } else {
            System.out.println("Failed to record payment.");
        }
    }

    // =========================================================
    // HOSPITAL ADMINISTRATION
    // =========================================================

    private static void hospitalAdministrationMenu() {

        if (currentUser.getRole() != StaffRole.STAFF) {
            System.out.println();
            System.out.println("Access denied. Hospital Administration is restricted to administrators.");
            return;
        }

        while (true) {

            System.out.println();
            System.out.println("================================================================");
            System.out.println("                    HOSPITAL ADMINISTRATION");
            System.out.println("================================================================");
            System.out.println("1. Department Management");
            System.out.println("2. Ward Management");
            System.out.println("3. Room Management");
            System.out.println("4. Bed Management");
            System.out.println("5. User Management");
            System.out.println("6. Role Management");
            System.out.println("7. System Reports");
            System.out.println("0. Back");
            System.out.println("================================================================");

            switch (readInt("Enter your choice: ")) {
                case 1 -> departmentMenu();
                case 2 -> wardMenu();
                case 3 -> roomMenu();
                case 4 -> bedMenu();
                case 5 -> userManagementMenu();
                case 6 -> roleManagement();
                case 7 -> systemReports();
                case 0 -> { return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void departmentMenu() {

        while (true) {

            System.out.println();
            System.out.println("========== DEPARTMENT MANAGEMENT ==========");
            System.out.println("1. Add Department");
            System.out.println("2. View All Departments");
            System.out.println("0. Back");

            switch (readInt("Enter your choice: ")) {
                case 1 -> addDepartment();
                case 2 -> departmentView.displayDepartments(departmentService.getAllDepartments());
                case 0 -> { return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void addDepartment() {

        System.out.print("Department Name: ");
        String name = scanner.nextLine();

        System.out.print("Head of Department: ");
        String head = scanner.nextLine();

        Department department = new Department(name, head);

        if (departmentService.addDepartment(department)) {
            departmentView.displayDepartmentAdded();
        } else {
            System.out.println("Failed to add department.");
        }
    }

    private static void userManagementMenu() {

        while (true) {

            System.out.println();
            System.out.println("========== USER MANAGEMENT ==========");
            System.out.println("1. Create User");
            System.out.println("2. View All Users");
            System.out.println("3. Find User");
            System.out.println("4. Update User");
            System.out.println("5. Deactivate User");
            System.out.println("6. Activate User");
            System.out.println("7. Reset Password");
            System.out.println("0. Back");

            switch (readInt("Enter your choice: ")) {
                case 1 -> createUser();
                case 2 -> userView.displayUsers(userAccountService.getAllUsers());
                case 3 -> findUser();
                case 4 -> updateUser();
                case 5 -> {
                    System.out.print("Username to deactivate: ");
                    String username = scanner.nextLine();
                    userView.displayActionResult(userAccountService.deactivateUser(username), "Deactivation");
                }
                case 6 -> {
                    System.out.print("Username to activate: ");
                    String username = scanner.nextLine();
                    userView.displayActionResult(userAccountService.activateUser(username), "Activation");
                }
                case 7 -> {
                    System.out.print("Username: ");
                    String username = scanner.nextLine();
                    System.out.print("New Password: ");
                    String newPassword = scanner.nextLine();
                    userView.displayActionResult(userAccountService.resetPassword(username, newPassword), "Password reset");
                }
                case 0 -> { return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void createUser() {

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        StaffRole role = selectStaffRole();
        if (role == null) {
            return;
        }

        Staff staff = null;
        if (role == StaffRole.DOCTOR) {
            staff = doctorService.getDoctorById(readInt("Enter Doctor/Staff ID: "));
        } else if (role == StaffRole.NURSE) {
            staff = nurseService.getNurseById(readInt("Enter Nurse/Staff ID: "));
        } else if (role == StaffRole.PHARMACIST) {
            staff = pharmacistService.getPharmacistById(readInt("Enter Pharmacist/Staff ID: "));
        } else if (role == StaffRole.LABORATORY_TECHNICIAN) {
            staff = laboratoryTechnicianService.getLaboratoryTechnicianById(readInt("Enter Technician/Staff ID: "));
        }

        int nextId = userAccountService.getAllUsers().stream().mapToInt(User::getId).max().orElse(0) + 1;
        User user = new User(nextId, username, password, role, staff, true);

        if (userAccountService.createUser(user)) {
            userView.displayUserCreated();
        } else {
            System.out.println("Failed to create user.");
        }
    }

    private static StaffRole selectStaffRole() {
        System.out.println("Roles: 1=STAFF(Admin) 2=DOCTOR 3=NURSE 4=PHARMACIST 5=LABORATORY_TECHNICIAN");
        int choice = readInt("Select role: ");
        return switch (choice) {
            case 1 -> StaffRole.STAFF;
            case 2 -> StaffRole.DOCTOR;
            case 3 -> StaffRole.NURSE;
            case 4 -> StaffRole.PHARMACIST;
            case 5 -> StaffRole.LABORATORY_TECHNICIAN;
            default -> {
                System.out.println("Invalid role.");
                yield null;
            }
        };
    }

    private static void findUser() {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        User user = userAccountService.getUserByUsername(username);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }
        userView.displayProfile(user);
    }

    private static void updateUser() {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        User user = userAccountService.getUserByUsername(username);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }
        System.out.print("New Password (blank to keep current): ");
        String password = scanner.nextLine();
        if (!password.isBlank()) {
            user.setPasswordHash(password);
        }
        System.out.println("User updated successfully.");
    }

    private static void roleManagement() {
        System.out.println();
        System.out.println("Available roles: " + java.util.Arrays.toString(StaffRole.values()));
        System.out.println("(STAFF doubles as the hospital-administrator role.)");
    }

    private static void systemReports() {

        System.out.println();
        System.out.println("========== SYSTEM REPORTS ==========");
        System.out.println("Total Patients      : " + patientService.getAllPatients().size());
        System.out.println("Total Doctors       : " + doctorService.getAllDoctors().size());
        System.out.println("Total Nurses        : " + nurseService.getAllNurses().size());
        System.out.println("Total Pharmacists   : " + pharmacistService.getAllPharmacists().size());
        System.out.println("Total Lab Techs     : " + laboratoryTechnicianService.getAllLaboratoryTechnicians().size());
        System.out.println("Total Appointments  : " + appointmentService.getAllAppointments().size());
        System.out.println("Active Admissions   : " + admissionService.getActiveAdmissions().size());
        System.out.println("Available Beds      : " + bedService.getAvailableBeds().size());
        System.out.println("Occupied Beds       : " + bedService.getOccupiedBeds().size());
        System.out.println("Pending Lab Tests   : " + laboratoryTestService.getPendingTests().size());
        System.out.println("Outstanding Invoices: " + invoiceService.getOutstandingInvoices().size());
        System.out.println("=====================================");
    }

    // =========================================================
    // USER ACCOUNT
    // =========================================================

    private static void userAccountMenu() {

        while (true) {

            System.out.println();
            System.out.println("================================================================");
            System.out.println("                         USER ACCOUNT");
            System.out.println("================================================================");
            System.out.println("1. View My Profile");
            System.out.println("2. View My Role");
            System.out.println("3. View Account Status");
            System.out.println("4. Change Password");
            System.out.println("0. Back");
            System.out.println("================================================================");

            switch (readInt("Enter your choice: ")) {
                case 1 -> userView.displayProfile(currentUser);
                case 2 -> System.out.println("Role: " + currentUser.getRole());
                case 3 -> System.out.println("Account Status: " + (currentUser.isActive() ? "ACTIVE" : "INACTIVE"));
                case 4 -> changePassword();
                case 0 -> { return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void changePassword() {

        System.out.print("Current Password: ");
        String oldPassword = scanner.nextLine();

        System.out.print("New Password: ");
        String newPassword = scanner.nextLine();

        if (userAccountService.changePassword(currentUser, oldPassword, newPassword)) {
            userView.displayPasswordChanged();
        } else {
            System.out.println("Failed to change password.");
        }
    }

    // =========================================================
    // INPUT HELPERS
    // =========================================================

    private static int readInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private static double readDouble(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private static char readChar(String message) {
        while (true) {
            System.out.print(message);
            String line = scanner.nextLine().trim();
            if (!line.isEmpty()) {
                return Character.toUpperCase(line.charAt(0));
            }
            System.out.println("Please enter a value.");
        }
    }

    private static LocalDate readDate(String message) {
        while (true) {
            System.out.print(message);
            String line = scanner.nextLine().trim();
            try {
                return LocalDate.parse(line, DATE_FORMATTER);
            } catch (Exception e) {
                System.out.println("Invalid date format. Please use: yyyy-MM-dd");
            }
        }
    }

    /** Returns null (rather than looping) so the caller can abort the current action. */
    private static LocalDateTime readDateTime(String message) {
        System.out.println("Date format: yyyy-MM-dd HH:mm");
        System.out.print(message);
        String line = scanner.nextLine().trim();
        try {
            return LocalDateTime.parse(line, DATE_TIME_FORMATTER);
        } catch (Exception e) {
            System.out.println("Invalid date/time format. Please use: yyyy-MM-dd HH:mm");
            return null;
        }
    }
}
