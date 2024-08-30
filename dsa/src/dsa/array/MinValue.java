package dsa.array;

public class MinValue {
	
	public static int minValue(int [] arr) {
		int min = arr[0];
		
		for(int i = 0; i<arr.length;i++) {
			if(arr[i]<min) {
				min = arr[i];
			}
			
		}
		return min;
	}
	public static void main(String[] args) {
		int[] arr = {1,3,55,89};
		System.out.println(minValue(arr));
	}

}
