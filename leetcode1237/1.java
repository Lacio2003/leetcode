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
    暴力破解，数字最大是1000，可以从1000一个一个的试试。
    使用双重for循环

    时间复杂度:O(1000 * 1000)
    空间复杂度:O(1)
*/
class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        // 定义变量
        List<List<Integer>> ans = new ArrayList<>();

        // 开始遍历
        for (int x = 1; x <= 1000; x++) {
            for (int y = 1; y <= 1000; y++) {
                if (customfunction.f(x, y) == z) {
                    // 符合题目要求
                    List<Integer> cur = new ArrayList<>();
                    cur.add(x);
                    cur.add(y);

                    ans.add(cur);
                }
            }
        }

        return ans;
    }
}