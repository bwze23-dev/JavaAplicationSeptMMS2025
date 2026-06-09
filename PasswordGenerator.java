import java.util.Random;

public class PasswordGenerator {
	public static void main(String[] args){
		Random random = new Random();
		StringBuilder password = new StringBuilder();
		
		String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String specialChars = "!@#$%^&*()_=+[]{}|;:,.<>?";
		
		for (int i = 0; i < 15; i++){
			int choice = random.nextInt(4);
			
			switch (choice){
				case 0:
				       password.append(random.nextInt(10));
				break;
				case 1:
				       password.append(letters.charAt(random.nextInt(letters.length())));
				break;
				case 2:
				       password.append(letters.toLowerCase().charAt(random.nextInt(letters.length())));
				break;
				case 3:
				       password.append(specialChars.charAt(random.nextInt(specialChars.length())));
				break;
			}
		}
		
		System.out.println("Generated 15-Digit Password: " + password.toString());
	}
}