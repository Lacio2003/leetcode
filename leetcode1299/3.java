/**
 * 思路：构造一个新的数组存储答案。
 * 时间复杂度:O(n)
 * 空间复杂度:O(1)，不算返回答案的数组
 */

class Solution {
    public int[] replaceElements(int[] arr) {
        // 为了方便使用将长度存储在变量n当中
        int n = arr.length;
        // 存储最后的答案
        int[] ans = new int[n];
        // 最后一个位置为-1
        ans[n - 1] = -1;
        // 逆序遍历
        for (int i = n - 2; i >= 0; i--) {
            ans[i] = Math.max(ans[i + 1], arr[i + 1]);
        }

        return ans;
    }
}