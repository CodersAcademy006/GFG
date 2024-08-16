class Solution {
    public ArrayList<Integer> boundary(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        
        if (root == null) return result;
        
        // Special case for single node
        if (root.left == null && root.right == null) {
            result.add(root.data);
            return result;
        }
        
        // Add root node to the result
        result.add(root.data);
        
        // Add left boundary nodes excluding leaf nodes
        addLeftBoundary(root.left, result);
        
        // Add leaf nodes
        addLeaves(root, result);
        
        // Add right boundary nodes in reverse order
        addRightBoundary(root.right, result);
        
        return result;
    }
    
    // Function to add left boundary nodes
    private void addLeftBoundary(Node node, ArrayList<Integer> result) {
        Node current = node;
        while (current != null) {
            // Only add to boundary if node is not a leaf
            if (current.left != null || current.right != null) {
                result.add(current.data);
            }
            if (current.left != null) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
    }
    
    // Function to add leaf nodes
    private void addLeaves(Node node, ArrayList<Integer> result) {
        if (node == null) return;
        
        if (node.left == null && node.right == null) {
            result.add(node.data);
        } else {
            addLeaves(node.left, result);
            addLeaves(node.right, result);
        }
    }
    
    // Function to add right boundary nodes in reverse order
    private void addRightBoundary(Node node, ArrayList<Integer> result) {
        Node current = node;
        Stack<Integer> stack = new Stack<>();
        
        while (current != null) {
            // Only add to stack if node is not a leaf
            if (current.left != null || current.right != null) {
                stack.push(current.data);
            }
            if (current.right != null) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        
        // Add nodes from stack to result in reverse order
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
    }
}
