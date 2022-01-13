class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int length = nums1.length + nums2.length;
        int[] mergedArray = new int[length];
        
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                mergedArray[i + j] = nums1[i++];
            } else {
                mergedArray[i + j] = nums2[j++];
            }
        }
        
        while (i < nums1.length) {
            mergedArray[i + j] = nums1[i++];
        }
        
        while (j < nums2.length) {
            mergedArray[i + j] = nums2[j++];
        }
        
        if (length % 2 == 1) {
            return mergedArray[length / 2];
        } else {
            return (mergedArray[(length - 1) / 2] + mergedArray[length / 2]) / 2.0;
        }
    }
}
