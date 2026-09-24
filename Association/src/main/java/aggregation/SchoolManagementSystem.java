
package aggregation;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SchoolManagementSystem {
    public static void main(String[] args){
        
       
        
        //Student objects
        Student s1 = new Student(201, "Son", "GOku", 
                'M');
        Student s2 = new Student(202, "Prince", "Vegeta",
                'M');
        Student s3 = new Student(203, "Bulma", "Brief",
                'F');
        Student s4 = new Student(204, "Roshi", "wher",
                'M');
        Student s5 = new Student(205, "Jiren", "The-Grey",
                'M');
        Student s6 = new Student(206, "Android", "Eighteen",
                'f');
        Student s7 = new Student(207, "Barak", "Roberts",
                'M');
        
        //STUDENTS THAT HAVE MADE PAYMENT
        s1.makePayment(300000,
                LocalDate.of(2026, 8,10),
                "Trasnfer", "Data Analysis");
        s2.makePayment(700000,
                LocalDate.of(2026, 8,23),
                "Trasnfer", "AI Automation");
        s3.makePayment(500000,
                LocalDate.of(2026, 8,01),
                "Trasnfer", "MMS");
        s4.makePayment(250000,
                LocalDate.of(2026, 8,10),
                "POS", "Cyber Security");
        s5.makePayment(250000,
                LocalDate.of(2026, 8,10),
                "POS", "Cyber Security");
        s6.makePayment(250000,
                LocalDate.of(2026, 8,10),
                "POS", "Cyber Security");
        
        
        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        
        School school = new School("Hilltop group of schools",
                students);
        
        //DISPLAY SCHOOL INFORMATION
        
        school.displayStudentDetails();
    }
}