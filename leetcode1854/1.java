/**
 * 思路：暴力破解。
 * 思路：
 * 1)计算每一个年份的出生的人数。
 * 2)使用哈希表进行排序。(先按人数，再按大小)
 * 3)返回结果

 * 时间复杂度:O(O(n) + O(n^2) + O(nlogn))
 * 空间复杂度:O(2 * n)
 */
class Solution {
    public int maximumPopulation(int[][] logs) {
        // 存储每一个年份以及这一年出生的人数
        Map<Integer, Integer> map = new HashMap<>();
        // 存储每一个年份
        List<Integer> years = new ArrayList<>();

        // 计算每一年的年份以及出生的人数
        for (int[] log : logs) {
            years.add(log[0]);
            map.put(log[0], countYear(logs, log[0]));
        }

        // 对年份进行排序
        // 使用lambda表达式
        Collections.sort(years, (a, b)->{
            int countA = map.get(a), countB = map.get(b);
            // 先按当前年份的出生人数从大到小进行排序
            // 出生人数相同，则按年份大小进行看排序
            return countB != countA ? countB - countA : a - b;
        });

        return years.get(0);
    }

    /**
     * 计算当前年份出生的人数。
     * @param logs logs数组
     * @param year 要计算人数的年份
     * @return 当前，年份的人数。
     */
    private int countYear(int[][] logs, int year) {
        int count = 0;
        for (int[] log : logs) {
            if (year >= log[0] && year < log[1]) {
                count++;
            }
        }

        return count;
    }
}