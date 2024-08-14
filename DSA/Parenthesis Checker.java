class Solution
{
    // Function to check if brackets are balanced or not.
    static boolean ispar(String x)
    {
        Stack<Character> stack = new Stack<>();
        
        // Loop through each character in the string
        for (char ch : x.toCharArray()) {
            // If the character is an opening bracket, push it onto the stack
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            } 
            // If it's a closing bracket
            else if (ch == '}' || ch == ']' || ch == ')') {
                // If stack is empty, it means there's no matching opening bracket
                if (stack.isEmpty()) {
                    return false;
                }
                // Check for matching opening bracket
                char top = stack.pop();
                if ((ch == '}' && top != '{') ||
                    (ch == ']' && top != '[') ||
                    (ch == ')' && top != '(')) {
                    return false;
                }
            }
        }
        // In the end, if the stack is empty, all brackets matched
        return stack.isEmpty();
    }
}
