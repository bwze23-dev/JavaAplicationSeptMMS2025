
package classwork4;

public class TestStudent {
    public static void main(String[] args){
        Student[] studentObject ={
            new UnderGraduateStudent(),
            new GraduateStudent()
        
        };
        for(Student student : studentObject){
            student.study();
        }
                
    }
}
