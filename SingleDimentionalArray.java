public class SingleDimentionalArray{
	public static void main(String[] args){
		int num = 15;
		int[] numbers = (2,4,6,8,12,15,20,25,26,30);
		
	    System.out.printf("The element at index number 5 is %d%n",numbers[5]);
	    System.out.printf("The element at index number 5 is %d%n",numbers[7]);
	
	    System.out.println("Transversing through the element of the array");
	    System.out.println("----------------------------------------");
	    for(int i = 0; i < 10; i++){
			System.out.printf("%s%n",numbers[i]);
	    
		}
		
	
	}
	
}