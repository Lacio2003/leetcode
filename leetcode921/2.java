/*
    在上一个的基础上进行代码的优化

    时间复杂度:O(n)
    空间复杂度:O(1)
*/
class Solution {
    public int minAddToMakeValid(String s) {
        // 准备变量
        // leftCount是左括号的数量
        // rightCount是右括号的数量
        int leftCount = 0, rightCount = 0;

        // 开始遍历
        for (char c : s.toCharArray()) {
            if (c == '(') {
                // 遇到左括号
                leftCount++;
            } else {
                // 遇到右括号
                // 如果栈不为空，并且栈顶是左括号，那么弹出栈顶元素
                if (leftCount > 0) {
                    leftCount--;
                    continue;
                }
                // 栈中没有对应的左括号，说明这个右括号没有左括号可以匹配
                rightCount++;
            }
        }

        return leftCount + rightCount;
    }
}