
package classwork;

public class Shape {
   public static void main(String[] args){
       Shape[] shapeObject ={
           new Circle(),
           new Rectangle(),
           new Triangle()
       
       
       };
       
       for(Shape shape : ShapeObject){
           shape.draw();
       }
   } 
}
