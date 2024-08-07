public class Sorting271 {
    public static void main(String[] args) {
        // Creates two arrays of size 4 and 6 and creates an empty array of size 10
        int[] arrayL = {23, 47, 81, 95};
        int[] arrayR = {7, 14, 39, 55, 62, 74};
        int[] mergeM = new int[10];

        // Merges both arrays into mergeM
        merge(arrayL, 4, arrayR, 6, mergeM);
        System.out.println("Merged Array:");
        display(mergeM, 10);

        // Example of sorting an array using merge sort
        int[] arrayToSort = {34, 7, 23, 32, 5, 62, 14};
        System.out.println("Unsorted Array:");
        display(arrayToSort, arrayToSort.length);
        
        sort(arrayToSort, 0, arrayToSort.length - 1);
        
        System.out.println("Sorted Array:");
        display(arrayToSort, arrayToSort.length);
    } // end main

    // Merge L and R into mergeM
    public static void merge(int[] arrayL, int sizeL, int[] arrayR, int sizeR, int[] mergeM) {
        int lnew = 0, rnew = 0, mnew = 0;

        while (lnew < sizeL && rnew < sizeR) {
            if (arrayL[lnew] < arrayR[rnew]) {
                mergeM[mnew++] = arrayL[lnew++];
            } else {
                mergeM[mnew++] = arrayR[rnew++];
            }
        }

        while (lnew < sizeL) {
            mergeM[mnew++] = arrayL[lnew++];
        }

        while (rnew < sizeR) {
            mergeM[mnew++] = arrayR[rnew++];
        }
    } // end merge

    // Display the array
    public static void display(int[] array, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    // Merge sort function
    public static void sort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;

        sort(array, left, mid);
        sort(array, mid + 1, right);

        merge(array, left, mid, right);
    }

    // Merge function used in merging
    public static void merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = array[i++];
        }

        while (j <= right) {
            temp[k++] = array[j++];
        }

        System.arraycopy(temp, 0, array, left, temp.length);
    }
} // end MergeFirst