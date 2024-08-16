class Solution {
    public ArrayList<Integer> Ancestors(Node root, int target) {
        ArrayList<Integer> ancestors = new ArrayList<>();
        findAncestors(root, target, ancestors);
        return ancestors;
    }
    
    // Helper function to find ancestors
    private boolean findAncestors(Node root, int target, ArrayList<Integer> ancestors) {
        // Base case: if the current node is null
        if (root == null) {
            return false;
        }

        // If the current node is the target node
        if (root.data == target) {
            return true;
        }

        // Recur for left and right subtree
        boolean leftFound = findAncestors(root.left, target, ancestors);
        boolean rightFound = findAncestors(root.right, target, ancestors);

        // If target is found in either left or right subtree, add current node to ancestors
        if (leftFound || rightFound) {
            ancestors.add(root.data);
            return true;
        }

        // Return false if target is not found in either subtree
        return false;
    }
}
