/**
 * 思路：
 * 1)计算每一个年份的人口数。
 * 2)当年年份和答案年份做比较，更新答案年份。
 * 3)返回结果
 * 
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 */
class Solution {
    public int maximumPopulation(int[][] logs) {
        // 答案年份以及当年年份对应的人口数
        int ansYear = Integer.MAX_VALUE, countPeople = Integer.MIN_VALUE;

        for (int[] log : logs) {
            int year = log[0], currentCount = countYear(logs, year);
            if (currentCount > countPeople) {
                // 人口比答案年份大，直接更新
                ansYear = year;
                countPeople = currentCount;
            } else if (currentCount == countPeople) {
                // 人口相同，选择年份最小的
                ansYear = Math.min(ansYear, year);
            }
        }

        return ansYear;
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