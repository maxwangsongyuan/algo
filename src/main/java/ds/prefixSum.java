package ds;

public class prefixSum {
    //The prefix sum technique involves creating an array where each element at index
    //represents the sum of elements from the start of the original array up to index
    //This technique can be used to efficiently compute range sums and solve various
    // array problems by precomputing cumulative sums.

    public int largestAltitude(int[] gain) {
        int currentAltitude = 0;
        int maxAltitude = 0;

        for (int i = 0; i < gain.length; i++) {
            currentAltitude += gain[i];
            if (currentAltitude > maxAltitude) {
                maxAltitude = currentAltitude;
            }
        }

        return maxAltitude;
    }
}
