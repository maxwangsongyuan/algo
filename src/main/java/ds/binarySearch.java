package ds;

import java.util.Arrays;

public class binarySearch {

    public static int binarySearchBasic(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static int binarySearchAlternative(int[] arr, int target) {
        int l = 0;
        int r = arr.length;   // r is boundary now. not involved in search
        while (l < r) {       // altered -> keeping = may end up in infinite loop
            int mid = (l + r) >>> 1; // >>> is the unsigned right shift operator,
                                     // move 1 bit to the right == divide by 2
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;      // altered
            }
        }
        return -1;
    }

    public static int binarySearch3(int[] arr, int target) {
        int l = 0;
        int r = arr.length;   // r is boundary now. not involved in search
        while (1 < r - l) {       // altered -> when there are still element to traverse
            int mid = (l + r) >>> 1;
            if (arr[mid] <= target) {
                l = mid;     // altered
            } else {
                r = mid;
            }
        }

        if (arr[l] == target) {
            return l;
        } else {
            return -1;
        }
    }

    //Use >> when you need to maintain the sign of the number.
    //Use >>> when you want to ensure that the leftmost bits are filled with 0,
    // effectively treating the number as unsigned.
    public static int binarySearch4(int[] arr, int target) {
        return Arrays.binarySearch(arr, target);
    }

    //重复元素的处理
    public static int binarySearchLeftMost(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        int candidate = -1;

        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] == target) {
                candidate = mid;
                r = mid - 1;
            } else if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return candidate;
    }

    //find left most, if not found, return the index where it should be inserted
    public static int binarySearchLeftMost2(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (target <= arr[mid] ) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static int binarySearchRightMost(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        int candidate = -1;

        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (target < arr[mid]) {
                r = mid - 1;
            } else if (arr[mid] < target) {
                l = mid + 1;
            } else {
                candidate = mid;
                l = mid + 1;
            }
        }
        return candidate;
    }

    //find right most, if not found, return the index where it should be inserted
    public static int binarySearchRightMost2(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (target < arr[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l - 1; //or return r
    }


}
