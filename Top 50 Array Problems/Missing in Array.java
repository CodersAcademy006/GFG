class Solution {

    // Note that the size of the array is n-1
    int missingNumber(int n, int arr[]) {
        // Calculate the sum of first n natural numbers
        int totalSum = n * (n + 1) / 2;
        
        // Calculate the sum of the array elements
        int arrSum = 0;
        for (int i = 0; i < arr.length; i++) {
            arrSum += arr[i];
        }
        
        // The missing number is the difference between totalSum and arrSum
        return totalSum - arrSum;
    }
}
