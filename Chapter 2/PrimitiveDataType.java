public class PrimitiveDataType{
	public static void main (String[] args){
		byte myAge = 30;
		System.out.printf("Miss mercy is %d years old\n",myAge);
		
		short quantity = 20000;
		System.out.printf("The quantity of iphone ordered is %, d%n",quantity);
		
		int nigeriapopulation = 294848848;
		System.out.printf("The population of Nigeria is %, d%n",nigeriapopulation);
		
		long worldPopulation = 4747477847847874L;
		System.out.printf("The world's population is %, d%n", worldPopulation);
		
		float price = 57785.84747F;
		System.out.printf("The price of each iphone per unite is %,.2f%n",price);
		
		double myBalance = 74647847477747.967586;
		System.out.printf("My acount balance is %c%,.2f",'$',myBalance);
		
		char symbol = '%';
		System.out.printf("Ther is an increment in the world's population by 20.5%c%n",symbol);
		
		boolean isJavaFun = true;
		System.out.printf("Do you love java? %b",isJavaFun);
	}
}