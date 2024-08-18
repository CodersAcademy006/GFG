class Solve {
    int[] findTwoElement(int arr[], int n) {
        // Calculate the expected sums
        long expectedSum = (long)n * (n + 1) / 2;
        long expectedSumSq = (long)n * (n + 1) * (2 * n + 1) / 6;

        // Calculate the actual sums
        long actualSum = 0;
        long actualSumSq = 0;

        for (int num : arr) {
            actualSum += num;
            actualSumSq += (long)num * num;
        }

        // Calculate differences
        long diffSum = expectedSum - actualSum; // A - B
        long diffSumSq = expectedSumSq - actualSumSq; // A^2 - B^2

        // Calculate A + B
        long sumAB = diffSumSq / diffSum;

        // Calculate A and B
        long A = (diffSum + sumAB) / 2;
        long B = A - diffSum;

        return new int[]{(int)B, (int)A}; // B is repeating, A is missing
    }
}
