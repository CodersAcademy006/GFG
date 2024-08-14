class Solution {
    static int countSpecials(int arr[], int k) {
        // Step 1: Count the frequency of each element
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Calculate floor(n/k)
        int n = arr.length;
        int targetFrequency = n / k; // Using integer division to get floor(n/k)

        // Step 3: Count how many elements have the target frequency
        int count = 0;
        for (int freq : frequencyMap.values()) {
            if (freq == targetFrequency) {
                count++;
            }
        }

        return count; // Return the count of elements with the target frequency
    }
}
