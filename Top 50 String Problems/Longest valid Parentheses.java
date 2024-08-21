class Solution{
    static int maxLength(String S){
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // Initialize with -1 for base reference
        int maxLen = 0;

        for(int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);

            if (ch == '(') {
                stack.push(i);
            } else {
                stack.pop();

                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }

        return maxLen;
    }
}
