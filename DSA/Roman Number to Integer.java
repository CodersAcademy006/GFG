import java.util.HashMap;

class Solution {
    // Finds decimal value of a given roman numeral
    public int romanToDecimal(String str) {
        // Mapping of Roman numerals to their decimal values
        HashMap<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);
        
        // Initialize total value
        int total = 0;
        
        // Iterate over the string
        for (int i = 0; i < str.length(); i++) {
            // Get the value of the current Roman numeral
            int currentVal = romanValues.get(str.charAt(i));
            
            // If the next numeral exists and its value is larger, subtract current value
            if (i + 1 < str.length() && currentVal < romanValues.get(str.charAt(i + 1))) {
                total -= currentVal;
            } else {
                // Otherwise, add the current value
                total += currentVal;
            }
        }
        
        return total;
    }
}
