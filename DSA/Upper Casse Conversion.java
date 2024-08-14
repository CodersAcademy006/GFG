//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            while(t-->0)
                {
                    String str = br.readLine();
                    Solution ob = new Solution();
                    System.out.println(ob.transform(str));
                }
        }
}
// } Driver Code Ends

class Solution {
    public String transform(String s) {
        // Split the string into words based on spaces
        String[] words = s.split(" ");
        
        // StringBuilder to accumulate the result
        StringBuilder result = new StringBuilder();
        
        // Iterate over each word
        for (String word : words) {
            if (!word.isEmpty()) {
                // Capitalize the first letter and append the rest of the word
                result.append(Character.toUpperCase(word.charAt(0)));
                result.append(word.substring(1));
            }
            // Add a space after each word
            result.append(" ");
        }
        
        // Remove the trailing space and return the result
        return result.toString().trim();
    }
}