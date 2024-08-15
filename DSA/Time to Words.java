class Solution {
    public String timeToWord(int H, int M) {
        String[] numbers = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                             "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
                             "nineteen", "twenty", "twenty one", "twenty two", "twenty three", "twenty four", "twenty five",
                             "twenty six", "twenty seven", "twenty eight", "twenty nine" };
        
        if (M == 0) {
            return numbers[H] + " o' clock";
        } else if (M == 15) {
            return "quarter past " + numbers[H];
        } else if (M == 30) {
            return "half past " + numbers[H];
        } else if (M == 45) {
            return "quarter to " + numbers[(H % 12) + 1];
        } else if (M < 30) {
            return numbers[M] + (M == 1 ? " minute" : " minutes") + " past " + numbers[H];
        } else {
            return numbers[60 - M] + (60 - M == 1 ? " minute" : " minutes") + " to " + numbers[(H % 12) + 1];
        }
    }
}
