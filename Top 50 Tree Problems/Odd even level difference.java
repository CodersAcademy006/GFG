class Solution {
    public int getLevelDiff(Node root) {
        return calculateLevelDiff(root, 0); // Start with level 0
    }
    
    private int calculateLevelDiff(Node node, int level) {
        if (node == null) {
            return 0; // Base case: if the node is null, return 0
        }

        // If the level is even, add the node's value; if odd, subtract it
        int currentLevelValue = (level % 2 == 0) ? node.data : -node.data;

        // Recursively calculate for the left and right subtrees, increasing the level
        int leftDiff = calculateLevelDiff(node.left, level + 1);
        int rightDiff = calculateLevelDiff(node.right, level + 1);

        // Return the total difference at this level
        return currentLevelValue + leftDiff + rightDiff;
    }
}
