class Tree {
    ArrayList<Integer> postOrder(Node node) {
        ArrayList<Integer> result = new ArrayList<>();
        if (node == null) return result;

        Stack<Node> stack = new Stack<>();
        Node current = node;
        Node lastVisited = null;

        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left; // move to the left child
            } else {
                Node peekNode = stack.peek();
                // If the right child is null or already visited
                if (peekNode.right == null || peekNode.right == lastVisited) {
                    result.add(peekNode.data);
                    lastVisited = stack.pop(); // pop the node and mark it as visited
                } else {
                    current = peekNode.right; // move to the right child
                }
            }
        }
        return result;
    }
}
