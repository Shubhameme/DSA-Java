package dsa.array;

public class FindMissingNo {
	
	public static void main(String[] args) {
		int[] arr = { 1,2,3,4,6};
		int n = arr.length+1;
		int sum = n * (n+1)/2;
		
		for( int num : arr){
			sum -= num;
		}
			
		System.out.println(sum);
		
	}

}
