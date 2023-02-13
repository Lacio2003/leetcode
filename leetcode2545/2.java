/*
    直接使用内置函数对象进行排序即可。
    时间复杂度:O(nlogn)
    空间复杂度:O(1)
*/
class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, (a, b) -> b[k] - a[k]);
        return score;
    }
}