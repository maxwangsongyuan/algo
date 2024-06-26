package ds;

import org.junit.jupiter.api.Test;

import static ds.binarySearch.binarySearchRightMost;
import static ds.binarySearch.binarySearchRightMost2;
import static org.junit.jupiter.api.Assertions.*;

class binarySearchTest {
    @Test
    void binarySearchBasic() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 5;
        int expected = 4;
        int actual = binarySearch.binarySearchBasic(arr, target);
        assertEquals(expected, actual);
    }

    @Test
    void binarySearchAlternative() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 5;
        int expected = 4;
        int actual = binarySearch.binarySearchAlternative(arr, target);
        assertEquals(expected, actual);
    }

    @Test
    void binarySearch3() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 5;
        int expected = 4;
        int actual = binarySearch.binarySearch3(arr, target);
        assertEquals(expected, actual);
    }

    @Test
    void binarySearch4() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 5;
        int expected = 4;
        int actual = binarySearch.binarySearch4(arr, target);
        assertEquals(expected, actual);
    }

    @Test
    void binarySearchLeftMost() {
        int[] arr = {1, 2, 4, 4, 5, 5, 8, 9, 10};
        int target = 4;
        int expected = 2;
        int actual = binarySearch.binarySearchLeftMost(arr, target);
        assertEquals(expected, actual);
    }

    @Test
    void binarySearchLeftMost2() {
        int[] arr = {1, 2, 4, 4, 4, 5, 8, 9, 10};
        int target = 4;
        int expected = 2;
        int actual = binarySearch.binarySearchLeftMost2(arr, target);
        assertEquals(expected, actual);
    }

        @Test
        void binarySearchRightMostTest() {
            int[] arr = {1, 2, 4, 4, 4, 4, 8, 9, 10};
            int target = 4;
            int expected = 5;
            int actual = binarySearchRightMost(arr, target);
            assertEquals(expected, actual);
        }

        @Test
        void binarySearchRightMostTest2() {
            int[] arr = {1, 2, 4, 4, 4, 4, 8, 9, 10};
            int target = 5;
            int expected = 5;
            int actual = binarySearchRightMost2(arr, target);
            assertEquals(expected, actual);
        }
}