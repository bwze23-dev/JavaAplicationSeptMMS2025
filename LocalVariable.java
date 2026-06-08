public class LocalVariable{
	
	
	public static void main(String[] args){
		/*A local variable is a variable that is declared within a method, constructor or block 
		and can only be accessed within that method, constructor, or block*/
		int age = 35;
		
		if (age >= 18){
			String name = "John Smith";
			System.out.printf("Your name is %s and you are %d years old.%n",name,age);
		}
		
		System.out.printf("i am printing age: %d%n",age);
	}
}