// User function Template for Java
class Solution {
    int isdivisible7(String num) {
        // Initialize remainder
        int remainder = 0;
        
        // Traverse each character in the string
        for (int i = 0; i < num.length(); i++) {
            // Extract the current digit from the string
            int digit = num.charAt(i) - '0';
            
            // Update the remainder (similar to long division)
            remainder = (remainder * 10 + digit) % 7;
        }
        
        // If the remainder is 0, the number is divisible by 7
        return (remainder == 0) ? 1 : 0;
    }
}
