class Solution {
    // Function to calculate the span of stock’s price for all n days.
    public static int[] calculateSpan(int price[], int n) {
        // Stack to store the indices of the prices
        Stack<Integer> stack = new Stack<>();
        int[] span = new int[n];

        // Process each price
        for (int i = 0; i < n; i++) {
            // Pop elements from stack while the stack is not empty and the
            // current price is greater than the price at the index stored at the top of the stack
            while (!stack.isEmpty() && price[i] >= price[stack.peek()]) {
                stack.pop();
            }

            // If stack is empty, then this is the highest price so far
            if (stack.isEmpty()) {
                span[i] = i + 1; // Span is the whole range from 0 to i
            } else {
                // Otherwise, span is the difference between the current index
                // and the index of the last higher price
                span[i] = i - stack.peek();
            }

            // Push the current index onto the stack
            stack.push(i);
        }

        return span;
    }
}
