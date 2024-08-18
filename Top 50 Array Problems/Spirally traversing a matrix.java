class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    public ArrayList<Integer> spirallyTraverse(int matrix[][]) {
        ArrayList<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // Traverse from left to right along the top row.
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;  // Move the top boundary down.

            // Traverse from top to bottom along the right column.
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;  // Move the right boundary left.

            if (top <= bottom) {
                // Traverse from right to left along the bottom row.
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;  // Move the bottom boundary up.
            }

            if (left <= right) {
                // Traverse from bottom to top along the left column.
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;  // Move the left boundary right.
            }
        }

        return result;
    }
}
