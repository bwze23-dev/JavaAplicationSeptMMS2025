public class StaticMethodInJava{
	public static void main(String[] args){
		
		int sum = add(70,50,80);
		
		System.out.printf("The sum of all numbers is %d%n",sum);
		
		int sum = add(90,40,30);
		System.out.printf("The sum of all numbers is %d%n",sum);
		
		details(21,"kate mary");
		
		details(21,"John Doe");
		
		details(21,"Frank Franklin");
	}
	public static int add(int num1, int num2,int num3){
		
		int sum = num1 + num2 + num3;
		return sum;
	}
	public static void details(int age , string name){
		System.out.printf("Your name is %d%n",name);
		System.out.printf("You are %d years old%n",age);
	}
}