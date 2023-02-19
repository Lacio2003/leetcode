/*
    双指针思想
    一个指针first指向nums1，另一个指针second指向nums2。
        nums1[first] == nums2[second], return nums1[first]
        nums1[first] > nums2[second], second++
        nums1[first] < nums2[second], first++

    时间复杂度:O(n)
    空间复杂度:O(1)
*/
class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        // 准备变量
        int first = 0, second = 0;

        // 开始遍历
        while (first < nums1.length && second < nums2.length) {
            // nums1[first] == nums2[second], return nums1[first]
            if (nums1[first] == nums2[second]) {
                return nums1[first];
            } else if (nums1[first] > nums2[second]) {
                // nums1[first] > nums2[second], second++
                second++;
            } else {
                // nums1[first] < nums2[second], first++
                first++;
            }
        }

        return -1;
    }
}