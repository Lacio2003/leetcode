/*
    根据题意可以知道，其实就是将栈的最大深度平均分成A和B，那么我们就可以将奇数深度分给A，将偶数的深度
    分给B

    时间复杂度:O(n)
    空间复杂度:O(n)
*/
class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        // 准备变量
        int depth = 0;
        int n = seq.length();
        int[] ans = new int[n];

        // 开始遍历
        for (int i = 0; i < n; i++) {
            char c = seq.charAt(i);
            if (c == '(') {
                // 按照括号的深度，平均分给A和B
                ans[i] = depth % 2; 
                depth++;
            } else {
                depth--;
                ans[i] = depth % 2;
            }
        }

        return ans;
    }
}