
package classwork5;

public class MainInterface {
    public static void main(String[] args){
        
        Teacher teacher = new Teacher("John Doe",31);
        
        Student student = new Student(" Lucy Tom",19);
        
        System.out.println("----Teacher's Details----");
        teacher.displayDetails();
        teacher.performDuty();
        
        System.out.println("\n");
    }
}
