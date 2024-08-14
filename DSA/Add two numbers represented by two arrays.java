class Solution {
    String calc_Sum(int arr1[], int arr2[]) {
        StringBuilder result = new StringBuilder();
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int carry = 0;

        // Add digits from both arrays
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;

            if (i >= 0) {
                sum += arr1[i];
                i--;
            }
            if (j >= 0) {
                sum += arr2[j];
                j--;
            }

            result.append(sum % 10); // Append the last digit of the sum
            carry = sum / 10; // Calculate the carry
        }

        // The result is in reverse order, so reverse it
        return result.reverse().toString();
    }
}
