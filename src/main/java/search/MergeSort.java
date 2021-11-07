package search;

/**
 * Merge Sort is a Divide and Conquer algorithm.
 * The merge(arr, l, m, r) assumes that arr[l..m] and arr[m+1..r] are sorted and merges the two sorted sub-arrays into one.
 *
 * Time complexity of Merge Sort is O(nLogn) in all 3 cases (worst, average and best)
 */
public class MergeSort {

    /**
     * sorts arr[l..r] using merge()
     **/
    public static void sort(int[] arr, int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            sort(arr, l, m);
            sort(arr, m+1, r);

            merge(arr, l, m ,r);
        }
    }

    /**
     * Merges two subarrays of arr[].
     * First subarray is arr[l..m]
     * Second subarray is arr[m+1..r]
     **/
    private static void merge(int[] arr, int l, int m, int r) {
        int i = l;
        int j = m+1;
        int[] tempArray = new int[r - l + 1];
        int index = 0;

        while(i <= m && j <= r) {
            if (arr[i] <= arr[j]) {
                tempArray[index] = arr[i];
                ++i;
                ++index;
            } else {
                tempArray[index] = arr[j];
                ++j;
                ++index;
            }
        }
        while(i <= m) {
            tempArray[index] = arr[i];
            ++i;
            ++index;
        }
        while(j <= r) {
            tempArray[index] = arr[j];
            ++j;
            ++index;
        }

        System.arraycopy(tempArray, 0, arr, l, tempArray.length);
    }

}
