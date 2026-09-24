/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital.models;

import java.time.LocalDateTime;

/**
 *
 * @author ERONMWON
 */
public class MedicationDispensing {
    
    private int id; 
    private Prescription prescription; 
    private PrescriptionItem prescriptionItem; 
    private Pharmacist pharmacist; 
    private Patient patient; 
    private LocalDateTime dispensingDate; 
    private int quantity; 
    private String status; 
    private String notes; 
    
    
}
