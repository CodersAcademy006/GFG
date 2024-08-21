class Solution{
    int findFrequency(int Arr[], int X){
        // Initialize frequency counter
        int frequency = 0;
        
        // Traverse the array and count occurrences of X
        for(int i = 0; i < Arr.length; i++){
            if(Arr[i] == X){
                frequency++;
            }
        }
        
        // Return the frequency of X
        return frequency;
    }
}
