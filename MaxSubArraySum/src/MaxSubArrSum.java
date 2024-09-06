public class MaxSubArrSum {

    public static int maxSubArraySum(int[] arr){
        int n = arr.length;
        int currentMax = arr[0];
        int maxSoFar = arr[0];

        for (int i=1;i<n;i++){
            currentMax = currentMax +arr[i];//element becomes part of current sub array.
            if(currentMax<arr[i]){
                currentMax = arr[i];// element decides to start its own array.
            }
            if(maxSoFar<currentMax){
                maxSoFar = currentMax;
            }
        }
        return maxSoFar;
    }

    public void printArray(int[] arr){
        System.out.print("Current Array is: ");
        for (int i =0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] arr = {4,3,-2,6,-12,7,-1,6};
        MaxSubArrSum msa = new MaxSubArrSum();
        msa.printArray(arr);
        System.out.println("Maximum sum is: "+ maxSubArraySum(arr));
    }
}
