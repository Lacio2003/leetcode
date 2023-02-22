/*
    使用一个pos，来记录可以放置石头的变量
    如果遇到石头，放在pos的位置上，pos--，然后将原来的石头的位置置空
    如果遇到*，pos--

    时间复杂度:O(n^2)
    空间复杂度:O(1)
*/
class Solution {
    public char[][] rotateTheBox(char[][] box) {
        // 将石头放在正确的位置上
        int m = box.length, n = box[0].length;
        for (int i = 0; i < m; i++) {
            // 石头可以放置的正确位置
            int pos = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                if (box[i][j] == '#') {
                    // 遇到石头，放在正确的位置上
                    box[i][pos] = '#';

                    // 将起始位置的石头排除在外
                    if (pos != j) {
                        box[i][j] = '.';
                    }
                    pos--;
                } else if (box[i][j] == '*') {
                    // 遇到障碍物，更新pos
                    pos = j - 1;
                }
            }
        }

        // 将结果拷贝到答案数组
        char[][] ans = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[j][m - 1 - i] = box[i][j];
           }
        }

        return ans;
    }
}