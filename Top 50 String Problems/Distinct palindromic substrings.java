class Solution 
{ 
    int palindromeSubStrs(String str) { 
        int n = str.length();
        Set<String> uniquePalindromes = new HashSet<>();
        
        // Expand around center approach
        for (int center = 0; center < 2 * n - 1; center++) {
            int left = center / 2;
            int right = left + center % 2;
            
            // Expand around center as long as the substring is a palindrome
            while (left >= 0 && right < n && str.charAt(left) == str.charAt(right)) {
                uniquePalindromes.add(str.substring(left, right + 1));
                left--;
                right++;
            }
        }
        
        return uniquePalindromes.size();
    }
}
