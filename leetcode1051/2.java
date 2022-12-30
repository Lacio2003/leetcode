/**
 * 思路：使用传统的排序至少需要O(nlogn)的时间，可以使用一个数组来存储排序后的结果，从而继续宁对比。
 * 时间复杂度：O(n + c)
 * 空间复杂度：O(n)
 */

class Solution {
    public int heightChecker(int[] heights) {
        // 寻找数组当中的最大值，来确定计数数组的长度
        int max = Arrays.stream(heights).max().getAsInt();
        // 计数数组，计数数组的代表了排序之后的结果
        int[] cnt = new int[max + 1];

        // 将heights中的数组按频数放入到cnt当中。目的是为了确定有几个下标。
        /*
            eg:数组:heights = [1,1,4,2,1,3]
            排序之后的结果：[1,1,1,2,3,4]
            而cnt数组为[0, 3, 1, 1, 1]
            1的位置为3，代表排序之后有3个1。
         */
        for (int h : heights) {
            cnt[h]++;
        }

        // ans记录不同位置的数字的个数
        // idx是排序之前的数组的下标
        int ans = 0, idx = 0;
        // 遍历cnt，即：相当于使用排序之后的数组和排序之前的数组做对比
        for (int i = 1; i <= max; i++) {
            // 遍历cnt中的值。
            // cnt中的值是下标存在的个数。
            for (int j = 0; j < cnt[i]; j++) {
                if (heights[idx] != i) {
                    // 排序之前的结果不等于排序之后的结果
                    ans++;
                }
                idx++;
            }
        }

        return ans;
    }
}