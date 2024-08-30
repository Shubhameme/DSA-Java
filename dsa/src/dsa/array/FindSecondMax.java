package dsa.array;

public class FindSecondMax {
	public static int secondMax(int[] arr) {
		int max = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;
		
		for(int i =0;i<arr.length;i++) {
			if(arr[i]>max) {
				secondMax = max;
				max = arr[i];
			}else if(arr[i]>secondMax && arr[i]!= max) {
				secondMax=arr[i];
			}
			
		}
		return secondMax;
		
		
	}

	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		int[] arr = {2,35,85,35,36,1};
		System.out.println("secondMax: "+ secondMax(arr));
		
	}

}
