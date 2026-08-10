
package aggregation;


import java.util.ArrayList;

public class SchoolManagementSystem {
    public static void main(String[] args){
        Student s1 = new Student(201, "Son", "GOku", 
                'M');
        Student s2 = new Student(202, "Prince", "Vegeta",
                'M');
        Student s3 = new Student(203, "Bulma", "Brief",
                'F');
        Student s4 = new Student(204, "Son", "Gohan",
                'M');
        
        ArrayList<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        
        School school = new School("Hilltop group of schools",
                students);
        
        school.displayStudentDetails();
    }
}

