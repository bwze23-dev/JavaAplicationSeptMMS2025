public class Matrix{
	public static void main(String[] args){
		int[][] numbers = {
			{7,8,9,6,4},
			{2,5,4,2,1},
			{5,6,3,9,7}
		};
		
		System.out.println("Matrix Format:");
		for(int row = 0; row < numbers.length; row++){
			for(int col = 0; col < numbers[row].length; col++){
				System.out.print(numbers[row][col] + "\t");
			}
			System.out.println();
		}
	}
}