public class LinnearSearch {

    public int search(int[]arr,int n, int x){
        for(int i =0;i<n;i++){
            if(arr[i]==x){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LinnearSearch ls = new LinnearSearch();
        int[] arr = {5,1,9,2,10,15,20};
        System.out.println( "Element present in Index of: "+ls.search(arr,7,99));

    }
}
