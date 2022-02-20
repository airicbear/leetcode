class Solution {
    public int removeDuplicates(int[] nums) {
        int last = Integer.MIN_VALUE;
        int ptr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != last) {
                last = nums[i];
                nums[ptr] = last;
                ptr++;
            }
        }
        return ptr;
    }
}
