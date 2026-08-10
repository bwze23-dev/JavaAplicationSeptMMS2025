
package aggregation;

public class Student {
    private int studentID;
    private String firstName;
    private String lastName;
    private char gender;

    public Student(int studentID, String firstName, String lastName, char gender) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }
    
    public void displayStudentDetails(){
        System.out.println("===========================");
        System.out.printf("Student ID: %d%n",studentID);
        System.out.printf("First Name: %s%n",firstName);
        System.out.printf("Last Name: %s%n",lastName);
        System.out.printf("Gender: %c%n",gender);
        System.out.println("===========================");
    }
}
