package recursion;

//没有太明白
public class insertionSort {
    public static void insertionSort(int[] arr) {
        insertionSortHelper(arr, 1);
    }

    private static void insertionSortHelper(int[] arr, int lowerBound) {
        if (lowerBound == arr.length) {
            return;
        }

        int last = arr[lowerBound];
        int j = lowerBound - 1; //alreadt sorted area to the left of j, inclusive of j

        while (j >= 0 && arr[j] > last) { //haven't found the right place to insert
            arr[j + 1] = arr[j]; //shift the element to the right
            j--;
        }

        arr[j + 1] = last;

        insertionSortHelper(arr, lowerBound + 1);
    }

    private static void insertionSortHelper2(int[] arr, int lowerBound) {
        if (lowerBound == arr.length) {
            return;
        }

        int last = arr[lowerBound];
        int j = lowerBound - 1; //alreadt sorted area to the left of j, inclusive of j

        while (j >= 0 && arr[j] > last) { //haven't found the right place to insert
            arr[j + 1] = arr[j]; //shift the element to the right
            j--;
        }

        if (j + 1 != lowerBound ) {
            arr[j + 1] = last;
        }

        insertionSortHelper(arr, lowerBound + 1);
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        insertionSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
