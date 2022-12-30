/**
 * 思路：按照题目要求，暴力破解。对数组按照数字当中1的个数排序即可。
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(n)
 */
class Solution {
    public int[] sortByBits(int[] arr) {
        // 因为使用基本数组类型无法进行排序，所以要将arr的数据元素存储到list集合
        // 当中，然后排序。
        List<Integer> storge = new ArrayList<>();
        for (int e : arr) {
            storge.add(e);
        }

        // 对list集合按照二进制表示中1的个数进行排序
        storge.sort((a, b)->{
            int countA = Integer.bitCount(a), countB = Integer.bitCount(b);
            return countA != countB ? countA - countB : a - b;
        });

        // 将list集合转换成数组，返回答案
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = storge.get(i);
        }

        return ans;
    }
}