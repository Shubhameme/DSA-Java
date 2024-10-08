package dsa.array;

public class SecondMinimum {
	public static void main(String[] args) {
		int[] arr = { 13, 34, 2, 34, 33, 1 };
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"  ");
		}
		
		System.out.println();
		
		int max = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i]>max) {
				secondMax = max;
				max = arr[i];
			} else if( arr[i] > secondMax && arr[i] != max ) {
				secondMax = arr[i];
				System.out.println("Max is: "+ max);
				System.out.print("Second Max is: "+ secondMax);
			}
			
		}

	}

}
