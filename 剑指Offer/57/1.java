/*
    滑动窗口
    当窗口里面的元素等于target的时候，进行记录。
    当窗口里面的元素大于target的时候，窗口进行缩小
    当窗口里面的元素小于target的时候，窗口进行扩大

    时间复杂度:O(n)
    空间复杂度:O(1)
*/
class Solution {
    public int[][] findContinuousSequence(int target) {
        // 定义容器
        List<int[]> ans = new ArrayList<>();

        // 开始遍历
        // left和right表示滑动窗口的左右边界
        int left = 1, right = 1;
        // 表示滑动窗口内的值
        int sum = 1;
        while (right < target) {
            if (sum < target) {
                ++right;
                sum += right;
            } else if (sum > target) {
                sum -= left;
                left++;
            } else {
                // 记录滑动窗口里面的元素
                int[] cur = new int[right - left + 1];
                for (int i = 0; i < cur.length; i++) {
                    cur[i] = i + left;
                }
                ans.add(cur);

                sum += ++right;
            }
        }
        
        // 返回答案
        return ans.toArray(new int[ans.size()][]);
    }
}