class Tree {

    // Helper function to check if the tree is balanced and return the height
    private Result checkBalanced(Node root) {
        if (root == null) {
            return new Result(true, 0);
        }
        
        Result left = checkBalanced(root.left);
        Result right = checkBalanced(root.right);
        
        boolean isBalanced = left.isBalanced && right.isBalanced 
                && Math.abs(left.height - right.height) <= 1;
        
        int height = Math.max(left.height, right.height) + 1;
        
        return new Result(isBalanced, height);
    }

    // Main function to check if the tree is balanced
    public boolean isBalanced(Node root) {
        return checkBalanced(root).isBalanced;
    }

    // Inner class to hold the result of balance check and height
    private class Result {
        boolean isBalanced;
        int height;
        
        Result(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
}
