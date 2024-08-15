class Tree
{
    // Return a list containing the Preorder traversal of the given tree
    ArrayList<Integer> preOrder(Node root)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            result.add(current.data); // Visit the root

            // Push right child first so that left is processed next
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }

        return result;
    }
}
