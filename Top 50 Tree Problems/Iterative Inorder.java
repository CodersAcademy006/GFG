class Solution
{
    // Return a list containing the inorder traversal of the given tree
    ArrayList<Integer> inOrder(Node root)
    {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node current = root;

        while (current != null || !stack.isEmpty()) {
            // Reach the left most Node of the current Node
            while (current != null) {
                stack.push(current);
                current = current.left; // move to left child
            }

            // Current must be null at this point
            current = stack.pop();
            result.add(current.data); // Add the node data to the result

            // We have visited the node and its left subtree. Now, it's right subtree's turn
            current = current.right; // move to right child
        }

        return result;
    }
}
