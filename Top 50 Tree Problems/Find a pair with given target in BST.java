class Solution {
    
    // Main function to check if there is a pair with given sum
    public int isPairPresent(Node root, int target) {
        HashSet<Integer> set = new HashSet<>();
        return isPairPresentHelper(root, target, set) ? 1 : 0;
    }

    // Helper function to perform in-order traversal and check for the pair
    private boolean isPairPresentHelper(Node root, int target, HashSet<Integer> set) {
        if (root == null) {
            return false;
        }
        
        // Recursively check left subtree
        if (isPairPresentHelper(root.left, target, set)) {
            return true;
        }
        
        // Check if the complement of the current node's value exists in the set
        if (set.contains(target - root.data)) {
            return true;
        }
        
        // Add the current node's value to the set
        set.add(root.data);
        
        // Recursively check right subtree
        return isPairPresentHelper(root.right, target, set);
    }
}
