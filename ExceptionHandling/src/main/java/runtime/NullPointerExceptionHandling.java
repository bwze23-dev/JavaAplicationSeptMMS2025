
package runtime;

public class NullPointerExceptionHandling {
    public static void main(String[] args){
        try{
            String name = null;
            
            System.out.println("The length of name is "+ name.length());   
        }
        catch(NullPointerException e){
            System.out.println("Name is not been initialised");
        }
        
    }
}
