/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 * class CustomFunction {
 *     // Returns f(x, y) for any given positive integers x and y.
 *     // Note that f(x, y) is increasing with respect to both x and y.
 *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 *     public int f(int x, int y);
 * };
 */

/*
    二分查找的方法，固定其中一个数字，利用二分查找来找另一个数字
    时间复杂度:O(nlogn)
    空间复杂度:O(1)
*/
class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        // 准备容器
        List<List<Integer>> ans = new ArrayList<>();

        // 开始遍历
        for (int x = 1; x <= 1000; x++) {
            int left = 1, right = 1000;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                int res = customfunction.f(x, mid);
                if (res == z) {
                    // 说明相等
                    List<Integer> list = new ArrayList<>();
                    list.add(x);
                    list.add(mid);
                    ans.add(list);
                    break;
                } else if (res > z) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return ans;
    }
}