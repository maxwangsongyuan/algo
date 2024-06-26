package recursion;

public class bubbleSort {
    public static void bubbleSort(int[] arr) {
//        bubbleSort(arr, arr.length - 1);
        bubbleSortImproved(arr, arr.length - 1);
    }

    private static void bubbleSort(int[] arr, int rightbound) {
        if (rightbound == 0) {
            return;
        }

        for (int i = 0; i < rightbound; i++) {
            if (arr[i] > arr[i + 1]) {
                swap(arr, i, i + 1);
            }
        }

        bubbleSort(arr, rightbound - 1);
    }


    //o (n^2)
    private static void bubbleSortImproved(int[] arr, int rightbound) {
        if (rightbound == 0) {
            return;
        }
        int dividingIndex = 0; //anything to the right of this index is sorted
        for (int i = 0; i < rightbound; i++) {
            if (arr[i] > arr[i + 1]) {
                swap(arr, i, i + 1);
                dividingIndex = i;
            }
        }

        bubbleSort(arr, dividingIndex);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        bubbleSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
