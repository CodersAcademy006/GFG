class Solution {
    static int canRepresentBST(int arr[], int N) {
        // Edge case: Empty array or single element array
        if (N <= 0) return 1;
        if (N == 1) return 1;

        Stack<Integer> stack = new Stack<>();
        int root = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            // If the current element is less than the root, it's not a valid BST
            if (arr[i] < root) return 0;

            // If the current element is greater than the stack's top, pop elements
            while (!stack.isEmpty() && arr[i] > stack.peek()) {
                root = stack.pop();
            }

            // Push the current element to stack
            stack.push(arr[i]);
        }

        return 1;
    }
}
