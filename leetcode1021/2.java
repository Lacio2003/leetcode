/*
    在上一个的基础上进行优化

    时间复杂度:O(n)
    空间复杂度:O(n)
*/
class Solution {
    public String removeOuterParentheses(String s) {
        // 准备变量
        int cnt = 0;
        Set<Integer> positions = new HashSet<>();

        // 开始遍历
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                if (cnt == 0) {
                    // 遇到外层的左括号
                    positions.add(i);
                }
                cnt++;
            } else {
                cnt--;
                if (cnt == 0) {
                    // 遇到外层的右括号
                    positions.add(i);
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            // 跳过外层括号
            if (!positions.contains(i)) {
                ans.append(s.charAt(i));
            }
        }

        return ans.toString();
    }
}