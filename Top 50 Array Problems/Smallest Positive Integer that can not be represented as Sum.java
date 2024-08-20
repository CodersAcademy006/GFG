class Solution { 
    long smallestpositive(long[] array, int n){ 
        // Sort the array
        Arrays.sort(array);
        
        // Initialize the smallest positive integer that cannot be formed
        long res = 1; 
        
        for (int i = 0; i < n && array[i] <= res; i++) {
            // If array[i] is smaller than or equal to res, then we can form res
            // by including this element. So, we update res to res + array[i].
            res += array[i];
        }
        
        // Return the result
        return res;
    }
} 
