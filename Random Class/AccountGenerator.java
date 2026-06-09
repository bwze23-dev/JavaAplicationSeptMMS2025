import java.util.Random;

public class AccountGenerator{
	public static void main(String[] args){
		Random random = new Random();
		StringBuilder accountNumber = new StringBuilder();
		
		for (int i =1; i <= 3; i++){
			switch (i){
				case 1:
				case 2:
				case 3:
				       accountNumber.append("0");
					   break;
			}
		}
		 for (int i = 0; i < 7; i++){
			 int randomDigit = random.nextInt(10);
			 accountNumber.append(randomDigit);
			 
		 }
		 System.out.println("Generated Account Number: " + accountNumber.toString());
	}
}