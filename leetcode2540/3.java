/*
    二分查找

    时间复杂度:O(nlogn)
    空间复杂度:O(1)
*/
class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        for (int e : nums1) {
            // 在nums2进行二分查找
            int res = binarySearch(nums2, e);
            if (res == e) {
                return res;
            }
        }

        return -1;
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                return target;
            } else if (nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}