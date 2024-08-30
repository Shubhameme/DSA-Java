package dsa;

public class Demo2 {
	public void printArray() {
		int[] arr = new int[]{5,1,9,2,19};
		
		
		
		int n = arr.length;
		
		for(int i=0; i<arr.length; i++) {
			
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}



public static void main(String[] args) {
	Demo2 demo = new Demo2();
	demo.printArray();
 }
}