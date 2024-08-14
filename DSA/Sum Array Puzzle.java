class Solution {
    public void sumArray(List<Integer> arr) {
        int totalSum = 0;

        // Step 1: Calculate the total sum of the array
        for (int num : arr) {
            totalSum += num;
        }

        // Step 2: Modify the array to contain the sum of all elements except itself
        for (int i = 0; i < arr.size(); i++) {
            arr.set(i, totalSum - arr.get(i));
        }
    }
}
