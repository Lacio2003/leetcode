/*
    也不可以不切割，自己手动遍历
    时间复杂度:O(n)
    空间复杂度:O(n)
*/
class Solution {
    public String reverseWords(String s) {
        // 1.准备变量
        StringBuilder ans = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n;) {
            // 找到一个单词
            int j = i;
            while (j < n && s.charAt(j) != ' ') {
                j++;
            }

            // 倒序加入单词
            for (int k = j - 1; k >= i; k--) {
                ans.append(s.charAt(k));
            }

            // 添加空格
            if (j < n) {
                ans.append(' ');
            }

            i = j + 1;
        }

        return ans.toString();
    }
}