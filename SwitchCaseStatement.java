import java.util.Scanner

public class SwitchCaseStatement{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int score;
		String name;
		String subject;
		
		System.out.print("Enter your name: ");
		name = input.nextLine();
		
		System.out.print("Enter you subject: ");
		subject = input.nextLine();
		
		System.out.print("Enter your score: ");
		score = input.nextLine();
		
		system.out.println("");
		system.out.println("---------------------------");
		
		if(score > 100){
			System.out.prinln("Score can not be greater than 100";
		}
		else{
	
			
		
		
		switch(score/10){
			case 0:
			case 1:
			case 2:
			    System.out.printf("Full Name: %s%n".name);
			    System.out.printf("Subject: %s%n".subject);
		        System.out.printf("Score: %d%n".score);
			    System.out.println("Grade: A");
			break;
			case 3:
			    System.out.printf("Full Name: %s%n".name);
			    System.out.printf("Subject: %s%n".subject);
		        System.out.printf("Score: %d%n".score);
			    System.out.println("Grade: B");
			break;
			case 4:
			    System.out.printf("Full Name: %s%n".name);
			    System.out.printf("Subject: %s%n".subject);
		        System.out.printf("Score: %d%n".score);
			    System.out.println("Grade: C");
			break;
			case 5:
			    System.out.printf("Full Name: %s%n".name);
			    System.out.printf("Subject: %s%n".subject);
		        System.out.printf("Score: %d%n".score);
			    System.out.println("Grade: D");
			break;	
			case 6:
			    System.out.printf("Full Name: %s%n".name);
			    System.out.printf("Subject: %s%n".subject);
		        System.out.printf("Score: %d%n".score);
			    System.out.println("Grade: E");
			break;
			case 7:
			case 8:
			case 9:
			case 10:
			    System.out.printf("Full Name: %s%n".name);
			    System.out.printf("Subject: %s%n".subject);
		        System.out.printf("Score: %d%n".score);
			    System.out.println("Grade: A\n");
			break;
			default:
			    System.out.println("Invalid Score inputed");

			
				
			
						
			
		}	
		}
	}
}