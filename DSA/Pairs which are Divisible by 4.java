class Solution {
    public static int count4Divisibiles(int arr[]) {
        int[] count = new int[4]; // Array to count remainders 0, 1, 2, 3
        
        // Count occurrences of each remainder
        for (int num : arr) {
            count[num % 4]++;
        }

        int totalPairs = 0;

        // Pairs from remainder 0
        totalPairs += count[0] * (count[0] - 1) / 2; // C(count[0], 2)

        // Pairs from remainder 1 and 3
        totalPairs += count[1] * count[3];

        // Pairs from remainder 2
        totalPairs += count[2] * (count[2] - 1) / 2; // C(count[2], 2)

        return totalPairs;
    }
}
