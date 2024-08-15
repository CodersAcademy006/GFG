class Solution {
    public Node sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }
    
    private Node buildBST(int[] nums, int left, int right) {
        if (left > right) {
            return null; // Base case: if the left index exceeds the right, return null
        }
        
        // Find the middle index
        int mid = left + (right - left) / 2;
        
        // Create a new node with the middle element
        Node root = new Node(nums[mid]);
        
        // Recursively build the left and right subtrees
        root.left = buildBST(nums, left, mid - 1); // Left subtree
        root.right = buildBST(nums, mid + 1, right); // Right subtree
        
        return root; // Return the constructed BST
    }
}
