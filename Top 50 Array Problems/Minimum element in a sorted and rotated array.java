class Solution
{
    int findMin(int arr[], int n)
    {
        int low = 0;
        int high = n - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // If mid element is greater than the high element, then the minimum is in the right half
            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } 
            // Else the minimum is in the left half (including mid)
            else {
                high = mid;
            }
        }

        // Low now points to the minimum element
        return arr[low];
    }
}
