public class SquareSort {

    public static int[] sortedSquare(int[] arr) {
        int n = arr.length;
        int i = 0;         // Start pointer
        int j = n - 1;     // End pointer
        int[] result = new int[n]; // Result array to store sorted squares

        for (int k = n - 1; k >= 0; k--) { // Fill the result array from end to start
            if (Math.abs(arr[i]) > Math.abs(arr[j])) {
                result[k] = arr[i] * arr[i];
                i++;
            } else {
                result[k] = arr[j] * arr[j];
                j--;
            }
        }
        return result;
    }

    public void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {-4, -1, 0, 3, 10};
        SquareSort ss = new SquareSort();
        ss.printArray(sortedSquare(arr));
//
    }
}
