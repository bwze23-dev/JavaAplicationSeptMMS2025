
package aggregation;

import java.util.List;

public class School {
    private String schoolName;
    private List<Student> student;

    
    
    public School(String schoolName, List<Student> student){
        this.schoolName = schoolName;
        this.student = student;
    }
    
    public void displayStudentDetails(){
        
        System.out.println();
        System.out.println("        SCHOOL INFORMATION");
        System.out.println("=============================================");
        System.out.println("School Name: " + schoolName);
        System.out.println("Number of Students: " + student.size());
        System.out.println("=============================================");
        
        for(Student students:student){
            students.displayStudentDetails();
        }
        
    }
    
}