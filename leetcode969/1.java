/*
    如何完成煎饼反转
        双指针就可以完成
    如何确定每一次需要反转哪里
        可以参考冒泡排序的思想，每一次找到最大值，换到末尾。如果要交换的值在0，位置，那么就可以直接0到倒数的位置，如果不是需要先反转[0,那个数字的位置]。

    为了更快的寻找到数字，可以使用哈希表，将数字存储起来。
    website:https://leetcode.cn/problems/pancake-sorting/solutions/1275785/gong-shui-san-xie-mou-pao-pai-xu-yun-yon-c0mn/
    时间复杂度:O(n^2)
    空间复杂度:O(n)
*/
class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        // 准备变量
        int n = arr.length;
        int[] hash = new int[n + 10];
        List<Integer> ans = new ArrayList<>();

        // 将数组里面的元素的位置存储到哈希表里面
        for (int i = 0; i < n; i++) {
            hash[arr[i]] = i;
        }

        // 开始对数组进行排序
        for (int i = n; i > 0; i--) {
            // 获取最大值的位置
            int curMax = hash[i];
            // 查看最大值是否在当前位置上
            if (curMax == i - 1) {
                continue;
            }
            // 对最大值不在开头位置进行处理
            if (curMax != 0) {
                // 将最大值反转到开头
                ans.add(curMax + 1);
                reverse(arr, 0, curMax, hash);
            }
            // 反转[0, 当前位置]
            ans.add(i);
            reverse(arr, 0, i - 1, hash);
        }

        return ans;
    }

    private void reverse(int[] arr, int left, int right, int[] hash) {
        while (left < right) {
            // 修改哈希表
            hash[arr[left]] = right;
            hash[arr[right]] = left;

            // 交换数字
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }
}