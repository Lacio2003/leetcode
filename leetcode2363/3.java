/**
 * 思路：使用哈希表来存储数组中的元素既可。
 * 时间复杂度:O(n + m)
 * 空间复杂度:O(n + m)
*/
class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        // 根据题目要求使用可以自动排序的TreeMap
        Map<Integer, Integer> map = new TreeMap<>();

        // 遍历items1和items2来存储其中的元素
        for (int[] items : items1) {
            map.put(items[0], items[1]);
        }

        for (int[] items : items2) {
            map.put(items[0], map.getOrDefault(items[0], 0) + items[1]);
        }

        // 存储最后的答案
        List<List<Integer>> ans = new ArrayList<>();
        // lambda表达式
        map.forEach((key, value)->{
            ans.add(Arrays.asList(key, value));
        });

        return ans;
    }
}