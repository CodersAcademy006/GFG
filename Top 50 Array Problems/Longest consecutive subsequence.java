class Solution
{   
    // arr[] : the input array
    // N : size of the array arr[]
    
    //Function to return length of longest subsequence of consecutive integers.
    static int findLongestConseqSubseq(int arr[], int N)
    {
        // Using a HashSet to store elements
        Set<Integer> set = new HashSet<>();
        
        // Adding all elements to the set
        for (int num : arr) {
            set.add(num);
        }
        
        int longestStreak = 0;
        
        // Iterating through the array
        for (int num : arr) {
            // If num is the starting number of a consecutive sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                
                // Count consecutive numbers
                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                
                // Update the longest streak
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        
        return longestStreak;
    }
}
