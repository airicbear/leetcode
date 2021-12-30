class Solution {
    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }
        if (x < 0 || x % 10 == 0 || x == Integer.MAX_VALUE) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        
        int buf = x;
        int flipped = 0;
        int power = (int) Math.log10(x);
        while (buf > 0) {
            flipped += (buf % 10) * Math.pow(10, power);
            buf /= 10;
            power--;
        }
        return flipped == x;
    }
}
