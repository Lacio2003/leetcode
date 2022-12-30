/**
 * 思路：利用BFS的思想，每次求取一个位置的相邻的两个位置。
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
class Solution {
    public int[] shortestToChar(String s, char c) {
        // 为了方便使用，将s的程度存储在变量当中
        int n = s.length();
        // 存放答案的数组
        int[] ans = new int[n];
        // BFS所需要的队列
        Deque<Integer> queue = new LinkedList<>();
        // 将c的位置入队，并且将ans的值置为-1
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                queue.offer(i);
                // c的位置是0，这是求其他的位置的基础
                ans[i] = 0;
            } else {
                ans[i] = -1;
            }
        }

        // 每次求取相邻的两个位置
        int[] index = {-1, 1};
        while (!queue.isEmpty()) {
            int t = queue.poll();
            for (int e : index) {
                int position = t + e;
                // 相邻两个位置合法
                if (position >= 0 && position < n && ans[position] == -1) {
                    ans[position] = ans[t] + 1;
                    queue.offer(position);
                }
            }
        }

        return ans;
    }
}