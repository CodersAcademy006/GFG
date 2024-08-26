//User function Template for Java
class Solution 
{ 
    long getSubstringWithEqual012(String str) 
    { 
        // Create a HashMap to store the frequency of the tuple (c0-c1, c0-c2)
        HashMap<String, Integer> map = new HashMap<>();
        
        // Initialize the counts for 0s, 1s, and 2s
        int c0 = 0, c1 = 0, c2 = 0;
        
        // Initialize the count of substrings with equal number of 0s, 1s, and 2s
        long count = 0;
        
        // Initialize the map with the initial condition
        map.put("0#0", 1);
        
        // Traverse the string
        for (int i = 0; i < str.length(); i++) 
        {
            char ch = str.charAt(i);
            
            // Update the counts of 0s, 1s, and 2s
            if (ch == '0') c0++;
            else if (ch == '1') c1++;
            else if (ch == '2') c2++;
            
            // Create the key as a difference of counts between c0-c1 and c0-c2
            String key = (c0 - c1) + "#" + (c0 - c2);
            
            // If this key exists in the map, it means we found a valid substring
            if (map.containsKey(key)) 
            {
                count += map.get(key);
            }
            
            // Update the frequency of the current key
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        
        return count;
    }
}
