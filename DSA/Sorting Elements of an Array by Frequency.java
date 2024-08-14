class Solution {
    // Function to sort the array according to frequency of elements.
    public ArrayList<Integer> sortByFreq(int arr[]) {
        // Step 1: Count the frequency of each element
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create a list of elements to sort
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());

        // Step 3: Sort the list based on frequency and then value
        Collections.sort(entryList, (a, b) -> {
            // Compare frequencies
            if (b.getValue().equals(a.getValue())) {
                return Integer.compare(a.getKey(), b.getKey()); // Compare by value if frequencies are equal
            }
            return Integer.compare(b.getValue(), a.getValue()); // Compare by frequency
        });

        // Step 4: Construct the result array
        ArrayList<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : entryList) {
            int num = entry.getKey();
            int freq = entry.getValue();
            for (int i = 0; i < freq; i++) {
                result.add(num);
            }
        }

        return result;
    }
}
