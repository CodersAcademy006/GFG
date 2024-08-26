//User function Template for Java

class Solution {
    public List<List<String>> Anagrams(String[] string_list) {
        // Map to store groups of anagrams
        HashMap<String, List<String>> map = new HashMap<>();
        
        // Traverse through each string in the array
        for (String word : string_list) {
            // Sort the characters of the string to create a key
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            
            // Add the word to the corresponding anagram group
            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }
            map.get(sortedWord).add(word);
        }
        
        // Return the list of anagram groups
        return new ArrayList<>(map.values());
    }
}
