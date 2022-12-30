/**
 * 思路：由题目可以知道，只要一个数字出现的频率是奇数，那么就不能划分成数对。
 * 所以，可以使用频数数组或者哈希表，存储对应的数字的频率，然后判断就可以了。
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
class Solution {
    public boolean divideArray(int[] nums) {
        // 频数数组
        int[] frequent = new int[501];

        // 将nums中的元素读入到频数数组当中
        for (int e : nums) {
            frequent[e]++;
        }

        // 遍历频数数组，判断是否有奇数个的元素
        for (int e : frequent) {
            // 存在奇数个元素，说明不能组成数对。
            if ((e & 1) == 1) {
                return false;
            }
        }

        return true;
    }
}