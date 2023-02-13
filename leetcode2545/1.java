/*
    如何比较两个学生的大小关系
        通过k直接访问就可以了
    如何进行排序?
        可以将每一个学生封装成一个对象，然后对对象排序，接着将对象里面的数据读出来。
    
    时间复杂度:O(nlogn)
    空间复杂度:O(n)
*/
class Solution {
    private class Student {
        int[] arrScore;
        int kSocre;

        public Student(int[] arr, int k) {
            this.arrScore = arr;
            this.kSocre = k;
        }
    }
    public int[][] sortTheStudents(int[][] score, int k) {
        // 先封装对象，并将对象放到一个数组里面。
        int m = score.length, n = score[0].length;
        Student[] students = new Student[m];
        int index = 0;
        for (int[] e : score) {
            students[index++] = new Student(e, e[k]);
        }

        // 对对象进行排序
        Arrays.sort(students, (a, b) -> b.kSocre - a.kSocre);

        // 将数据读出来
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            int[] cur = students[i].arrScore;
            for (int j = 0; j < n; j++) {
                ans[i][j] = cur[j];
            }
        }

        return ans;
    }
}