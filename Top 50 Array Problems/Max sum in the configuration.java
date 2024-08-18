class Solution {
    long max_sum(int a[], int n) {
        // Calculate the sum of array elements (S) and initial value of i*a[i] (current_value)
        long S = 0, current_value = 0;
        for (int i = 0; i < n; i++) {
            S += a[i];
            current_value += i * a[i];
        }
        
        // Initialize the result with the initial value
        long max_value = current_value;
        
        // Compute the value for all rotations
        for (int i = 1; i < n; i++) {
            // Calculate next_value from current_value
            current_value = current_value + S - n * a[n - i];
            // Update max_value if current_value is greater
            max_value = Math.max(max_value, current_value);
        }
        
        return max_value;
    }
}
