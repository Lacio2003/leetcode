/**
 * 根据题目的意思可以知道。students减的是对应的圆形和方形三明治的数量。
 * 1.先统计students中圆形和方形三明治的数量。
 * 2.遍历sandwiches，根据sandwiches[i]的值，减去对应的三明治的数量。
 *  如果有一个为0，还需继续减少，则停止。
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        // 统计圆形三明治和方形方形三明治的数量
        int square = Arrays.stream(students).sum();
        int circle = students.length - square;

        for (int i = 0; i < students.length; i++) {
            if (sandwiches[i] == 1 && square > 0) {
                square--;
            } else if (sandwiches[i] == 0 && circle > 0) {
                circle--;
            } else {
                break;
            }
        }

        return circle + square;
    }
}