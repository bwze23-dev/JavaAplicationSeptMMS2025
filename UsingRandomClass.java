import java.util.Random;

public class UsingRandomClass{
	public static void main(String[] args){
		Random random = new Random();
		
		int generatedinteger = random.nextint();
		System.out.printf("The generated number is %d%n",generatedinteger);
		
		int rangenumber = random.nextint(100) + 1;
		System,out.printf("The number generated is %d%n",rangenumber);
		
		boolean isJava = random.nextboolean();
		System.out.printf("Do you love java %s%n",isJava);
		
		double decimalnumber = random.nextdouble();
		System.out.printf("The 
	}
}