class Solution {
    // Function for finding maximum and value pair
    public static int save_gotham(int arr[]) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        long totalSum = 0;
        final int MOD = 1000000007;

        // Initialize an array to store the next greater elements
        int[] nextGreater = new int[n];

        // Iterate through the array
        for (int i = 0; i < n; i++) {
            // While stack is not empty and the current element is greater than the top element of the stack
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                int index = stack.pop();
                nextGreater[index] = arr[i]; // Store the next greater element
            }
            stack.push(i); // Push the current index onto the stack
        }

        // For remaining indices in the stack, there is no greater element
        while (!stack.isEmpty()) {
            int index = stack.pop();
            nextGreater[index] = 0; // No next greater element
        }

        // Calculate the total sum of next greater elements
        for (int i = 0; i < n; i++) {
            totalSum = (totalSum + nextGreater[i]) % MOD;
        }

        return (int) totalSum; // Return the result as an integer
    }
}
