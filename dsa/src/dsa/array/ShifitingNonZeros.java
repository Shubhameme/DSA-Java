package dsa.array;

import java.util.Arrays;

public class ShifitingNonZeros {
	
	public static void nonZero(int[] arr) {
		int j = 0;
		
		for(int i = 0; i<arr.length;i++) {
			if(arr[i] != 0 && arr[j] == 0) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j]=temp;
				
			}
			if(arr[j] != 0) {
				j++;
			}
			
		}
	
		
	}
	
	public static void main(String[] args) {
		ShifitingNonZeros zeros = new ShifitingNonZeros();
		
		int[] arr = {1,2,0,5,0,9,8,6,3};
		nonZero(arr);
		System.out.println(Arrays.toString(arr));

}
}
