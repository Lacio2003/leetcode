/**
 * 思路：由题意可得：两个数组中的元素如果完全一样的话，arr一定可以转化为target，所以，只需要检查两个数组中的元素是否是一样的。
 * 对target和arr进行排序，然后遍历检查每一个位置是否相等即可。因为如果两个数组完全是一样的，那么排序之后的结果肯定也是一样的。
 * 时间复杂度：O(logn *  n)
 * 空间复杂度：O(1)
 */
class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(target, arr);
    }
}