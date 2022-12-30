/**
 * 思路：计算每一个数字的二进制1的个数。让这个数字乘以100000再加上原来的数字。存入
 * 数组当中。之后再对数组进行排序。最好将里面的元素除以100000进行还原。
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)，当然也可以使用原来的数组arr进行存储，降低时间复杂度。
 */
class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        int[] map = new int[n];
        for (int i = 0; i < n; i++) {
            // 这里不能除以10000。当arr[i]的数字是10000的时候。那么map[i] = 60000
            // 最后在除以10000的时候结果等于0。是错误的。
            map[i] = Integer.bitCount(arr[i]) * 10001 + arr[i];
        }

        // 对map进行排序
        Arrays.sort(map);

        // 还原原来的数字
        for (int i = 0; i < n; i++) {
            map[i] %= 10001;
        }
        return map;
    }
}