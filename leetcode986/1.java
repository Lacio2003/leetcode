/*
    使用双指针
    使用双指针求两个指针的交集，左指针指向的是两个区间较大的左边界，右指针指向的是较小的右边界
    右边界较小的指针不移动，因为它不可能会和后面的重合。

    时间复杂度:O(n)
    空间复杂度:O(1)
*/
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        // 准备容器
        List<int[]> ans = new ArrayList<>();

        // 开始遍历
        int pFirst = 0, pSecond = 0;
        while (pFirst < firstList.length && pSecond < secondList.length) {
            // 求取左边界有边界
            int left = Math.max(firstList[pFirst][0], secondList[pSecond][0]);
            int right = Math.min(firstList[pFirst][1], secondList[pSecond][1]);

            if (left <= right) {
                // 说明有交集
                ans.add(new int[]{left, right});
            }
            if (firstList[pFirst][1] < secondList[pSecond][1]) {
                // 说明secondList对应的区间是高位
                pFirst++;
            } else {
                pSecond++;
            }
        }

        return ans.toArray(new int[0][0]);
    }
}