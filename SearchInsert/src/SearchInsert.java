public class SearchInsert {

    public int searchInsert(int[]arr, int target){
        int low = 0;
        int high = arr.length-1;

        while (low <= high){
            int mid = low+(high - low)/2;
            if(arr[mid] == target) return mid;
            if(target<arr[mid]){
                high = mid -1;

            }else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        SearchInsert si = new SearchInsert();
        int[] arr = {1,2,3,5,6,7};
        System.out.println("Inserted at index: "+si.searchInsert(arr,4));

    }
}
