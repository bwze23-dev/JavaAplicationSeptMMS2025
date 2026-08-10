
package aggregation;

import java.util.ArrayList;

public class School {
    private String schoolName;
    private ArrayList<Student> student;
    
    
    
    public School(String schoolName,ArrayList<Student> student){
        this.schoolName = schoolName;
        this.student = student;
    }
    
    public void displayStudentDetails(){
        System.out.printf("School Name: %s%n",schoolName);
        
        for(Student students:student){
            students.displayStudentDetails();
        }
    }
    
}