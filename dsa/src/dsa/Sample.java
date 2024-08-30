package dsa;


public class Sample{
	
	public void printArray(int[] arr) {
		int n = arr.length;
		for(int i=0;i< n;i++) {
			System.out.print(arr[i] + "");
		}
		
		System.out.println();
	}
	
	public void arrayDemo() {
		int[] myArray = new int[5];
		myArray[0]=1;
		myArray[1]=2;
		myArray[2]=3;
		myArray[3]=4;
		myArray[4]=5;
		printArray(myArray);
		System.out.println(myArray);
	}

	public static void main(String[] args) {
		
		Sample sammple = new Sample();
		sammple.arrayDemo();
		
	}
}
	


