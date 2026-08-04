public class MultiDimentionalArray{
	public static void main(String[] args){
		int[][] numbers = {
			{7,8,9,6,4},
			{2,5,4,2,1},
			{5,6,3,9,7}
		};
		
		System.out.println("The element of the Array are:");
		for(int row = 0; row < 3; row++){
			for(int col = 0; col < 5; col++){
				System.out.printf("%s%n" ,numbers[row][col]);
			}
			
		}
	}
}