import java.util.List;
import java.util.ArrayList;

public class UsingList{
	public static void main(String[] args){
		List<String> car = new ArrayList<>();
		
		cars.add("Toyota");
		cars.add("BMW");
		cars.add("Mercedes Benz");
		cars.add("Toyota");
		cars.add(1,"Ford");
		
		System.out.printf(cars.size());
		
		// set the Value of an element
		
		car.add(1,"Dodge");
		
		// removing an element from the List
		cars.remove(0);
		
		System.out.printf("The size: %d%n%n",cars.size());
		
		// get element using the indexing
		System.out.printf("%s%n",cars.get(1));
		
		
		for(String car : cars){
			System.out.println(car);
		}
		
	}
}