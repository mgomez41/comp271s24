public class Final {
    public static void main(String[] args) {
        // Creates two arrays of size 4 and 6 and creates an empty array of size 10
        int[] arrayL = {23, 47, 81, 95};
        int[] arrayR = {7, 14, 39, 55, 62, 74};
        int[] mergeM = new int[10];

        // Merges both arrays into mergeM
        merge(arrayL, 4, arrayR, 6, mergeM);
        display(mergeM, 10);
    } // end main

    // Merge L and R into mergeM
    public static void merge(int[] arrayL, int sizeL, int[] arrayR, int sizeR, int[] mergeM) {
        int lnew = 0, rnew = 0, mnew = 0;

        while (lnew < sizeL && rnew < sizeR) {
            // Both arrays are not empty
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
}
