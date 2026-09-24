
package hospital.models;

import java.time.LocalDate;

public class Admission {
   private int id; 
   private Patient patient; 
   private LocalDate admisssionDate;
   private LocalDate dischargeDate; 
   private String reason; 
   private String status; 
   
   public Admission(){
   
   }

    public int getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDate getAdmisssionDate() {
        return admisssionDate;
    }

    public void setAdmisssionDate(LocalDate admisssionDate) {
        this.admisssionDate = admisssionDate;
    }

    public LocalDate getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(LocalDate dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
   
   
}
