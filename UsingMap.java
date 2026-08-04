import java.util.UsingMap;
import java.util.Map;
import java.util.Set;

public class UsingMap{
	public static void main(String[] args){
		Map<interger,String> map = new HashMap<>();
		
		map.put(101,"Frank John");
		map.put(102,"Henry Clinton");
		map.put(103,"Kate Benson");
		map.put(104,"F Jerry");
		map.put(105,"Johnny Victor");
		map.put(106,"Kate Benson");
		map.put(101,"Nathan Zon");
		
		
		String Value = map.get(102);
		System.out.println("Value for 102: " + value);
		
		map.remove(106;
		
		boolean hashApple = map.containKey(106);
		System.out.println("Map contains 106: " + hasApple);
		
		Set<interger> keys = map.KeySet();
		System.out.println("Keys in map:" + Keys);
		
		




	}
}