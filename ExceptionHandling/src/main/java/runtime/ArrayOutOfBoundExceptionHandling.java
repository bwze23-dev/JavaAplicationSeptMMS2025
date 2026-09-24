
package runtime;

public class ArrayOutOfBoundExceptionHandling {
    public static void main(String[] args){
        int[] age = {18,21,19,20,14};
        try{
            System.out.println("Element at idex % Is" + age(5));
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid array index");
        }
        
    }
}
