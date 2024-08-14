class Solution {
    static ArrayList<Integer> getStar(int[] arr) {
        ArrayList<Integer> starElements = new ArrayList<>();
        
        // Initialize the maximum element with the last element
        int maxFromRight = arr[arr.length - 1];
        starElements.add(maxFromRight); // Last element is always a star
        
        // Iterate from second last to the first element
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > maxFromRight) {
                starElements.add(arr[i]); // Add current element as it is a star
                maxFromRight = arr[i]; // Update the maximum
            }
        }
        
        // Reverse the list to maintain the original order of star elements
        Collections.reverse(starElements);
        
        return starElements;
    }
}
