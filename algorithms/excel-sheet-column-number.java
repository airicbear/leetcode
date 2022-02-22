class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            result += Math.pow(26, columnTitle.length() - i - 1) * (columnTitle.charAt(i) - 64);
        }
        
        return result;
    }
}
