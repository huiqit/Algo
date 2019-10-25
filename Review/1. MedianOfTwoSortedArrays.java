class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int len = nums1.length + nums2.length;
        if(len % 2 == 0) {
            // the final result is 第k大 + 第(k+1)大的 / 2
            return helper(nums1, nums2, 0, 0, len/2, true);
        } else {
            return helper(nums1, nums2, 0, 0, len/2+1, false);
        }
    }
    private double helper(int[] nums1, int[] nums2, int aleft, int bleft, int k, boolean next) {
        // base case 一定要先判断有没有越界！！！
        if(aleft >= nums1.length) {
            if(next) {  
                return (nums2[bleft + k - 1] + nums2[bleft + k])/(double)2;
            } else {
                return nums2[bleft + k - 1];
            }
        }
        if(bleft >= nums2.length) {
            if(next) {
                return (nums1[aleft + k - 1] + nums1[aleft + k]) / (double)2;
            } else {
                return nums1[aleft + k - 1];
            }
        }
        if(k == 1) {
            if(next) {
                // a[aleft], a[aleft+1], b[bleft], b[bleft+1] 这4个数中最小的那2个
                // ❌return (nums1[aleft] + nums2[bleft])/(double)2; //还要找到下一个大的，返回平均值 //DOUBLE!!!!!!!!!!!!!!
                if(nums1[aleft] < nums2[bleft]) {
                    return (nums1[aleft] + Math.min(nums1[aleft+1], nums2[bleft])) / (double)2;
                } else {
                    return (nums2[bleft] + Math.min(nums1[aleft], nums2[bleft+1])) / (double)2;
                }
            } else {
                return Math.min(nums1[aleft], nums2[bleft]);
            }
        }
        // recursion rule
        int amid = aleft + k/2 - 1; 
        int bmid = bleft + k/2 - 1;
        int aval = amid >= nums1.length ? Integer.MAX_VALUE : nums1[amid];
        int bval = bmid >= nums2.length ? Integer.MAX_VALUE : nums2[bmid];
        if(aval < bval) {
            return helper(nums1, nums2, amid+1, bleft, k-k/2, next);
        } else {
            return helper(nums1, nums2, aleft, bmid+1, k-k/2, next);
        }
    }
}


