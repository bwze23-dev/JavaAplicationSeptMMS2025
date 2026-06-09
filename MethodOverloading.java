import java.util.Scanner;

public class MethodOverloading{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		
		System.out.println("------calculate perimeter of Square----");
		System.out.println("Enter 1.  for Square");
		System.out.println("Enter 2.  for Rectangle");
		System.out.println("Enter 3.  for Triangle");
		System.out.println("Enter 4.  Exit Program");
		
		System.out.print("Enter your choice");
		
		int choice = scan.nextint();
		
		switch(choice){
			case 1:
			       System.out.print("Enter the length of square ");
				   int lenOfSquare = scan.nextint():
			break:
			case 2:
			       System.out.print("Enter the length of rectangle ");
				   int lenOfRect = scan.nextint():
				   
				   perimeter(lenOfRect,widthOfRect);
			break:
			case 3:
			      System.out.print("Enter sideA ");
				   int sideA = nextint();
				   
				   System.out.print("Enter sideB ");
				   int sideB = nextint();
				   
				   System.out.print("Enter sideC ");
				   int sideC = nextint();
				   
				   perimeter (sideA,sideB,sideC);
			break:
			default:
			          System,out.println("
		}
	}
	public static void perimeter(int squareLen){
		int perimeterOfSquare = 4 * squareLen;
		
		System.out.printf("The perimeter of the square is %s%n",perimeterOfSquare);
	}
	public static void perimeter(int LenOfBreath,int widthOfBreath){
		int perimeterOfBreath = 4 * (LenOfBreath * widthOfBreath);
		
		System.out.printf("The perimeter of the square is %s%n",perimeterOfSquare);
	}
	public static void perimeter(int sideA,int sideB,int sideC){
		int perimeterOfTriangle = side a + side b + side c ;
		
		System.out.printf("The perimeter of the triangle is %s%n",perimeterOfTriangle);
	}

}