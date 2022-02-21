class Solution {
    public int[] plusOne(int[] digits) {
        int j = digits.length - 1;

        while (digits[j] + 1 > 9 && j > 0) {
            digits[j] = 0;
            j--;
        }
        
        digits[j]++;
        
        if (digits[j] == 10) {
            int[] buf = new int[digits.length + 1];
            buf[0] = 1;
            buf[1] = 0;
            
            for (int i = 2; i < buf.length; i++) {
                buf[i] = digits[i - 1];
            }
            
            return buf;
        }

        return digits;
    }
}
