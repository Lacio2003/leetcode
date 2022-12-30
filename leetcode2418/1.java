/**
 * 思路:直接按照题目暴力破解。提前将heights和names中的映射存放在hash表当中。对heights进行排序，然后按照映射输出即可。
 * 时间复杂度:O(nlogn + O(n) + O(n))
 * 空间复杂度:O(n)
 */

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        // 将names中的元素和heights中的元素的对应关系记录下来
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(heights[i], names[i]);
        }

        // 对heights进行排序
        Arrays.sort(heights);

        // 利用对应关系，将排序后的名字输出
        for (int i = 0; i < n; i++) {
            names[i] = map.get(heights[n - 1 - i]);
        }

        return names;
    }
}