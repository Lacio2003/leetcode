/*
    利用数学求根公式
    website:https://leetcode.cn/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/solutions/574804/jian-zhi-offer-57-ii-he-wei-s-de-lian-xu-t85z/

    时间复杂度:O(n)
    空间复杂度:O(1)
*/
class Solution {
    public int[][] findContinuousSequence(int target) {
        // 定义容器
        List<int[]> ans = new ArrayList<>();

        // 开始遍历
        int left = 1;
        double right = 2.0;

        while (left < right) {
            // 根据公式求出右边界
            right = (-1 + Math.sqrt(1 + 4 * (2 * target + (long)left * left - left))) * 0.5;
            // 对边界进行判断
            if (left < right && right == (int)right) {
                int[] cur = new int[(int)right - left + 1];
                for (int i = 0; i < cur.length; i++) {
                    cur[i] = i + left;
                }
                ans.add(cur);
            }
            left++;
        }

        return ans.toArray(new int[ans.size()][]);
    }
}