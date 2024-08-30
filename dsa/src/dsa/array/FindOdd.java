package dsa.array;

import java.util.ArrayList;
import java.util.List;

public class FindOdd {
	
	
	
	
	public static void main(String[] args) {
		
		List<Integer> oddlist = new ArrayList<>();
		oddlist.add(1);
		oddlist.add(2);
		oddlist.add(3);
		oddlist.add(4);
		oddlist.add(5);
		
		oddlist.stream().filter(e -> e % 2 == 0).
		forEach(e -> {
			System.out.println(e);
		});
		
	}

}
