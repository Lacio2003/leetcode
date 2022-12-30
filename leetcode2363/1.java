/**
 * 思路：根据题目要求，可以使用频数数组来存储元素，然后从频数数组取出元素既可
 * 时间复杂度:O(n)
 * 空间复杂度:O(1)
 */
class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        // 使用频数数组的下标存储values，里面的值存储weights
        int[] frequent = new int[1001];

        // 遍历items1和items2来获取value和weights
        for (int[] e : items1) {
            frequent[e[0]] += e[1];
        }
        for (int[] e : items2) {
            frequent[e[0]] += e[1];
        }

        // 存储最后的答案
        List<List<Integer>> ans = new ArrayList<>();
        // 遍历频数数组
        for (int i = 0; i < 1001; i++) {
            if (frequent[i] != 0) {
                List<Integer> once = new ArrayList<>();
                once.add(i);
                once.add(frequent[i]);
                ans.add(once);
            }
        }

        return ans;
    }
}