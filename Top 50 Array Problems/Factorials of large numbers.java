class Solution {
    static ArrayList<Integer> factorial(int N) {
        ArrayList<Integer> result = new ArrayList<>();
        
        // Initialize result as 1 because 1! = 1
        result.add(1);
        
        // Multiply numbers from 2 to N with the result
        for (int x = 2; x <= N; x++) {
            multiply(result, x);
        }
        
        // The result is in reverse order, so reverse it before returning
        Collections.reverse(result);
        
        return result;
    }
    
    static void multiply(ArrayList<Integer> result, int x) {
        int carry = 0;
        
        // Multiply x with every digit in the result
        for (int i = 0; i < result.size(); i++) {
            int prod = result.get(i) * x + carry;
            result.set(i, prod % 10);  // Update the digit
            carry = prod / 10;  // Calculate the carry
        }
        
        // Handle remaining carry
        while (carry > 0) {
            result.add(carry % 10);
            carry /= 10;
        }
    }
}
