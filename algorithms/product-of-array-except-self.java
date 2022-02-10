class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] out = new int[nums.length];
        int prod = 1;
        int numZero = 0;
        for (int i = 0; i < nums.length; i++) {
            prod *= nums[i] == 0 ? 1 : nums[i];
            if (nums[i] == 0) {
                numZero++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if ((numZero >= 1 && nums[i] != 0) || numZero > 1) {
                out[i] = 0;
            } else if (nums[i] == 0) {
                out[i] = prod;
            } else {
                out[i] = prod / nums[i];
            }
        }
        return out;
    }
}
