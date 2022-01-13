// Credits to https://youtu.be/y2BD4MJqV20
class Solution {
    public String longestPalindrome(String s) {
        int lo = 0;
        int hi = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // The longest palindrome from expansion for odd and even cases
            int len = Math.max(expansionLength(s, i, i), expansionLength(s, i, i+1));
            
            if (len > hi - lo) {
                lo = i - ((len - 1) / 2);
                hi = i + (len / 2);
            }
        }
        
        return s.substring(lo, hi + 1);
    }
    
    public int expansionLength(String s, int left, int right) {
        if (left > right) {
            return 0;
        }
        
        // While the expansion maintains a palindrome
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        
        return right - left - 1;
    }
}
