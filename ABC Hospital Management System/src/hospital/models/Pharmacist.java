
package hospital.models;

import java.time.LocalDate;

public class Pharmacist extends Staff{
       
    private String qualifiction; 
    private String licenseNumber;
    
    public Pharmacist(){
    
    }
    
     public Pharmacist(String firstName, String lastName, char gender, LocalDate dateOfBirth, 
            String phone, String email, String street, String city, String country, int staffId, 
            LocalDate employmentDate, double salary,
            Department department,String qualifiction, String licenseNumber) {
        super(firstName, lastName, gender, dateOfBirth, phone, email, street, city, country, staffId, employmentDate, salary, department);
        this.qualifiction = qualifiction;
        this.licenseNumber = licenseNumber;
    }

    public String getQualifiction() {
        return qualifiction;
    }

    public void setQualifiction(String qualifiction) {
        this.qualifiction = qualifiction;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }
    
    
}
