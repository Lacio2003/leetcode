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
    双指针，一个指针指向1，另一个指针指向1000，然后根据f函数进行判断和收拢
    时间复杂度:O(n)
    空间复杂度:O(1)
*/
class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        // 定义变量
        int left = 1, right = 1000;
        List<List<Integer>> ans = new ArrayList<>();

        // 开始遍历
        while (left <= 1000 && right > 0) {
            // 获取运算结果
            int res = customfunction.f(left, right);
            if (res == z) {
                // 等于结果
                List<Integer> first = new ArrayList<>();
                first.add(left);
                first.add(right);
                ans.add(first);

                left++;
                right--;
            } else if (res > z){
                right--;
            } else {
                left++;
            }
        }

        return ans;
    }
}