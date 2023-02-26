/*
    因为温度的范围是[30, 100]之间，我们可以使用一个数组来进行这些温度在数组当中的下标。初始化所有的下标为Integer.MAX_VALUE。
    反向遍历温度数组，寻找比这个元素大的温度并且下标不是Integer的数组的值，并更新当前下标。

    时间复杂度:O(mn)，m是next数组的长度，n是温度数组的长度
    空间复杂度:O(m)
*/
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // 准备变量
        int[] next = new int[101];
        int n = temperatures.length;
        Arrays.fill(next,Integer.MAX_VALUE);
        int[] ans = new int[n];

        // 开始遍历
        for (int i = n - 1; i >= 0; i--) {
            // 寻找比当前元素大元素
            int warmerIndex = Integer.MAX_VALUE;
            for (int j = temperatures[i] + 1; j < 101; j++) {
                // 这一行是寻找比当前元素大的元素并且里当前元素最近的元素
                if (next[j] < warmerIndex) {
                    warmerIndex = next[j];
                }
            }
            // 更新下标值
            ans[i] = warmerIndex < Integer.MAX_VALUE ? warmerIndex - i : 0;
            next[temperatures[i]] = i;
        }

        return ans;
    }
}