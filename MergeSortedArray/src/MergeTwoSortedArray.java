public class MergeTwoSortedArray {

    public void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public int[] merge(int[] arr1, int[] arr2, int n, int m) {
        int[] result = new int[n + m];
        int i = 0, j = 0, k = 0;

        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                result[k] = arr1[i];
                i++;
            } else {
                result[k] = arr2[j];
                j++;
            }
            k++;
        }
        while (i < n) {
            result[k] = arr1[i];
            i++;
            k++;
        }
        while (j < m) { // Corrected loop condition and array reference
            result[k] = arr2[j];
            j++;
            k++;
        }

        return result;
    }

    public static void main(String[] args) {
        MergeTwoSortedArray mtsa = new MergeTwoSortedArray();
        int[] arr1 = {1, 3, 8, 10};
        int[] arr2 = {2, 4, 11, 15, 20};

        int[] mergedArray = mtsa.merge(arr1, arr2, arr1.length, arr2.length);

        mtsa.printArray(mergedArray);
    }
}
