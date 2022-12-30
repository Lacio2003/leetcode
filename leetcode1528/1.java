/**
 * 思路：暴力破解。
 * 1.创造一个char[]数组存储排列之后的字符串元素
 * 2.遍历s和indices，将s中的字符放到对应的位置上
 * 3.将char数组转换为字符串并且返回
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */

class Solution {
    public String restoreString(String s, int[] indices) {
        // 为了方便使用，将s的长度存储在变量s当中
        int n = s.length();
        // 存储排列之后的字符串
        char[] ans = new char[n];

        for (int i = 0; i < n; i++) {
            // 根据要求，将字符放到对应的位置上
            ans[indices[i]] = s.charAt(i);
        }

        return String.valueOf(ans);
    }
}