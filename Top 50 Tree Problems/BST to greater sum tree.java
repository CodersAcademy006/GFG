class Solution {
    
    // Helper class to keep track of the accumulated sum
    private static class Accumulator {
        int sum = 0;
    }
    
    public static void transformTree(Node root) {
        Accumulator acc = new Accumulator();
        transformTreeHelper(root, acc);
    }
    
    // Recursive function to perform reverse in-order traversal
    private static void transformTreeHelper(Node node, Accumulator acc) {
        if (node == null) return;
        
        // Traverse the right subtree first (greater values)
        transformTreeHelper(node.right, acc);
        
        // Update the current node's value
        int oldValue = node.data;
        node.data = acc.sum;
        
        // Update the accumulated sum
        acc.sum += oldValue;
        
        // Traverse the left subtree
        transformTreeHelper(node.left, acc);
    }
}
