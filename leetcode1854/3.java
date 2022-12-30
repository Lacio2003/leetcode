/**
 * 思路：计算变化量。可以使用一个数组。数组的下标代表对应的年份。遍历logs。对应的
 * 出生年份加一，死亡年份减一。最后i年份的人口数量就是[0...i]的和。(假如说是1960年生，那么1960一定在前面的所有人活着的时候。假如说前面有人是1950生，1955死。那么因为我们会进行对应的年份的加减操作。所以这个人不会计算。)
 * 时间复杂度:O(n + C)，其中n为logs的长度。C为年份差。根据题目要求，共有100年。
 * 空间复杂度:O(C)
 */
class Solution {
    public int maximumPopulation(int[][] logs) {
		// 对应年份的数组
        int[] diff = new int[101];
		
		// 遍历logs，计算年份变化量。
		// 对出生年份进行+1， 死亡年份减一
        for (int[] log : logs) {
            diff[log[0] - 1950]++;
            diff[log[1] - 1950]--;
        }

		// max为最大的年份变化量
		// year为最大年份
		// sum为数组的和
        int max = 0, year = 0, sum = 0;
        for (int i = 0; i < 101; i++) {
			// 当前年份的人口量
            sum += diff[i];
            if (sum > max) {
				// 人口量比max大进行更新。
				// 并不用对sum == max的时候进行判断，因为是从大到小遍历的
                max = sum;
                year = i;
            }
        }

		// 返回最大年份
        return 1950 + year;
    }
}