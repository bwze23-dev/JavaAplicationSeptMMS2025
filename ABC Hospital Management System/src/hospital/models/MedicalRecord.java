
package hospital.models;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

public class MedicalRecord {
    private int id;
    private Patient patient;
    private LocalDate createdDate;
    
    private List<Diagnosis> diagnoses = new ArrayList<>();
    private List<Treatment> treatment = new ArrayList<>();
    private List<LaboratoryTest> laboratoryTests = new ArrayList<>();
    private List<Prescription> prescription = new ArrayList<>();
    private List<Admission> admission = new ArrayList<>();
    
    public MedicalRecord(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public List<Diagnosis> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(List<Diagnosis> diagnoses) {
        this.diagnoses = diagnoses;
    }

    public List<Treatment> getTreatment() {
        return treatment;
    }

    public void setTreatment(List<Treatment> treatment) {
        this.treatment = treatment;
    }

    public List<LaboratoryTest> getLaboratoryTests() {
        return laboratoryTests;
    }

    public void setLaboratoryTests(List<LaboratoryTest> laboratoryTests) {
        this.laboratoryTests = laboratoryTests;
    }

    public List<Prescription> getPrescription() {
        return prescription;
    }

    public void setPrescription(List<Prescription> prescription) {
        this.prescription = prescription;
    }

    public List<Admission> getAdmission() {
        return admission;
    }

    public void setAdmission(List<Admission> admission) {
        this.admission = admission;
    }
    
    
}
